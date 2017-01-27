package com.hacker.games.service;

import com.hacker.games.model.Gadget;
import com.hacker.games.model.Video;
import com.hacker.games.repo.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by eniko.pal on 27/01/2017.
 */
@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    VideoRepository videoRepository;

    @Override
    public Set<Video> getVideosForGadgetSet(Set<Gadget> gadgetSet) {
        Set<Video> videos = new HashSet<>();

        for (Gadget gadget : gadgetSet) {
            videos.addAll(videoRepository.findByGadgetId(gadget.getId()));
        }

        return videos;
    }
}
