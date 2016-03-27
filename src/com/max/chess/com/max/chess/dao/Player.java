package com.max.chess.com.max.chess.dao;

/**
 * Created by User on 27.03.2016.
 */
public class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Player: display " + name);
    }

    public String getName() {
        return name;
    }
}
