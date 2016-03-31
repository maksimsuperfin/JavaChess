package com.max.chess.com.max.chess.dao.figures;

/**
 * Created by User on 27.03.2016.
 */
public class Pawn extends Figure {

    public Pawn(String color) {
        super(color);
        this.valueOnDesk = 1;
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
