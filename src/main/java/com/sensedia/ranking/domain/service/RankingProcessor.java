package com.sensedia.ranking.domain.service;

import com.sensedia.ranking.domain.BetResult;
import com.sensedia.ranking.domain.service.data.BetData;
import com.sensedia.ranking.domain.service.data.IncrementPointRequest;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author claudioed on 28/05/18. Project ranking
 */
@Slf4j
@Service
public class RankingProcessor {

  private final RankingService rankingService;

  private final BetResultService betResultService;

  public RankingProcessor(RankingService rankingService,
      BetResultService betResultService) {
    this.rankingService = rankingService;
    this.betResultService = betResultService;
  }

  @RabbitListener(queuesToDeclare = {@Queue("${ranking.user.queue}")})
  public void process(BetData betData) {
    log.info(
        "Recived message from rabbitmq-> betId={} matchId={} points={} registredAt={} ",
        betData.getBetId(), betData.getMatchId(), betData.getPoints(), betData.getRegisteredAt());
    val increment = IncrementPointRequest.builder().matchId(betData.getMatchId())
        .points(betData.getPoints()).userId(betData.getUserId()).build();
    val betResult = BetResult.builder().betId(betData.getBetId()).matchId(betData.getMatchId())
        .points(betData.getPoints()).userId(betData.getUserId()).registeredAt(LocalDateTime.now())
        .build();
    this.rankingService.ranking(increment);
    this.betResultService.register(betResult);
  }

}
