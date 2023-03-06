package command.key_phrase_command;

import command.Command;
import menu_command.KeyPhraseMenu;

public class DecryptKeyPhraseCommand implements Command {

    @Override
    public Command execute() {

        String key = new InputInfoForKeyPhrase().inputKey();
        String inputWord = new InputInfoForKeyPhrase().inputWord();

        StringBuilder decryptedText = new StringBuilder();

        int[] keyForEncryptText = new KeyGenerator().getKey(key);

        char[] resultEncryptedArray;

        int factor = 1;

        String partOfStringForDecrypt = inputWord.substring(0, key.length());

        for (int i = 0; i < inputWord.length() / key.length(); i++) {

            char[] array = partOfStringForDecrypt.toCharArray();
            resultEncryptedArray = new char[key.length()];

            for (int a = 0; a < key.length(); a++) {
                for (int b = 0; b < key.length(); b++) {
                    if ((a + 1) == keyForEncryptText[b]) {
                        resultEncryptedArray[b] = array[a];
                    }
                }
            }

            decryptedText.append(resultEncryptedArray);

            int indexOfBeginToCut = partOfStringForDecrypt.length() * factor;

            if ((factor + 1) <= inputWord.length() / key.length()) {
                factor++;
                partOfStringForDecrypt = inputWord.substring(indexOfBeginToCut, factor * key.length());
            }
        }
        String resultText = new String(decryptedText);
        resultText = resultText.replace("#", "");
        System.out.println("Расшифрованный текст:\n" + resultText);

        return new KeyPhraseMenu();
    }
}
