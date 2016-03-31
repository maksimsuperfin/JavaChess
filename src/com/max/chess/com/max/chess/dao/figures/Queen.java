package com.max.chess.com.max.chess.dao.figures;

/**
 * Created by User on 27.03.2016.
 */
public class Queen extends Figure {

    public Queen(String color) {
        super(color);
        this.valueOnDesk = 5;
        this.name = this.getClass().getName();
    }

    @Override
    void putOnDesk() {

    }

    @Override
    void move() {

    }

    @Override
    void checkMove() {

    }
}
