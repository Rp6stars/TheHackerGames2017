package com.hacker.games.api.model;

import com.hacker.games.model.Gadget;
import com.hacker.games.model.Video;

import java.util.List;

/**
 * Created by alireza.fallahi on 27/01/2017.
 */
public class ResponseContent {

    private List<Gadget> gadgetList;

    private List<Video> videoList;

    public List<Gadget> getGadgetList() {
        return gadgetList;
    }

    public void setGadgetList(List<Gadget> gadgetList) {
        this.gadgetList = gadgetList;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }
}
