package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String tabelGol = """
                ---------
                |       |
                |       |
                |       |
                ---------
                """;
        System.out.println(tabelGol);

        char[][] xo = new char[3][3];

        for (char[] chars : xo) {
            Arrays.fill(chars, ' ');
        }

        boolean win = false;
        int xOr0 = -1;

        while (!win) {
            int pos3 = scanner.nextInt();
            int pos4 = scanner.nextInt();

            if (((pos3 <= 3 && pos3 >= 0) && (pos4 <= 3 && pos4 >= 0)) && xo[pos3 - 1][pos4 - 1] == ' ') {
                xOr0++;
                if (xOr0 % 2 == 0) {
                    xo[pos3 - 1][pos4 - 1] = 'X';
                } else {
                    xo[pos3 - 1][pos4 - 1] = 'O';
                }
                System.out.println("---------");
                System.out.println("| " + xo[0][0] + " " + xo[0][1] + " " + xo[0][2] + " |");
                System.out.println("| " + xo[1][0] + " " + xo[1][1] + " " + xo[1][2] + " |");
                System.out.println("| " + xo[2][0] + " " + xo[2][1] + " " + xo[2][2] + " |");
                System.out.println("---------");

                if (winX(xo)) {
                    System.out.println("X wins!");
                    break;
                } else if (winY(xo)) {
                    System.out.println("O wins!");
                    break;
                }
                if (isDraw(xo)) {
                    System.out.println("Draw");
                    break;
                }


            } else if (((pos3 <= 3 && pos3 >= 0) && (pos4 <= 3 && pos4 >= 0)) && xo[pos3 - 1][pos4 - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
            }


        }

    }

    private static boolean winX(char[][] pos) {
        return checkRow2(pos, 'X') || checkColumn2(pos, 'X') || checkDiagonal2(pos, 'X');
    }

    private static boolean winY(char[][] pos) {
        return checkRow2(pos, 'O') || checkColumn2(pos, 'O') || checkDiagonal2(pos, 'O');
    }

    private static boolean isDraw(char[][] pos) {
        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos[i].length; j++) {
                if (pos[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkRow2(char[][] pos, char player) {
        for (int i = 0; i < 3; i++) {
            if (pos[i][0] == player && pos[i][1] == player && pos[i][2] == player) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumn2(char[][] pos, char player) {
        for (int i = 0; i < 3; i++) {
            if (pos[0][i] == player && pos[1][i] == player && pos[2][i] == player) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonal2(char[][] pos, char player) {
        return (pos[0][0] == player && pos[1][1] == player && pos[2][2] == player) ||
                (pos[2][0] == player && pos[1][1] == player && pos[0][2] == player);
    }

}
