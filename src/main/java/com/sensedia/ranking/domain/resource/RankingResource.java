package com.sensedia.ranking.domain.resource;

import com.sensedia.ranking.domain.UserRanking;
import com.sensedia.ranking.domain.service.RankingDataService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author claudioed on 28/05/18.
 * Project ranking
 */
@RestController
@RequestMapping("/api/rankings")
public class RankingResource {

  private final RankingDataService rankingDataService;

  public RankingResource(RankingDataService rankingDataService) {
    this.rankingDataService = rankingDataService;
  }

  @GetMapping
  public List<UserRanking> rankings(){
    return this.rankingDataService.data();
  }

}
