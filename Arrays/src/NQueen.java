import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        /*
         * There is a NXN chess board and we have to place N queens on the chess board but there are 3 conditions of placing the queen
         * 1.Every row should have exactly one queen
         * 2.Every column should have exactly one queen
         * 3.No queen can attack each other
         * Approach 1:
         * Queen can be placed in 8 direction but out of 8 we are interested in 3 directions in left because we will be placing the column from left to right
         * and check for left diagonal, left straight line and left bottom diagonal.
         * Time Complexity: O(N!*N)
         * Space Complexity: O(N^2)
         */
        int noOFQueen = 4;
        char[][] chessboard = new char[noOFQueen][noOFQueen];

        //Filling chessboard with '.' and once we will find the right place for queen then we will add 'Q'
        for(int i = 0; i < chessboard.length; i++) {
            for(int j = 0; j < chessboard.length; j++) {
                chessboard[i][j] =  '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        findNQueen(0, chessboard, ans);
        int i = 0;
        for (List < String > it: ans) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
        //Approach 2-----------------------------------------
        int[] leftRow = new int[noOFQueen];
        int[] lowerDiagonal = new int[2 * noOFQueen - 1];
        int[] upperDiagonal = new int[2 * noOFQueen - 1];
        fillQueen(0, chessboard, ans, leftRow, lowerDiagonal, upperDiagonal);
        for (List < String > it: ans) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }

    private static void findNQueen(int column, char[][] chessboard,List<List<String>> ans) {
        if(column >= chessboard.length) {
            List<String> queenPos = new LinkedList<String>();
            for (int i = 0; i < chessboard.length; i++) {
                queenPos.add(new String(chessboard[i]));
            }
            ans.add(queenPos);
            return;
        }
        for(int row = 0; row < chessboard.length; row++) {
            if(isSafeToPlace(row, column, chessboard)) {
                chessboard[row][column] = 'Q';
                findNQueen(column+1, chessboard, ans);
                chessboard[row][column] = '.';
            }
        }
    }

    private static boolean isSafeToPlace(int row, int column, char[][] chessboard) {
        int dupCol = column;
        int dupRow = row;

        //Below condition will check if the queen is present in upper diagonal location
        while(row >= 0 && column >= 0) {
            if(chessboard[row][column] == 'Q') return false;
            row--;
            column--;
        }
        column = dupCol;
        row = dupRow;

        //Below condition will check if the queen is present in left straight direction
        while(column >= 0) {
            if(chessboard[row][column] == 'Q') return false;
            column--;
        }
        row = dupRow;
        column = dupCol;

        //Below condition will check is the queen is present in below diagonal
        while(row < chessboard.length && column >= 0) {
            if(chessboard[row][column] == 'Q') return false;
            row++;
            column--;
        }
        return true;
    }

    /* Approach 2: Using Hashing
     * There is a formula to calculate upper and lower diagonal. Upper Diagonal is (n-1)+(col-row) and for lower left
     * diagonal is (row+col). The length of the hashing is calculated as (2n-1).
     * Time Complexity: O(N!*N)
     * Space Complexity: O(N)
     * https://takeuforward.org/data-structure/n-queen-problem-return-all-distinct-solutions-to-the-n-queens-puzzle/
     */
    private static void fillQueen(int col, char[][] chessboard, List<List<String>> ans, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        if(col >= chessboard.length) {
            List<String> queenPos = new LinkedList<>();
            for (int i = 0; i < chessboard.length; i++) {
                queenPos.add(new String(chessboard[i]));
            }
            ans.add(queenPos);
            return;
        }
        for (int row = 0; row < chessboard.length; row++) {
            if(leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[(chessboard.length-1)+(col - row)] == 0) {
                leftRow[row] = 1;
                upperDiagonal[chessboard.length -1 + (col - row)] = 1;
                lowerDiagonal[row + col] = 1;
                chessboard[row][col] = 'Q';
                fillQueen(col + 1, chessboard, ans, leftRow, lowerDiagonal, upperDiagonal);
                chessboard[row][col] = '.';
                leftRow[row] = 0;
                upperDiagonal[chessboard.length - 1 + (col - row)] = 0;
                lowerDiagonal[row + col] = 0;
            }
        }
    }

}
