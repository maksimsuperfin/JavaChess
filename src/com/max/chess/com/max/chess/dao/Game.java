package com.max.chess.com.max.chess.dao;

import java.util.*;

/**
 * Created by User on 27.03.2016.
 */
public class Game {
    public static final int deskSize = 8;
    Player player1, player2;
    String color1, color2;
    Map<Player, String> playersColors = new HashMap<Player, String>();
    int[][] cells = new int[deskSize][deskSize];
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
    public static final char[] columnNames = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    public static final int[] rowNumbers = {1, 2, 3, 4, 5, 6, 7, 8};

    public Game(Player player1, Player player2, String color1, String color2, int[][] cells) {
        this.player1 = player1;
        this.player2 = player2;
        this.color1 = color1;
        this.color2 = color2;
        this.cells = cells;
        playersColors.put(player1, color1);
        playersColors.put(player2, color2);
    }

    public Game(Player player1, Player player2, String color1, String color2) {
        this(player1, player2, color1, color2, initialCells);
    }

    public Game(Player player1, Player player2) {
        this(player1, player2, "white", "black", initialCells);
    }

    public void displayDashBoard() {
        displayHeader();
        for (int row = 0; row < deskSize; row++) {
            System.out.print(rowNumbers[row] + "|");
            for (int col = 0; col < deskSize; col++) {
                System.out.print(String.format("%2d", cells[row][col]));
            }
            System.out.println();
        }
    }

    private void displayHeader() {
        Set<Map.Entry<Player, String>> entries = playersColors.entrySet();
        for (Map.Entry<Player, String> entry: entries) {
            System.out.println("Player: " + entry.getKey().getName() + " has color " + entry.getValue());
        }
        System.out.print("  ");
        for (int col = 0; col < deskSize; col++) {
            System.out.print(String.format("%2s", columnNames[col]));
        }
        System.out.println();
        System.out.println("  ----------------");
    }
}
