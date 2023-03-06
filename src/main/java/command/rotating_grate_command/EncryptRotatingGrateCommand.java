package command.rotating_grate_command;

import command.Command;
import menu_command.RotatingGrateMenu;

public class EncryptRotatingGrateCommand implements Command {

    private final int sizeOfMatrix = 4;
    private char[][] resultMatrix = new char[sizeOfMatrix][sizeOfMatrix];

    @Override
    public Command execute() {

        String inputWord;

        do {
            inputWord = new InputTextForRotatingGrate().inputWord();
        } while (inputWord.isEmpty());


        int[][] keyMatrix = new InputMatrix().inputKeyMatrix();
        CacheMatrixForDecrypt.setKeyMatrix(keyMatrix);

        char symbol = '*';

        for (int i = 0; i < sizeOfMatrix; i++)
            for (int j = 0; j < sizeOfMatrix; j++)
                resultMatrix[i][j] = symbol;

        int index = 0;
        int numberOfKey = 0;

        for (int turnCount = 0; turnCount < 4; turnCount++) {
            if (index <= inputWord.length()) {
                for (int i = 0; i < sizeOfMatrix; i++) {
                    for (int j = 0; j < sizeOfMatrix; j++) {
                        if (keyMatrix[i][j] == numberOfKey + 1) {
                            if (index < inputWord.length()) {
                                resultMatrix[i][j] = inputWord.charAt(index);
                                index++;
                                numberOfKey++;
                                i = 0;
                            }
                        }
                    }
                }
            }

            numberOfKey = 0;
            resultMatrix = new RotatingMatrix().rotateMatrix(resultMatrix);
        }

        String resultText = "";

        for (int i = 0; i < sizeOfMatrix; i++)
            for (int j = 0; j < sizeOfMatrix; j++)
                resultText = resultText + resultMatrix[i][j];

        CacheMatrixForDecrypt.setDecryptedText(resultText);

        System.out.println("Зашифрованный текст:\n" + resultText);
        return new RotatingGrateMenu();
    }
}
