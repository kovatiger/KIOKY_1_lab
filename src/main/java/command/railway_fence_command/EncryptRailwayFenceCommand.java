package command.railway_fence_command;

import command.Command;
import menu_command.RailwayFenceMenu;

public class EncryptRailwayFenceCommand implements Command {

    @Override
    public Command execute() {
        StringBuilder encryptedText = new StringBuilder();

        String inputWord = new InputInfoForRailwayFence().inputWord();
        int key = 0;

        while (key == 0) {
            key = new InputInfoForRailwayFence().inputKey();
        }

        inputWord = inputWord.replace(" ", "");

        int column = inputWord.length();

        boolean isTheEndOfRow = false;
        int endOfRow = 0;
        int row = key;

        char[][] matrixForEncryptedText = new char[row][column];

        for (int i = 0; i < column; i++) {
            if (endOfRow == 0 || endOfRow == key - 1) {
                isTheEndOfRow = !isTheEndOfRow;
            }
            matrixForEncryptedText[endOfRow][i] = inputWord.charAt(i);

            if (isTheEndOfRow)
                endOfRow++;
            else
                endOfRow--;
        }

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                if (matrixForEncryptedText[i][k] != 0)
                    encryptedText.append(matrixForEncryptedText[i][k]);
            }
        }

        System.out.println("Зашифрованный текст:\n" +
                encryptedText);

        return new RailwayFenceMenu();
    }
}
