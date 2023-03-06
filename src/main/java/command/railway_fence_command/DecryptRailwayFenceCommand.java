package command.railway_fence_command;

import command.Command;
import menu_command.RailwayFenceMenu;

public class DecryptRailwayFenceCommand implements Command {

    @Override
    public Command execute() {

        StringBuilder decryptedText = new StringBuilder();

        String inputWord = new InputInfoForRailwayFence().inputWord();

        int key = 0;

        while (key == 0) {
            key = new InputInfoForRailwayFence().inputKey();
        }
        inputWord = inputWord.replace(" ", "");

        boolean isTheEndOfRow = false;
        int endOfRow = 0;
        int row = key;

        int column = inputWord.length();

        char[][] matrixForDecryptedText = new char[row][column];

        for (int i = 0; i < column; i++) {

            if (endOfRow == 0 || endOfRow == key - 1) {
                isTheEndOfRow = !isTheEndOfRow;
            }

            matrixForDecryptedText[endOfRow][i] = '*';

            if (isTheEndOfRow)
                endOfRow++;
            else
                endOfRow--;
        }

        int index = 0;
        isTheEndOfRow = false;

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                if (matrixForDecryptedText[i][k] == '*') {
                    matrixForDecryptedText[i][k] = inputWord.charAt(index++);
                }
            }
        }

        endOfRow = 0;

        for (int i = 0; i < column; i++) {
            if (endOfRow == 0 || endOfRow == key - 1) {
                isTheEndOfRow = !isTheEndOfRow;
            }

            decryptedText.append(matrixForDecryptedText[endOfRow][i]);

            if (isTheEndOfRow)
                endOfRow++;
            else
                endOfRow--;
        }

        System.out.println("Расшифрованная фраза:\n" +
                decryptedText);

        return new RailwayFenceMenu();
    }
}
