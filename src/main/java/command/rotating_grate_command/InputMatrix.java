package command.rotating_grate_command;

import java.util.Scanner;

public class InputMatrix {

    private final int sizeOfMatrix = 4;

    public int[][] inputKeyMatrix() {

        Scanner sc = new Scanner(System.in);

        int[][] keyMatrix = new int[sizeOfMatrix][sizeOfMatrix];
        int[][] startMatrix = new int[sizeOfMatrix][sizeOfMatrix];


        for (int i = 0; i < sizeOfMatrix; i++)
            for (int j = 0; j < sizeOfMatrix; j++) {
                keyMatrix[i][j] = 0;
                startMatrix[i][j] = 0;
            }



        for (int turnCount = 0; turnCount < 4; turnCount++) {
            int number = 1;
            for (int i = 0; i < sizeOfMatrix / 2; i++)
                for (int j = 0; j < sizeOfMatrix / 2; j++) {
                    startMatrix[i][j] = number;
                    number++;
                }
            startMatrix = new RotatingMatrix().rotateMatrix(startMatrix);
        }




        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                System.out.print(startMatrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < (sizeOfMatrix / 2) * (sizeOfMatrix / 2); i++) {
            boolean flag = true;
            while (flag) {
                System.out.println("Введите координаты отверстия для " + (i + 1) + ". Начало матрицы (0,0):");
                System.out.print("x: ");
                int x = sc.nextInt();
                System.out.print("y: ");
                int y = sc.nextInt();
                if (startMatrix[x][y] == (i + 1)) {
                    keyMatrix[x][y] = i + 1;
                    flag = false;
                } else {
                    System.out.println("Данные введены неверно!");
                }
            }
        }
        return keyMatrix;
    }
}
