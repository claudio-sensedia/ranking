package com.sensedia.ranking.domain.service.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import lombok.Data;

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

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonProperty("registered_at")
  private LocalDateTime registeredAt;

  @JsonProperty("user_id")
  private String userId;

  @JsonProperty("match_id")
  private String matchId;

}
