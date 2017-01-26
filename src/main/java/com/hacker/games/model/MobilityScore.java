package com.hacker.games.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by eniko.pal on 26/01/2017.
 */
@Entity
@Table(name = "mobility_score")
public class MobilityScore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String scale;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }
}
