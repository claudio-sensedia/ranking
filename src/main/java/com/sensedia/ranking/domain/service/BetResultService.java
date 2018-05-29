package com.sensedia.ranking.domain.service;

import com.sensedia.ranking.domain.BetResult;
import com.sensedia.ranking.domain.repository.BetResultRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author claudioed on 28/05/18.
 * Project ranking
 */
@Service
public class BetResultService {

  private final BetResultRepository betResultRepository;

  public BetResultService(BetResultRepository betResultRepository) {
    this.betResultRepository = betResultRepository;
  }

  public BetResult register(@NonNull BetResult betResult){
    return this.betResultRepository.save(betResult);
  }

}
