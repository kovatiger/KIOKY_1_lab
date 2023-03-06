package command.key_phrase_command;

import command.Command;
import menu_command.KeyPhraseMenu;

public class EncryptKeyPhraseCommand implements Command {

    @Override
    public Command execute() {

        String key = new InputInfoForKeyPhrase().inputKey();
        String inputWord = new InputInfoForKeyPhrase().inputWord();

        StringBuilder encryptedText = new StringBuilder();

        char[] resultEncryptedArray;
        inputWord = inputWord.replace(" ", "");
        while (inputWord.length() % key.length() != 0) {
            inputWord += "#";
        }

        int[] keyForEncryptText = new KeyGenerator().getKey(key);

        int factor = 1;

        String partOfStringForEncrypt = inputWord.substring(0, key.length());

        for (int i = 0; i < inputWord.length() / key.length(); i++) {

            char[] array = partOfStringForEncrypt.toCharArray();
            resultEncryptedArray = new char[key.length()];

            for (int a = 0; a < key.length(); a++) {
                resultEncryptedArray[keyForEncryptText[a] - 1] = array[a];
            }

            encryptedText.append(resultEncryptedArray);

            int indexOfBeginToCut = partOfStringForEncrypt.length() * factor;

            if ((factor + 1) <= inputWord.length() / key.length()) {
                factor++;
                partOfStringForEncrypt = inputWord.substring(indexOfBeginToCut, factor * key.length());
            }
        }

        System.out.println("Зашифрованная фраза:\n" + encryptedText);

        return new KeyPhraseMenu();
    }

}
