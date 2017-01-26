package com.hacker.games.service;

import com.hacker.games.dto.Input;
import com.hacker.games.model.GadgetSuggestion;
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
    @Override
    public List<GadgetSuggestion> getSuggestions(List<Input> inputs) {
        List<GadgetSuggestion> gadgetSuggestions = new ArrayList<>();
        for(Input input: inputs) {
            gadgetSuggestions.add(gadgetSuggestionRepository.findOne(Integer.valueOf(input.getValue())));
        }
        return null;
    }
}
