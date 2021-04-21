package bomb;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int bombs = 0;
        int row = 0;
        int col = 0;
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] matrices = new String[n][];
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.contains("s")) {
                row = i;
                for (int j = 0; j < input.length() - 1; j++) {
                    String[] find = input.split("\\s+");
                    if (find[j].equals("s")) {
                        col = j;
                        break;
                    }
                }

            }
            matrices[i] = input.split("\\s+");
        }


        String var = "";
        int i = 0;
        while (thereAreStillBombs(matrices) != 0 && i<commands.length) {
            matrices[row][col] = "+";
            int backRow = row;
            int backCol = col;
            switch (commands[i]) {
                case "up":
                    row -= 1;
                    break;
                case "down":
                    row += 1;
                    break;
                case "left":
                    col -= 1;
                    break;
                case "right":
                    col += 1;
                    break;
            }
            if (col > matrices.length-1 || col < 0 || row > matrices.length-1 || row < 0) {
                row = backRow;
                col = backCol;
            }
            var = matrices[row][col];
            if (var.equals("B")) {
                System.out.println("You found a bomb!");
                bombs++;
            }
            if (var.equals("e")) {
                System.out.printf("END! %d bombs left on the field", thereAreStillBombs(matrices));
                break;
            }
            matrices[row][col] = "s";
            i++;
        }
        if (thereAreStillBombs(matrices) == 0) {
            System.out.println("Congratulations! You found all bombs!");
        }
        if(!var.equals("e")&& thereAreStillBombs(matrices)!=0){
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", thereAreStillBombs(matrices), row, col);
        }
    }

    private static int thereAreStillBombs(String[][] matrices) {
        int n = 0;
        for (int i = 0; i < matrices.length; i++) {
            for (int j = 0; j < matrices.length; j++) {
                if (matrices[i][j].equals("B")) {
                    n++;
                }

            }
        }
        return n;
    }


}

