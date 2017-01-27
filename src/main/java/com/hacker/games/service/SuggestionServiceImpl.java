package com.hacker.games.service;

import com.hacker.games.api.model.Input;
import com.hacker.games.api.model.ResponseContent;
import com.hacker.games.model.Gadget;
import com.hacker.games.model.GadgetSuggestion;
import com.hacker.games.model.Video;
import com.hacker.games.repo.BodyPartRepository;
import com.hacker.games.repo.GadgetSuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by alireza.fallahi on 26/01/2017.
 */
@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Autowired
    GadgetSuggestionRepository gadgetSuggestionRepository;
    @Autowired
    BodyPartRepository bodyPartRepository;
    @Autowired
    VideoService videoService;

    @Override
    public ResponseContent getSuggestions(List<Input> inputs) {

        ResponseContent responseContent = new ResponseContent();

        Set<GadgetSuggestion> gadgetSuggestions= new HashSet<>();
        for(Input input: inputs) {
            input.setId(bodyPartRepository.findByNameLike(input.getName()).getId());
        }

        for(Input input:inputs) {
            gadgetSuggestions.addAll(gadgetSuggestionRepository.findByMobilityScoreIdAndBodyPartId(Integer.valueOf(input.getValue()), input.getId()));
        }

        Set<Gadget> gadgets = new HashSet<>();
        for (GadgetSuggestion gadgetSuggestion : gadgetSuggestions) {
            gadgets.add(gadgetSuggestion.getGadget());
        }
        Set<Video> videoList = videoService.getVideosForGadgetSet(gadgets);

        responseContent.setGadgetSet(gadgets);
        responseContent.setVideoSet(videoList);

        return responseContent;
    }
}
