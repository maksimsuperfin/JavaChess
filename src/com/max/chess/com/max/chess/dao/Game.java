package com.max.chess.com.max.chess.dao;

import com.max.chess.com.max.chess.dao.figures.*;
import java.util.*;

/**
 * Created by User on 27.03.2016.
 */
public class Game {
    public static final int deskSize = 8;
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "white";

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

    public Game(Player player1, Player player2, String color1, String color2) {
        this(player1, player2, color1, color2, getInitialCells());
    }

    public Game(Player player1, Player player2) {
        this(player1, player2, WHITE_COLOR, BLACK_COLOR, getInitialCells());
    }

    private static byte[] getInitialCells() {
        byte[] result = new byte[deskSize*deskSize];
        // fill pawns
        int whitePawnsRow = deskSize - 2;
        for (int column = 0; column < deskSize; column++) {
            result[whitePawnsRow*deskSize + column] = 1;
        }
        int blackPawnsRow = 1;
        for (int column = 0; column < deskSize; column++) {
            result[blackPawnsRow*deskSize + column] =-1;
        }
        int whiteKingRow = deskSize - 1;
        int whiteIdx = whiteKingRow*deskSize - 1;
        // Rooks
        result[whiteIdx + 1] = 4; result[whiteIdx + deskSize] = 4;
        result[0] =-4; result[deskSize - 1] =-4;
        // Knights
        result[whiteIdx + 2] = 2; result[whiteIdx + deskSize - 1] = 2;
        result[1] =-2; result[deskSize - 2] =-2;
        // Bishops
        result[whiteIdx + 3] = 3; result[whiteIdx + deskSize - 2] = 3;
        result[2] =-3; result[deskSize - 3] =-3;
        // Queens
        result[whiteIdx + 4] = 5; result[3] =-5;
        // Kings
        result[whiteIdx + 5] = 6; result[4] =-6;

        return result;
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
        /*for (int col = 0; col < deskSize; col++) {
            System.out.print(String.format("%2s", columnNames[col]));
        }*/
        System.out.println();
        System.out.println("  ----------------");
    }

    public void fillInitialPositions() {
        System.out.println("Please fill positions for figures in format: p A2 for pawn that should be set in position A2.");
        System.out.println("Possible values for figures: p for pawn, r for Rook, k for Knight, b for Bishop, q for Queen, i for King");
        System.out.println("Fill white figures (one in a line) and type COMPLETE after it: ");
        Scanner scanner = new Scanner(System.in);
        String userLine;
        while (scanner.hasNextLine()) {
            userLine = scanner.nextLine();
            if ("COMPLETE".equals(userLine)) {
                break;
            } else {
                updateCells(userLine);
                displayDashBoard();
            }
        }
        System.out.println("Completed white figures. Please fill black figures (one in a line) and type COMPLETE after it: ");
        while (scanner.hasNextLine()) {
            userLine = scanner.nextLine();
            if ("COMPLETE".equals(userLine)) {
                break;
            } else {
                updateCells(userLine);
                displayDashBoard();
            }
        }
        scanner.close();
    }

    private void updateCells(String userLine) {
        int idx = getIdxFromCoordinate(userLine.split(" ")[1]);
        int figure = getFigureFromUserLine(userLine.split(" ")[0]);
        if (figure !=-1 && idx !=-1) {
            cells[idx] = (byte) figure;
        }
    }

    private int getIdxFromCoordinate(String coordinate) {
        String column = coordinate.substring(0, 1);
        int row = Integer.valueOf(coordinate.substring(1));
        if (columnNames.contains(column) && row > 0  && row <= deskSize) {
            return deskSize*(row - 1) + (column.charAt(0) - "A".charAt(0));
        } else{
            return -1;
        }
    }

    private int getFigureFromUserLine(String figureName) {
        // p for pawn, r for Rook, k for Knight, q for Queen, i for King
        switch (figureName){
            case "p": return new Pawn(WHITE_COLOR).getValueOnDesk();
            case "r": return new Rook(WHITE_COLOR).getValueOnDesk();
            case "k": return new Knight(WHITE_COLOR).getValueOnDesk();
            case "b": return new Bishop(WHITE_COLOR).getValueOnDesk();
            case "q": return new Queen(WHITE_COLOR).getValueOnDesk();
            case "i": return new King(WHITE_COLOR).getValueOnDesk();
            default:
                System.out.println("Used value isn't valid");
                return -1;
        }
    }
}
