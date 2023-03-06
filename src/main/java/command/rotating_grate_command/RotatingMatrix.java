package command.rotating_grate_command;

public class RotatingMatrix {

    public int[][] rotateMatrix(int[][] matrix) {

        int sizeOfMatrix = matrix.length;

        int[][] resultMatrix = new int[sizeOfMatrix][sizeOfMatrix];

        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                resultMatrix[i][j] = matrix[sizeOfMatrix - j - 1][i];
            }
        }

        return resultMatrix;
    }

    public char[][] rotateMatrix(char[][] matrix) {

        int sizeOfMatrix = matrix.length;

        char[][] resultMatrix = new char[sizeOfMatrix][sizeOfMatrix];

        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                resultMatrix[i][j] = matrix[sizeOfMatrix - j - 1][i];
            }
        }

        return resultMatrix;
    }
}
