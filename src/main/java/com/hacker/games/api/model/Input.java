package com.hacker.games.api.model;

/**
 * Created by alireza.fallahi on 26/01/2017.
 */
public class Input {

    String name; // the body part name
    String value;// the scoring

    int id; // the body part id which we populate at run-time

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
