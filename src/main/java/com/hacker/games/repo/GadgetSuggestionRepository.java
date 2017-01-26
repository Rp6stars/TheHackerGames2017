package com.hacker.games.repo;

import com.hacker.games.model.GadgetSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Created by alireza.fallahi on 26/01/2017.
 */
public interface GadgetSuggestionRepository extends JpaRepository<GadgetSuggestion,Integer> {

    @Query(value = "SELECT gsr FROM GadgetSuggestion gsr where gsr.mobilityScore = :mobility_score_id")
    List<GadgetSuggestion> getGadgetSuggestionsByMobilityScoreIdAndBodyPartId(@Param("mobility_score_id") final Integer mobilityScore);
}
