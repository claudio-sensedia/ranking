package com.sensedia.ranking.domain.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.sensedia.ranking.domain.UserRanking;
import com.sensedia.ranking.domain.service.data.IncrementPointRequest;
import lombok.NonNull;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @author claudioed on 28/05/18.
 * Project ranking
 */
@Service
public class RankingService {

  private static final String RANKING_POINTS_FIELD = "points";

  private static final String RANKING_BETS_FIELD = "bets";

  private final MongoOperations mongoOperations;

  public RankingService(MongoOperations mongoOperations) {
    this.mongoOperations = mongoOperations;
  }

  public UserRanking ranking(@NonNull IncrementPointRequest incrementPointRequest){
    return mongoOperations.findAndModify(
        query(where("user_id").is(incrementPointRequest.getUserId())),
        new Update().inc(RANKING_POINTS_FIELD, incrementPointRequest.getPoints())
            .inc(RANKING_BETS_FIELD, incrementPointRequest.getPoints()),
        options().returnNew(true),
        UserRanking.class);
  }

}
