package com.hacker.games.resource;

import com.hacker.games.repo.BodyPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/getSuggestions")
    public List<?> getSuggestions(){
        return bodyPartRepository.findAll();
    }
}
