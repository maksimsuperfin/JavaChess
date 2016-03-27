package com.max.chess.com.max.chess.dao.figures;

/**
 * Created by User on 27.03.2016.
 */
abstract class Figure {
    String color;
    String name;

    public Figure(String color, String name) {
        this.color = color;
        this.name = name;
    }


    abstract void putOnDesk();

    abstract void move();

    abstract void checkMove();
}
