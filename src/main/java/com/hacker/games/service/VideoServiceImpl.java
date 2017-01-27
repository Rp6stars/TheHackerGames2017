package com.hacker.games.service;

import com.hacker.games.model.Gadget;
import com.hacker.games.model.Video;
import com.hacker.games.repo.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eniko.pal on 27/01/2017.
 */
@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    VideoRepository videoRepository;

    @Override
    public List<Video> getVideosForGadgetList(List<Gadget> gadgetList) {
        List<Video> videoList = new ArrayList<>();

        for (Gadget gadget : gadgetList) {
            videoList.addAll(videoRepository.findByGadgetId(gadget.getId()));
        }

        return videoList;
    }
}
