package com.hacker.games.resource;

import com.hacker.games.dto.Input;
import com.hacker.games.model.ResponseContent;
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
    VideoService videoService;

    @RequestMapping(value = "/getSuggestions",method = RequestMethod.POST)
    public ResponseContent getSuggestions(@RequestBody List<Input> inputs) throws Exception {

        ResponseContent contents = new ResponseContent();
        List<List<GadgetSuggestion>> gadgetSuggestions = suggestionService.getSuggestions(inputs);
        List<Gadget> listOfGadgets = new ArrayList<>();
        for(List<GadgetSuggestion> innerlistOfGadgetSuggestions : gadgetSuggestions){
            for(GadgetSuggestion gs: innerlistOfGadgetSuggestions) {
                listOfGadgets.add(gs.getGadget());
            }
        }
        List<Video> videoList = videoService.getVideosForGadgetList(listOfGadgets);

        contents.setGadgetList(listOfGadgets);
        contents.setVideoList(videoList);
        return contents;
    }
}
