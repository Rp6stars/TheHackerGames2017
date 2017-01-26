package com.hacker.games.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by eniko.pal on 26/01/2017.
 */
@Entity
@Table(name = "gadget_suggestion")
public class GadgetSuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "body_part_id")
    private BodyPart bodypart;

    @ManyToOne
    @JoinColumn(name = "mobility_score_id")
    private MobilityScore mobilityScore;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "gadget_id")
    private Gadget gadget;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BodyPart getBodypart() {
        return bodypart;
    }

    public void setBodypart(BodyPart bodypart) {
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
