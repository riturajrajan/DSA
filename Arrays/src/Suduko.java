import java.util.ArrayList;
import java.util.List;

public class Suduko {
    public static void main(String[] args) {
        /*
         * The idea here is to find an empty cell first. Once we find empty cell then try filling empty cell from number 1 to 9. If any number get placed
         * in empty cell then again call the recursion which will again look for empty cell and then try to place number from 1 to 9
         * Time Complexity: O(9(n ^ 2)), in the worst case, for each cell in the n2 board, we have 9 possible numbers.
         * Space Complexity: O(1), since we are refilling the given board itself, there is no extra space required, so constant space complexity.
         */
        char[][] board= {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static boolean solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solveSudoku(board))       // If it returns true then again call the function which will again start looking for empty cells
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }

                    return false;   // If we are not able to place any number from 1 to 9 then it board is not allowing to add anything then simply return false
                }
            }
        }
        return true;        // If we are not able to iterate it means we have created one valid suduko set then simply return true
    }

    // In a single iteration we are looking in entire row, column and subset of 3X3 then number can be inserted or not
    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)   // if the row already contain the number than return false
                return false;

            if (board[row][i] == c)   // if the column already contain the number than return false
                return false;

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)   // if 3X3 subset already contain the number then return false
                return false;
        }
        return true;        // If row, column and 3X3 subset doesn't contain the number it means we can add the number in empty cell so return true
    }
}
