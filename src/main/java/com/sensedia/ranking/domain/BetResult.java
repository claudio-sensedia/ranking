package com.sensedia.ranking.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author claudioed on 28/05/18.
 * Project ranking
 */
@Data
@Document(collection = "bet_results")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BetResult {

  @Id
  @Field("bet_id")
  private String betId;

  private Long points;

  @Field("registered_at")
  private LocalDateTime registeredAt;

  @Field("user_id")
  private String userId;

  @Field("match_id")
  private String matchId;

}
