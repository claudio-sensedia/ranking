package com.sensedia.ranking.domain.repository;

import com.sensedia.ranking.domain.UserRanking;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author claudioed on 28/05/18.
 * Project ranking
 */
public interface UserRankingRepository extends CrudRepository<UserRanking,String> {

  List<UserRanking> findAllByOrderByPoints();

}
