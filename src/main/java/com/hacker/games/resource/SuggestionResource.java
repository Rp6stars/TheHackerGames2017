package com.hacker.games.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alireza.fallahi on 26/01/2017.
 */
@RestController
@RequestMapping("/")
public class SuggestionResource {

    @RequestMapping("/getSuggestions")
    public String getSuggestions(){
        return "hi";
    }
}
