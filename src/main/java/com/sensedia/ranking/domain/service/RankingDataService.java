package com.sensedia.ranking.domain.service;

import com.sensedia.ranking.domain.repository.UserRankingRepository;
import org.springframework.stereotype.Service;

/**
 * @author claudioed on 28/05/18.
 * Project ranking
 */
@Service
public class RankingDataService {

  private final UserRankingRepository userRankingRepository;

  public RankingDataService(UserRankingRepository userRankingRepository) {
    this.userRankingRepository = userRankingRepository;
  }

  public void ranking(String matchId){
    this.userRankingRepository.findAllByOrderByPoints();

  }

}
