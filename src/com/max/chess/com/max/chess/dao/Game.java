package com.max.chess.com.max.chess.dao;

import com.max.chess.com.max.chess.Helper.CellsHelper;
import java.util.*;

/**
 * Created by User on 27.03.2016.
 */
public class Game {
    public static final int deskSize = 8;
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    Player player1, player2;
    String color1, color2;
    Map<Player, String> playersColors = new HashMap<Player, String>();
    byte[] cells = new byte[deskSize*deskSize];

    public static final List<String> columnNames = new ArrayList<String>(){{
        add("A");
        add("B");
        add("C");
        add("D");
        add("E");
        add("F");
        add("G");
        add("H");
    }};

    public Game(Player player1, Player player2, String color1, String color2, byte[] cells) {
        this.player1 = player1;
        this.player2 = player2;
        this.color1 = color1;
        this.color2 = color2;
        this.cells = cells;
        playersColors.put(player1, color1);
        playersColors.put(player2, color2);
    }

    public Game(Player player1, Player player2) {
        this(player1, player2, WHITE_COLOR, BLACK_COLOR, CellsHelper.getInitialCells());
    }

    public Game(Player player1, Player player2, byte[] cells) {
        this(player1, player2, WHITE_COLOR, BLACK_COLOR, cells);
    }

    public void displayDashBoard() {
        displayHeader();
        for (int row = 0; row < deskSize; row++) {
            System.out.print(deskSize - row + "|");
            for (int col = 0; col < deskSize; col++) {
                System.out.print(String.format("%2d", cells[row*deskSize + col]));
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
        for (String column: columnNames) {
            System.out.print(String.format("%2s", column));
        }
        System.out.println();
        System.out.println("  ----------------");
    }
}
