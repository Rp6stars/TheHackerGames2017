package com.hacker.games.resource;

import com.hacker.games.dto.Input;
import com.hacker.games.repo.VideoRepository;
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

    @Autowired
    VideoRepository videoRepository;

    @RequestMapping(value = "/getSuggestions",method = RequestMethod.POST)
    public List<?> getSuggestions(@RequestBody List<Input> inputs) throws Exception{
        return suggestionService.getSuggestions(inputs);
    }

    @RequestMapping(value = "/getSuggestions",method = RequestMethod.GET)
    public List<?> getSuggestions() throws Exception{
        return videoRepository.findAll();
    }

}
