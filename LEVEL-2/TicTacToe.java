import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            playGame(scanner);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        scanner.close();
    }

    public static void playGame(Scanner scanner) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        int moves = 0;
        char currentPlayer = 'X';

        while (true) {
            // Display the board
            displayBoard(board);

            // Get the move from the current player
            int[] move = getPlayerMove(scanner, currentPlayer);
            int row = move[0];
            int col = move[1];

            // Check if the move is valid
            if (board[row][col] != ' ') {
                System.out.println("Invalid move. That cell is already occupied.");
                continue;
            }

            // Place the current player's symbol on the board
            board[row][col] = currentPlayer;
            moves++;

            // Check for win or draw
            if (checkWin(board, currentPlayer)) {
                displayBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (moves == 9) {
                displayBoard(board);
                System.out.println("It's a draw!");
                break;
            }

            // Switch players
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    public static void displayBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static int[] getPlayerMove(Scanner scanner, char currentPlayer) {
        int[] move = new int[2];
        System.out.print("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]): ");
        move[0] = scanner.nextInt() - 1;
        move[1] = scanner.nextInt() - 1;
        return move;
    }

    public static boolean checkWin(char[][] board, char player) {
        // Check rows and columns for a win
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals for a win
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }
}
