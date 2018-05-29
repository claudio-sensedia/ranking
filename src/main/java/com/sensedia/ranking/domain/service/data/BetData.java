package com.sensedia.ranking.domain.service.data;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author claudioed on 28/05/18.
 * Project ranking
 */
@Data
public class BetData {

  @Id
  private String betId;

  private Long points;

  private LocalDateTime registeredAt;

  @Field("user_id")
  private String userId;

  @Field("match_id")
  private String matchId;

}
