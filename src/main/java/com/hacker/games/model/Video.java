package com.hacker.games.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by eniko.pal on 26/01/2017.
 */
@Entity
@Table(name = "video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name = "youtube_id")
    private String youtubeId;

    @Column(name = "video_blurb")
    private String videoBlurb;

//    private Set<Gadget> gadgets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getVideoBlurb() {
        return videoBlurb;
    }

    public void setVideoBlurb(String videoBlurb) {
        this.videoBlurb = videoBlurb;
    }

    //    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "videos")
//    public Set<Gadget> getGadgets() {
//        return gadgets;
//    }
//
//    public void setGadgets(Set<Gadget> gadgets) {
//        this.gadgets = gadgets;
//    }
}
