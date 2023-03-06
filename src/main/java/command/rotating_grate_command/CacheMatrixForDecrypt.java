package command.rotating_grate_command;

public class CacheMatrixForDecrypt {

    private static int[][] keyMatrix;
    private static String decryptedText;


    public static int[][] getKeyMatrix() {
        return keyMatrix;
    }

    public static void setKeyMatrix(int[][] keyMatrix) {
        CacheMatrixForDecrypt.keyMatrix = keyMatrix;
    }

    public static String getDecryptedText() {
        return decryptedText;
    }

    public static void setDecryptedText(String decryptedText) {
        CacheMatrixForDecrypt.decryptedText = decryptedText;
    }
}
