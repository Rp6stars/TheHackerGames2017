package com.hacker.games.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by eniko.pal on 26/01/2017.
 */
@Entity
@NamedQuery(name = "Video.findByGadgetId",
        query = "SELECT v FROM Video v JOIN v.gadgetIDs g where g = ?1")
@Table(name = "video")
public class Video implements Content{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name = "youtube_id")
    private String youtubeId;

    @Column(name = "video_blurb")
    private String videoBlurb;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="gadget_video",joinColumns=@JoinColumn(name="video_id"))
    @Column(name="gadget_id")
    private List<Integer> gadgetIDs;

// private Set<Gadget> gadgets;

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

    public List<Integer> getGadgetIDs() {
        return gadgetIDs;
    }

    public void setGadgetIDs(List<Integer> gadgetIDs) {
        this.gadgetIDs = gadgetIDs;
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
