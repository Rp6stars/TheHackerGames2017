package com.hacker.games.resource;

import com.hacker.games.dto.Input;
import com.hacker.games.model.Gadget;
import com.hacker.games.service.SuggestionService;
import com.hacker.games.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by alireza.fallahi on 26/01/2017.
 */
@RestController
@RequestMapping("/")
public class SuggestionResource {

    @Autowired
    SuggestionService suggestionService;

    @Autowired
    VideoService videoService;

    @RequestMapping(value = "/getSuggestions",method = RequestMethod.POST)
    public List<?> getSuggestions(@RequestBody List<Input> inputs) throws Exception{
        return suggestionService.getSuggestions(inputs);
    }

    @RequestMapping(value = "/getSuggestions",method = RequestMethod.GET)
    public Set<?> getSuggestions() throws Exception{
        List<Gadget> gadgets = new ArrayList<>();
        Gadget gadget = new Gadget();
        gadget.setId(1);
        gadgets.add(gadget);
        return videoService.getVideosForGadgetList(gadgets);
    }
}
