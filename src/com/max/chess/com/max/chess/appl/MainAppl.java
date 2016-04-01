package com.max.chess.com.max.chess.appl;

import com.max.chess.com.max.chess.Helper.CellsHelper;
import com.max.chess.com.max.chess.dao.*;

import java.io.IOException;

/**
 * Created by User on 27.03.2016.
 */
public class MainAppl {

    public static final void main(String[] args) throws IOException {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        Game game;
        if (args != null && args.length > 0) {
            byte[] cells = CellsHelper.getInitialCells(args[0]);
            game = new Game(player1, player2, cells);
        } else {
            game = new Game(player1, player2);
        }
        game.displayDashBoard();
    }
}
