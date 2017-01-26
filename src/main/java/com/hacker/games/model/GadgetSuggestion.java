package com.hacker.games.model;

import javax.persistence.*;

/**
 * Created by eniko.pal on 26/01/2017.
 */
@Entity
@NamedQuery(name = "GadgetSuggestion.findByMobilityScoreIdAndBodyPartId",
        query = "SELECT gs FROM GadgetSuggestion gs WHERE gs.mobilityScoreId = ?1 AND gs.bodypartId = ?2")
@Table(name = "gadget_suggestion")
public class GadgetSuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "body_part_id")
    private int bodypartId;

    @Column(name = "mobility_score_id")
    private int mobilityScoreId;

//    @ManyToOne
//    @JoinColumn(name = "body_part_id")
//    private BodyPart bodypart;
//
//    @ManyToOne
//    @JoinColumn(name = "mobility_score_id")
//    private MobilityScore mobilityScore;

    @ManyToOne
    @JoinColumn(name = "gadget_id")
    private Gadget gadget;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public BodyPart getBodypart() {
//        return bodypart;
//    }
//
//    public void setBodypart(BodyPart bodypart) {
//        this.bodypart = bodypart;
//    }
//
//    public MobilityScore getMobilityScore() {
//        return mobilityScore;
//    }
//
//    public void setMobilityScore(MobilityScore mobilityScore) {
//        this.mobilityScore = mobilityScore;
//    }

    public Gadget getGadget() {
        return gadget;
    }

    public void setGadget(Gadget gadget) {
        this.gadget = gadget;
    }

    public int getBodypartId() {
        return bodypartId;
    }

    public void setBodypartId(int bodypartId) {
        this.bodypartId = bodypartId;
    }

    public int getMobilityScoreId() {
        return mobilityScoreId;
    }

    public void setMobilityScoreId(int mobilityScoreId) {
        this.mobilityScoreId = mobilityScoreId;
    }
}
