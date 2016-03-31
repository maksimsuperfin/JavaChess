package com.max.chess.com.max.chess.dao.figures;

/**
 * Created by User on 27.03.2016.
 */
abstract class Figure {
    String color;
    String name;
    int valueOnDesk;

    public Figure(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getValueOnDesk() {
        return valueOnDesk;
    }

    abstract void putOnDesk();

    abstract void move();

    abstract void checkMove();
}
