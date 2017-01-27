package com.hacker.games.api.model;

import com.hacker.games.model.Gadget;
import com.hacker.games.model.Video;

import java.util.Set;

/**
 * Created by alireza.fallahi on 27/01/2017.
 */
public class ResponseContent {

    private Set<Gadget> gadgetSet;

    private Set<Video> videoSet;

    public Set<Gadget> getGadgetSet() {
        return gadgetSet;
    }

    public void setGadgetSet(Set<Gadget> gadgetSet) {
        this.gadgetSet = gadgetSet;
    }

    public Set<Video> getVideoSet() {
        return videoSet;
    }

    public void setVideoSet(Set<Video> videoSet) {
        this.videoSet = videoSet;
    }
}
