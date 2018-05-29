package com.sensedia.ranking.domain.service.data;

import lombok.Builder;
import lombok.Value;

/**
 * @author claudioed on 28/05/18.
 * Project ranking
 */
@Value
@Builder
public class IncrementPointRequest {

  private String matchId;

  private String userId;

  private Long points;

}
