package com.hacker.games.service;

import com.hacker.games.model.Gadget;
import com.hacker.games.model.Video;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by eniko.pal on 27/01/2017.
 */
@Service
public interface VideoService {

    Set<Video>  getVideosForGadgetSet(Set<Gadget> gadgetSet);
}
