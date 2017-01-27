package com.hacker.games.resource;

import com.hacker.games.dto.Input;
import com.hacker.games.model.Content;
import com.hacker.games.model.Gadget;
import com.hacker.games.model.GadgetSuggestion;
import com.hacker.games.model.Video;
import com.hacker.games.service.SuggestionService;
import com.hacker.games.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
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
    public List<Content> getSuggestions(@RequestBody List<Input> inputs) throws Exception {

        List<Content> contents = new ArrayList<>();
        List<List<GadgetSuggestion>> gadgetSuggestions = suggestionService.getSuggestions(inputs);
        List<Gadget> lstOfGadgets = new ArrayList<>();
        for(List<GadgetSuggestion> InnerlstOfGadgetSuggestions : gadgetSuggestions){
            for(GadgetSuggestion gs: InnerlstOfGadgetSuggestions) {
                lstOfGadgets.add(gs.getGadget());
            }
        }
        List<Video> videoList = videoService.getVideosForGadgetList(lstOfGadgets);
        contents.addAll(videoList);
        contents.addAll(lstOfGadgets);
        return contents;
    }
}
