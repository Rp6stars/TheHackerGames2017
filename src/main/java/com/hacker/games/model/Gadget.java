package com.hacker.games.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by eniko.pal on 26/01/2017.
 */
@Entity
@Table(name = "gadget")
public class Gadget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    private String description;

    @Column(name = "pic_url")
    private String pictureUrl;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "gadget_video", joinColumns = @JoinColumn(name = "gadget_id"),
//            inverseJoinColumns = @JoinColumn(name = "video_id"))
//    private Set<Video> videos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

//    public Set<Video> getVideos() {
//        return videos;
//    }
//
//    public void setVideos(Set<Video> videos) {
//        this.videos = videos;
//    }
}
