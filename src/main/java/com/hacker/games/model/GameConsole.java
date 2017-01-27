package com.hacker.games.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by eniko.pal on 27/01/2017.
 */
@Entity
@Table(name = "game_console")
public class GameConsole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

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
}
