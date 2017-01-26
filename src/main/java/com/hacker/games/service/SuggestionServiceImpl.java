package com.hacker.games.service;

import com.hacker.games.dto.Input;
import com.hacker.games.model.GadgetSuggestion;
import com.hacker.games.repo.BodyPartRepository;
import com.hacker.games.repo.GadgetSuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alireza.fallahi on 26/01/2017.
 */
@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Autowired
    GadgetSuggestionRepository gadgetSuggestionRepository;
    @Autowired
    BodyPartRepository bodyPartRepository;

    @Override
    public List<List<GadgetSuggestion>> getSuggestions(List<Input> inputs) {

        List<List<GadgetSuggestion>> gadgetSuggestions= new ArrayList<>();
        for(Input input: inputs) {
            input.setId(bodyPartRepository.findByNameLike(input.getName()).getId());
        }

        for(Input input:inputs) {
            gadgetSuggestions.add(gadgetSuggestionRepository.findByMobilityScoreIdAndBodyPartId(Integer.valueOf(input.getValue()), input.getId()));
        }

        return gadgetSuggestions;
    }
}
