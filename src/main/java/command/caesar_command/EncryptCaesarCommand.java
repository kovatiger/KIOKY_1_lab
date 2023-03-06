package command.caesar_command;

import command.Command;
import menu_command.CaesarMenu;

public class EncryptCaesarCommand implements Command {

    @Override
    public Command execute() {

        String language = new ChooseLanguage().chooseLanguage();

        int key = 0;

        while (key == 0) {
            key = new InputInfoForCaesar().inputKey();
        }

        String inputWord = new InputInfoForCaesar().inputWord();

        switch (language) {
            case "RUSSIAN":
                System.out.println("Зашифрованная фраза:");
                System.out.println(CaesarCipherEncryptionRussian(inputWord, key));
                break;
            case "ENGLISH":
                System.out.println("Зашифрованная фраза:");
                System.out.println(CaesarCipherEncryption(inputWord, key));
                break;
        }
        return new CaesarMenu();
    }

    private StringBuilder CaesarCipherEncryption(String inputWord, int key) {

        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < inputWord.length(); i++) {
            char symbol = inputWord.charAt(i);

            if (symbol >= 'a' && symbol <= 'z') {
                symbol += key % 26;

                if (symbol < 'a')
                    symbol += 26;

                if (symbol > 'z')
                    symbol -= 26;

            } else if (symbol >= 'A' && symbol <= 'Z') {

                symbol += key % 26;

                if (symbol < 'A')
                    symbol += 26;

                if (symbol > 'Z')
                    symbol -= 26;
            }

            encryptedText.append(symbol);
        }
        return encryptedText;
    }

    private StringBuilder CaesarCipherEncryptionRussian(String inputWord, int key) {

        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < inputWord.length(); i++) {
            char symbol = inputWord.charAt(i);

            if (symbol >= 'а' && symbol <= 'я') {
                symbol += key % 32;

                if (symbol < 'а')
                    symbol += 32;

                if (symbol > 'я')
                    symbol -= 32;

            } else if (symbol >= 'А' && symbol <= 'Я') {
                symbol += key % 32;

                if (symbol < 'А')
                    symbol += 32;

                if (symbol > 'Я')
                    symbol -= 32;
            }

            encryptedText.append(symbol);
        }
        return encryptedText;
    }
}
