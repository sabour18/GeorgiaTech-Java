import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import javax.print.event.PrintEvent;

//Need to implement for fillCords() an Input mismatch exception. Only ints work right now
public class BattleShip {

    static final int BOARD_SIZE = 5;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Battleship!");

        int[][] playerOneCords = new int[5][2];
        int[][] playerTwoCords = new int[5][2];

        char[][] oneBoard = new char[5][5];
        char[][] twoBoard = new char[5][5];

        // Populate Battleship poistions for each player
        fillCords(1, playerOneCords, input);
        popBoard(oneBoard, playerOneCords);
        printBoard(oneBoard);
        fillCords(2, playerTwoCords, input);
        popBoard(twoBoard, playerTwoCords);
        printBoard(twoBoard);

        char[][] oneHistory = new char[5][5];
        char[][] twoHistory = new char[5][5];
        popBoard(oneHistory);
        popBoard(twoHistory);

        play(oneHistory, playerOneCords, twoHistory, playerTwoCords, input);

        System.out.println("\nFinal Boards:\n");
        printFinalBoards(oneHistory, oneBoard);
        printFinalBoards(twoHistory, twoBoard);
    }

    private static void printFinalBoards(char[][] finalBoard, char[][] ships) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (ships[i][j] == '@' && finalBoard[i][j] == '-') {
                    finalBoard[i][j] = '@';
                }
            }
        }
        printBoard(finalBoard);
    }

    private static void fillCords(int player, int[][] cords, Scanner input) {
        System.out.println("\nPLAYER " + player + ", ENTER YOUR SHIPS COORDINATES: ");

        for (int i = 0; i < cords.length; i++) {
            System.out.println("Enter ship " + (i + 1) + " location");
            cords[i][0] = input.nextInt();
            cords[i][1] = input.nextInt();
            if (cords[i][0] < 0 || cords[i][1] < 0 || cords[i][0] > BOARD_SIZE - 1 || cords[i][1] > BOARD_SIZE - 1) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                i--;
            } else if (checkDuplicates(cords[i][0], cords[i][1], cords, i - 1)) {
                System.out.println("You already have a ship there. Choose different coordinates.");
                i--;
            }
        }
        // input.close();
    }

    // Returns true if the col and row were duplicated
    private static boolean checkDuplicates(int col, int row, int[][] cords, int key) {
        boolean result = false;
        for (int i = key; i >= 0; i--) {
            if (cords[i][0] == col && cords[i][1] == row) {
                result = true;
            }
        }
        return result;
    }

    private static void popBoard(char[][] board, int[][] shipCords) {
        // fill array with -
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '-');
        }

        for (int i = 0; i < shipCords.length; i++) {
            board[shipCords[i][0]][shipCords[i][1]] = '@';
        }
    }// popBoard

    private static void popBoard(char[][] board) {
        // fill array with -
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '-');
        }
    }// popBoard

    private static void printBoard(char[][] board) {
        System.out.println("  0 1 2 3 4");
        for (int i = 0; i < BOARD_SIZE; i++) {
            String s = i + " ";
            for (int j = 0; j < BOARD_SIZE; j++) {
                s += board[i][j] + " ";
            }
            System.out.println(s);
        }
        System.out.println("\n");
    }// printBoard

    private static void play(char[][] p1Board, int[][] p1Ships, char[][] p2Board, int[][] p2Ships, Scanner input) {
        boolean isPlaying = true;
        int turnNum = 1;
        int p1Score = 0;
        int p2Score = 0;
        final int MAX_SCORE = 5;

        while (isPlaying) {
            int[][] p1Shots = new int[26][2];
            int[][] p2Shots = new int[26][2];

            if (turnNum % 2 != 0) {
                // player 1 turn
                System.out.print("Player 1, enter hit row/column:");
                p1Shots[turnNum / 2][0] = input.nextInt();
                p1Shots[turnNum / 2][1] = input.nextInt();

                // checks if shot is valid
                if (!checkShots(p1Shots[turnNum / 2][0], p1Shots[turnNum / 2][1], p2Board)) {
                } else {
                    p1Score += makeShot(p1Shots[turnNum / 2][0], p1Shots[turnNum / 2][1], p2Board, p2Ships, 1);
                    turnNum++;
                }
            } else if (p1Score == MAX_SCORE) {
                System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                isPlaying = false;
            } else {
                // player 2 turn
                System.out.println("Player 2, enter hit row/column:");
                p2Shots[(turnNum / 2) - 1][0] = input.nextInt();
                p2Shots[(turnNum / 2) - 1][1] = input.nextInt();

                // checks if shot is valid
                if (!checkShots(p2Shots[(turnNum / 2) - 1][0], p2Shots[(turnNum / 2) - 1][1], p1Board)) {
                } else {
                    p2Score += makeShot(p2Shots[(turnNum / 2) - 1][0], p2Shots[(turnNum / 2) - 1][1], p1Board, p1Ships,
                            2);
                    turnNum++;
                }
            }

            if (p2Score == MAX_SCORE) {
                isPlaying = false;
                System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
            }
        }
    }// play

    private static boolean checkShots(int col, int row, char[][] opposingBoard) {
        boolean result = true;
        if (col < 0 || row < 0 || col > BOARD_SIZE - 1 || row > BOARD_SIZE - 1) {
            result = false;
            System.out.println("Invalid coordinates. Choose different coordinates.");
            return result;
        } else if (opposingBoard[col][row] == 'O' || opposingBoard[col][row] == 'X') {
            result = false;
            System.out.println("You already fired on this spot. Choose different coordinates.");
            return result;
        }
        return result;
    }// checkShots

    private static int makeShot(int col, int row, char[][] opposingBoard, int[][] ships, int player) {
        int result = 0;
        for (int i = 0; i < ships.length; i++) {
            if (ships[i][0] == col && ships[i][1] == row) {
                System.out.println("PLAYER " + player + " HIT SHIP");
                opposingBoard[col][row] = 'X';
                result = 1;
            }
        }
        if (result == 0) {
            System.out.println("PLAYER " + player + " MISSED!");
            opposingBoard[col][row] = 'O';
        }
        printBoard(opposingBoard);
        return result;
    }// makeShot()
}
