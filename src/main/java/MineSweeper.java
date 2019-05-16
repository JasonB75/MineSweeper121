import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
public class MineSweeper {
    public boolean gameOver = false;
    public MineSweeper round;
    public static int counter = 0;
    int[][] board;
    String[][] playerBoard;
    String[] letterArray = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String[] numArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17"};
    Integer[] intsArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    public MineSweeper() {

    }


    //Makes the real board
    public void generateBoard(int numMines, int row, int column) {
        int[][] mines = new int[numMines][2];
        for (int i = 0; i < numMines; i++) {
            mines[i][0] = (int) (Math.random() * (row - 1) + 1) - 1;
            mines[i][1] = (int) (Math.random() * (column - 1) + 1) - 1;
        }
        for (int[] n : mines) {
            board[n[0]][n[1]] = 9;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] != 9) {
                    board[i][j] = checkMines(i, j, row, column);
                }
            }
        }
    }

    //MineSweeper Constructer
    public MineSweeper(int row, int column, int mines) {
        board = new int[row][column];
        generateBoard(mines, row, column);
    }

    //Places the mines.
    public int checkMines(int row, int column, int realRow, int realColumn) {
        int out = 0;
        int[][] placeChecks = {{row - 1, column - 1}, {row - 1, column}, {row - 1, column + 1}, {row, column + 1}, {row + 1, column + 1}, {row + 1, column}, {row + 1, column - 1}, {row, column - 1}};

        for (int[] n : placeChecks) {
            if (n[0] >= 0 && n[1] >= 0 && n[0] <= (realRow - 1) && n[1] <= (realColumn - 1)) {
                if (board[n[0]][n[1]] == 9) {
                    out += 1;
                }
            }
        }
        return out;
    }

    //Print game prints out the actual game with the numbers.
    public void printGame() {
        if (board == null) {
            System.out.println("Board is null -- printGame!");
        } else {
            for (int[] n : board) {
                String out = "";
                for (int m : n) {
                    out = out + m + "   ";
                }
                System.out.println(out + "\n");
                out = "";
            }
        }
    }

    //Generates the player board and begins the game.
    public void start(int rows, int columns) {
        playerBoard = new String[rows + 1][columns + 1];
        for (int i = 0; i <= columns; i++) {
            if (i > 9) {
                playerBoard[0][i] = numArray[i] + " ";
            } else {
                playerBoard[0][i] = numArray[i] + "  ";
            }
        }
        for (int i = 0; i <= rows; i++) {
            playerBoard[i][0] = letterArray[i];
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                playerBoard[i][j] = "*  ";
            }
        }
    }

    //Checks the users input to see if its a mine, and then reveals what they picked.
    public void enterCord(int row, int column, int realRow, int realColumn)
    {
        row = row-1;
        column = column-1;
        int[][] placesArray = {{row - 1, column - 1}, {row - 1, column}, {row - 1, column + 1}, {row, column + 1}, {row + 1, column + 1}, {row + 1, column}, {row + 1, column - 1}, {row, column - 1}};
        int tempRow;
        int tempColumn;
        if (board[row][column] == 9) {
            System.out.println("AAAAAHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
            gameOver = true;
        }
        playerBoard[row + 1][column + 1] = intsArray[board[row][column]].toString()+ "  ";
        for (int[] n : placesArray) {
            tempRow = n[0];
            tempColumn = n[1];
            if (n[0] >= 0 && n[1] >= 0 && n[0] <= (realRow - 1) && n[1] <= (realColumn - 1)) {
                playerBoard[tempRow + 1][tempColumn + 1] = intsArray[board[tempRow][tempColumn]].toString() + "  ";
            }

        }

        if (gameOver) {
            endGame();

        }
        else
        {
        printBoard();
        System.out.println(board[row][column]);
        }
    }

    //Print's out the player board which has no numbers.
    public void printBoard() {
        if (board == null) {
            System.out.println("Board is null -- printBoard!");
        } else {
            for (String[] n : playerBoard) {
                String out = "";
                for (String m : n) {
                    out = out + m + " ";
                }
                System.out.println(out + "\n");
                out = "";
            }
        }
    }

    public void endGame() {
        //System.out.println("Ya motha fuucka, you hit a god damn mine. what deee fuck?!?");
        Font tr = new Font("TimesRoman", Font.PLAIN, 65);
        Settings sets = new Settings(tr, 160, 60);
        AsciiArt art = new AsciiArt();
        art.drawString("FAIL", "YOU FAILED", sets );
        System.out.println("'Did you ever hear the tragedy of Darth Minesweepius the wise? I thought not. It's not a story the python coders would tell you. \n It's a Java legend. Darth Minesweepius was a Dark Lord of the Java, so powerful and so wise he could use the Code to influence the strings to create ASCII art... \n He had such a knowledge of the dark side that he could even keep the programs he cared about from erroring. \nThe dark side of the Code is a pathway to many abilities some consider to be unnatural. He became so powerful... \n the only thing he was afraid of was losing his Code , which eventually, of course, he did. Unfortunately, he taught his apprentice everything he knew,\n then his apprentice Null Pointer Exceptioned him in his sleep. It's ironic he could save others from errors, but not himself.' ");
       //forky();
        TalkAboutIt.stopGame = true;
    }


    public boolean a = true;
    public int counts = 0;
    public int width = 100;
    private int height = 100;
    Font tr = new Font("TimesRoman", Font.PLAIN, 18);

    boolean forky() {
        Font tr = new Font("TimesRoman", Font.PLAIN, 18);
        Settings sets = new Settings(tr, 200, 200);
        AsciiArt art = new AsciiArt();
        while (a)

            art.drawString("FAIL", "YOU FAILED", sets );

         forky();
          forky();
         forky();
        forky();
        forky();
        forky();
        forky();
        forky();
        forky();
        return false;
    }
}
