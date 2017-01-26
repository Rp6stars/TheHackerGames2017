package com.hacker.games.service;

import com.hacker.games.dto.Input;
import com.hacker.games.model.GadgetSuggestion;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alireza.fallahi on 26/01/2017.
 */
@Service
public interface SuggestionService {

    List<GadgetSuggestion> getSuggestions(List<Input> inputs);
}
