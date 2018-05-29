package com.sensedia.ranking.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author claudioed on 28/05/18.
 * Project ranking
 */
@Data
@Document(collection = "ranking")
public class UserRanking {

  @Field("user_id")
  private String userId;

  private Long bets;

  private Long points;

}
