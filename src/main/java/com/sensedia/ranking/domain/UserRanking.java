package com.sensedia.ranking.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author claudioed on 28/05/18.
 * Project ranking
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRanking {

  private Integer position;

  @JsonProperty("user_id")
  private String userId;

  private Long bets;

  private Long points;

}
