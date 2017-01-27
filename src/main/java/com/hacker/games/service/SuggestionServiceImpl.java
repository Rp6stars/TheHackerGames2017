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

import java.util.ArrayList;
import java.util.List;

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

        List<GadgetSuggestion> gadgetSuggestions= new ArrayList<>();
        for(Input input: inputs) {
            input.setId(bodyPartRepository.findByNameLike(input.getName()).getId());
        }

        for(Input input:inputs) {
            gadgetSuggestions.addAll(gadgetSuggestionRepository.findByMobilityScoreIdAndBodyPartId(Integer.valueOf(input.getValue()), input.getId()));
        }

        List<Gadget> listOfGadgets = new ArrayList<>();
        for (GadgetSuggestion gadgetSuggestion : gadgetSuggestions) {
            listOfGadgets.add(gadgetSuggestion.getGadget());
        }
        List<Video> videoList = videoService.getVideosForGadgetList(listOfGadgets);

        responseContent.setGadgetList(listOfGadgets);
        responseContent.setVideoList(videoList);

        return responseContent;
    }
}
