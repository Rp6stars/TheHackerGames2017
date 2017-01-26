package com.hacker.games.model;

import javax.persistence.*;

/**
 * Created by eniko.pal on 26/01/2017.
 */
@Entity
@Table(name = "gadget_suggestion")
public class GadgetSuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "body_part_id")
    private Bodypart bodypart;

    @ManyToOne
    @JoinColumn(name = "mobility_score_id")
    private MobilityScore mobilityScore;

    @ManyToOne
    @JoinColumn(name = "gadget_id")
    private Gadget gadget;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bodypart getBodypart() {
        return bodypart;
    }

    public void setBodypart(Bodypart bodypart) {
        this.bodypart = bodypart;
    }

    public MobilityScore getMobilityScore() {
        return mobilityScore;
    }

    public void setMobilityScore(MobilityScore mobilityScore) {
        this.mobilityScore = mobilityScore;
    }

    public Gadget getGadget() {
        return gadget;
    }

    public void setGadget(Gadget gadget) {
        this.gadget = gadget;
    }
}
