package com.max.chess.com.max.chess.Helper;

import com.max.chess.com.max.chess.dao.Game;
import com.max.chess.com.max.chess.dao.figures.*;
import java.io.*;

/**
 * Created by User on 01.04.2016.
 */
public class CellsHelper {

    private static int getIdxFromCoordinate(String coordinate) {
        String column = coordinate.substring(0, 1);
        int row = Game.deskSize - Integer.valueOf(coordinate.substring(1));
        if (Game.columnNames.contains(column) && row > 0  && row <= Game.deskSize) {
            return Game.deskSize*row + (column.charAt(0) - "A".charAt(0));
        } else{
            return -1;
        }
    }

    private static int getFigureFromUserLine(String figureName) {
        // p for pawn, r for Rook, k for Knight, q for Queen, i for King
        switch (figureName){
            case "p": return new Pawn(Game.WHITE_COLOR).getValueOnDesk();
            case "r": return new Rook(Game.WHITE_COLOR).getValueOnDesk();
            case "k": return new Knight(Game.WHITE_COLOR).getValueOnDesk();
            case "b": return new Bishop(Game.WHITE_COLOR).getValueOnDesk();
            case "q": return new Queen(Game.WHITE_COLOR).getValueOnDesk();
            case "i": return new King(Game.WHITE_COLOR).getValueOnDesk();
            default:
                System.out.println("Used value isn't valid");
                return -1;
        }
    }

    public static byte[] getInitialCells(String file) throws IOException {
        byte[] result = new byte[64];
        BufferedReader reader = new BufferedReader(new FileReader(file));
        boolean isWhite = true;
        String line;
        while ((line = reader.readLine()) != null) {
            if (!isLineReserved(line)) {
                int idx = getIdxFromCoordinate(line.split(" ")[1]);
                int figure = getFigureFromUserLine(line.split(" ")[0]);
                int sign = isWhite ? 1 : -1;
                if (figure !=-1 && idx !=-1) {
                    result[idx] = (byte) (figure*sign);
                }
            } else {
                if (Game.BLACK_COLOR.toUpperCase().equals(line)) {
                    isWhite = false;
                }
            }
        }
        reader.close();
        return result;
    }

    private static boolean isLineReserved(String line) {
        return line.equals(Game.WHITE_COLOR.toUpperCase()) || line.equals(Game.BLACK_COLOR.toUpperCase());
    }

    public static byte[] getInitialCells() {
        // fill pawns
        int whitePawnsRow = Game.deskSize - 2;
        byte[] result = new byte[Game.deskSize*Game.deskSize];
        for (int column = 0; column < Game.deskSize; column++) {
            result[whitePawnsRow*Game.deskSize + column] = 1;
        }
        int blackPawnsRow = 1;
        for (int column = 0; column < Game.deskSize; column++) {
            result[blackPawnsRow*Game.deskSize + column] =-1;
        }
        int whiteKingRow = Game.deskSize - 1;
        int whiteIdx = whiteKingRow*Game.deskSize - 1;
        // Rooks
        result[whiteIdx + 1] = 4; result[whiteIdx + Game.deskSize] = 4;
        result[0] =-4; result[Game.deskSize - 1] =-4;
        // Knights
        result[whiteIdx + 2] = 2; result[whiteIdx + Game.deskSize - 1] = 2;
        result[1] =-2; result[Game.deskSize - 2] =-2;
        // Bishops
        result[whiteIdx + 3] = 3; result[whiteIdx + Game.deskSize - 2] = 3;
        result[2] =-3; result[Game.deskSize - 3] =-3;
        // Queens
        result[whiteIdx + 4] = 5; result[3] =-5;
        // Kings
        result[whiteIdx + 5] = 6; result[4] =-6;

        return result;
    }
}
