
// Tic Tac Toe Game Pseudo Code
// 1. Declare class TicTacToe
// 2. Declare class-level variables: ROW, COL, board[][], PLAYER_X, PLAYER_O
// 3. Define main method
// 4. Clear the board and set the player to X
// 5. Display the board
// 6. Create a loop for the game
// 7. Get the coordinates for the move from the player
// 8. Convert the player move coordinates to array indices
// 9. Loop until the converted player coordinates are a valid move
// 10. Make the move on the board
// 11. Display the updated board
// 12. Check if there is a win or a tie
// 13. If there is a win or tie, announce it and prompt for a new game
// 14. Toggle the player for the next turn
// 15. End of the loop (go back to step 7)
// 16. End of the game
import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];
    private static final String PLAYER_X = "X";
    private static final String PLAYER_O = "O";

    public static void main(String[] args) {
        clearBoard();
        String currentPlayer = PLAYER_X;

        while (true) {
            display();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Player " + currentPlayer + ", enter row (1-3): ");
            int row = scanner.nextInt();
            System.out.print("Player " + currentPlayer + ", enter column (1-3): ");
            int col = scanner.nextInt();
            row -= 1;
            col -= 1;

            while (!isValidMove(row, col)) {
                System.out.println("Invalid move. Please choose an empty position.");
                System.out.print("Player " + currentPlayer + ", enter row (1-3): ");
                row = scanner.nextInt();
                System.out.print("Player " + currentPlayer + ", enter column (1-3): ");
                col = scanner.nextInt();
                row -= 1;
                col -= 1;
            }

            board[row][col] = currentPlayer;
            display();

            if (isWin(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isTie()) {
                System.out.println("It's a tie!");
                break;
            }

            currentPlayer = currentPlayer.equals(PLAYER_X) ? PLAYER_O : PLAYER_X;
        }
    }

    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void display() {
        System.out.println("-------------");
        for (int i = 0; i < ROW; i++) {
            System.out.print("| ");
            for (int j = 0; j < COL; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int i = 0; i < COL; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}