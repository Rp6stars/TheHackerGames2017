package com.hacker.games.service;

import com.hacker.games.api.model.Input;
import com.hacker.games.api.model.ResponseContent;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alireza.fallahi on 26/01/2017.
 */
@Service
public interface SuggestionService {

    ResponseContent getSuggestions(List<Input> inputs);
}
