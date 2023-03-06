package command.new_caesar_command;

import command.Command;
import menu_command.NewCaesarMenu;

public class EncryptNewCaesarCommand implements Command {

    @Override
    public Command execute() {

        String inputWord = new InputInfoForNewCaesar().inputWord();

        int key = 0;

        while (key == 0) {
            key = new InputInfoForNewCaesar().inputKey();
        }

        int decryptedKey = 1;

        while (((key * decryptedKey % 26) != 1) || gcd(key, decryptedKey) != 1) {
            decryptedKey++;
        }

        System.out.println("Ключ для расшифровки: " + decryptedKey);

        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < inputWord.length(); i++) {
            if (inputWord.charAt(i) == ' ') {
                encryptedText.append(" ");
                continue;
            }
            if (Character.isUpperCase(inputWord.charAt(i))) {
                encryptedText.append((char) (((inputWord.charAt(i) - 65) * key) % 26 + 65));
            } else {
                encryptedText.append((char) (((inputWord.charAt(i) - 97) * key) % 26 + 97));
            }
        }
        System.out.println(encryptedText);
        return new NewCaesarMenu();
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
