package com.max.chess.com.max.chess.dao;

import java.util.*;

/**
 * Created by User on 27.03.2016.
 */
public class Game {
    Player player1, player2;
    String color1, color2;
    Map<Player, String> playersColors = new HashMap<Player, String>();
    int[][] cells = new int[8][8];
    public static final int[][] initialCells = {
        {-4, -2, -3, -5, -6, -3, -2, -4},
        {-1, -1, -1, -1, -1, -1, -1, -1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 1, 1, 1},
        {4, 2, 3, 5, 6, 3, 2, 4}
    };

    /*private static final int first_row_idx = 7;
    private static final int last_row_idx = 0;
    private static final int first_col_idx = 0;
    private static final int last_col_idx = 7;*/

    public Game(Player player1, Player player2, String color1, String color2, int[][] cells) {
        this.player1 = player1;
        this.player2 = player2;
        this.color1 = color1;
        this.color2 = color2;
        playersColors.put(player1, color1);
        playersColors.put(player2, color2);
        this.cells = cells;
    }

    public Game(Player player1, Player player2, String color1, String color2) {
        this(player1, player2, color1, color2, initialCells);
    }

    public Game(Player player1, Player player2) {
        this(player1, player2, "white", "black", initialCells);
    }

    private void displayDashBoard() {
        //System.out.println("Game: displayDashBoard");
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                System.out.print(String.format("%-2d", cells[row][col]));
            }
            System.out.println();
        }
    }

    public void currentPosition() {
        System.out.println("Game: currentPosition");
        Set<Map.Entry<Player, String>> entries = playersColors.entrySet();
        for (Map.Entry<Player, String> entry: entries) {
            System.out.println("Player: " + entry.getKey().getName() + " has color " + entry.getValue());
        }
        displayDashBoard();
    }
}
