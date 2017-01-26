package com.hacker.games.repo;

import com.hacker.games.model.GadgetSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by alireza.fallahi on 26/01/2017.
 */
public interface GadgetSuggestionRepository extends JpaRepository<GadgetSuggestion,Integer> {

    List<GadgetSuggestion> findByMobilityScoreIdAndBodyPartId(Integer mobilityScoreId, Integer bodyPartId);

}
