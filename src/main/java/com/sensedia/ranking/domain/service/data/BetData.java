package com.sensedia.ranking.domain.service.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author claudioed on 28/05/18.
 * Project ranking
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BetData {

  @JsonProperty("bet_id")
  private String betId;

  private Long points;

  @JsonProperty("registered_at")
  private LocalDateTime registeredAt;

  @JsonProperty("user_id")
  private String userId;

  @JsonProperty("match_id")
  private String matchId;

}
