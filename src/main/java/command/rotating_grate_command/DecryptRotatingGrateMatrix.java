package command.rotating_grate_command;

import command.Command;
import menu_command.RotatingGrateMenu;


public class DecryptRotatingGrateMatrix implements Command {

    private final int sizeOfMatrix = 4;
    private char[][] resultMatrix = new char[sizeOfMatrix][sizeOfMatrix];

    @Override
    public Command execute() {

        String encryptedText = CacheMatrixForDecrypt.getDecryptedText();
        int[][] keyMatrix = CacheMatrixForDecrypt.getKeyMatrix();

        int index = 0;

        for (int i = 0; i < sizeOfMatrix; i++)
            for (int j = 0; j < sizeOfMatrix; j++) {
                resultMatrix[i][j] = encryptedText.charAt(index);
                index++;
            }

        String resultText = "";

        int numberOfKey = 0;
        index = 0;


        for (int turnCount = 0; turnCount < 4; turnCount++) {
            for (int i = 0; i < sizeOfMatrix; i++)
                for (int j = 0; j < sizeOfMatrix; j++) {
                    if (keyMatrix[i][j] == numberOfKey + 1) {
                        if (index < encryptedText.length()) {
                            resultText += resultMatrix[i][j];
                            index++;
                            numberOfKey++;
                            i = 0;
                        }
                    }
                }

            numberOfKey = 0;
            resultMatrix = new RotatingMatrix().rotateMatrix(resultMatrix);
        }


        resultText = resultText.replace("*", "");
        System.out.println("Расшифрованный текст:\n" + resultText);
        return new RotatingGrateMenu();
    }
}
