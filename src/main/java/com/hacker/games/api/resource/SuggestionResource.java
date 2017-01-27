package com.hacker.games.api.resource;

import com.hacker.games.api.model.Input;
import com.hacker.games.api.model.ResponseContent;
import com.hacker.games.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by alireza.fallahi on 26/01/2017.
 */
@RestController
@RequestMapping("/")
public class SuggestionResource {

    @Autowired
    SuggestionService suggestionService;

    @RequestMapping(value = "/getSuggestions",method = RequestMethod.POST)
    public ResponseContent getSuggestions(@RequestBody List<Input> inputs) throws Exception {

        return suggestionService.getSuggestions(inputs);

    }
}
