package command.caesar_command;

import command.Command;
import menu_command.CaesarMenu;

public class DecryptCaesarCommand implements Command {

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
                System.out.println(CaesarCipherDecryptionRussian(inputWord, key));
                break;
            case "ENGLISH":
                System.out.println("Зашифрованная фраза:");
                System.out.println(CaesarCipherDecryption(inputWord, key));
                break;
        }
        return new CaesarMenu();
    }

    private StringBuilder CaesarCipherDecryption(String msg, int oldKey) {

        StringBuilder decryptedText = new StringBuilder();

        int key = Integer.parseInt("-" + oldKey);

        for (int i = 0; i < msg.length(); i++) {
            char symbol = msg.charAt(i);

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

            decryptedText.append(symbol);
        }
        return decryptedText;
    }

    private StringBuilder CaesarCipherDecryptionRussian(String msg, int oldKey) {

        StringBuilder decryptedText = new StringBuilder();

        int key = Integer.parseInt("-" + oldKey);

        for (int i = 0; i < msg.length(); i++) {
            char symbol = msg.charAt(i);

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

            decryptedText.append(symbol);
        }
        return decryptedText;
    }

}
