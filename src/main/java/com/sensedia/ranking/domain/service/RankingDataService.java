package com.sensedia.ranking.domain.service;

import com.sensedia.ranking.domain.UserRanking;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.val;
import one.util.streamex.EntryStream;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Service;

/**
 * @author claudioed on 28/05/18.
 * Project ranking
 */
@Service
public class RankingDataService {

  private static final String LEADER_BOARD_KEY = "leaderboard";

  private static final String USER_BETS_KEY = "user:%s:bets";

  private final RedisTemplate<String, String> redisTemplate;

  public RankingDataService(RedisTemplate<String, String> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public List<UserRanking> data() {
    final Long rankSize = this.redisTemplate.opsForZSet().size(LEADER_BOARD_KEY);
    final Set<TypedTuple<String>> rankingRawData = this.redisTemplate.opsForZSet()
        .reverseRangeWithScores(LEADER_BOARD_KEY, 0, rankSize);
    final List<TypedTuple<String>> tuples = rankingRawData.stream().collect(Collectors.toList());
    return EntryStream.of(tuples).map((index) -> {
      val position = index.getKey()+1;
      val tuple = index.getValue();
      val bets = this.redisTemplate.opsForValue()
          .get(String.format(USER_BETS_KEY, tuple.getValue()));
      return UserRanking.builder().bets(Long.valueOf(bets)).position(position)
          .points(tuple.getScore().longValue()).userId(tuple.getValue()).build();
    }).collect(Collectors.toList());
  }

}
