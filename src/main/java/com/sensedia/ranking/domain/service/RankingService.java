package com.sensedia.ranking.domain.service;

import com.sensedia.ranking.domain.service.data.IncrementPointRequest;
import lombok.NonNull;
import lombok.val;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author claudioed on 28/05/18.
 * Project ranking
 */
@Service
public class RankingService {

  private static final String LEADER_BOARD_KEY = "leaderboard";

  private static final String ROUND_KEY = "round_%s";

  private static final String USER_POINTS_KEY = "user:%s:points";

  private static final String USER_BETS_KEY = "user:%s:bets";

  private final RedisTemplate<String, String> redisTemplate;

  public RankingService(RedisTemplate<String, String> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public void ranking(@NonNull IncrementPointRequest incrementPointRequest) {
    this.redisTemplate.opsForZSet()
        .add(String.format(ROUND_KEY, incrementPointRequest.getMatchId()),
            incrementPointRequest.getUserId(), Double.valueOf(incrementPointRequest.getPoints()));
    val userPoints = this.redisTemplate.opsForValue()
        .increment(String.format(USER_POINTS_KEY, incrementPointRequest.getUserId()),
            incrementPointRequest.getPoints());
    this.redisTemplate.opsForValue()
        .increment(String.format(USER_BETS_KEY, incrementPointRequest.getUserId()),
            1L);
    this.redisTemplate.opsForZSet()
        .add(LEADER_BOARD_KEY, incrementPointRequest.getUserId(), Double.valueOf(userPoints));
  }

}
