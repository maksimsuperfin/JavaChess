package com.max.chess.com.max.chess.appl;

import com.max.chess.com.max.chess.dao.*;
import com.max.chess.com.max.chess.dao.figures.*;

/**
 * Created by User on 27.03.2016.
 */
public class MainAppl {

    public static final void main(String[] args) {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        Game game = new Game(player1, player2);
        game.displayDashBoard();
    }
}
