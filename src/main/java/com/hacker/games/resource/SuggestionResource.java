package com.hacker.games.resource;

import com.hacker.games.dto.Input;
import com.hacker.games.repo.BodyPartRepository;
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
    BodyPartRepository bodyPartRepository;

    @RequestMapping(value = "/getSuggestions",method = RequestMethod.POST)
    public List<?> getSuggestions(@RequestBody List<Input> inputs) throws Exception{
        return bodyPartRepository.findAll();
    }

}
