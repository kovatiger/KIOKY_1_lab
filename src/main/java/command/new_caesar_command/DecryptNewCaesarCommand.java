package command.new_caesar_command;

import command.Command;
import menu_command.NewCaesarMenu;

public class DecryptNewCaesarCommand implements Command {
    @Override
    public Command execute() {

        StringBuilder decryptedText = new StringBuilder();

        String inputWord = new InputInfoForNewCaesar().inputWord();

        int key = 0;

        while (key == 0) {
            key = new InputInfoForNewCaesar().inputKey();
        }

        for (int i = 0; i < inputWord.length(); i++) {
            if (inputWord.charAt(i) == ' ') {
                decryptedText.append(" ");
                continue;
            }
            if (Character.isUpperCase(inputWord.charAt(i))) {
                decryptedText.append((char) (((inputWord.charAt(i) - 65) * key) % 26 + 65));
            } else {
                decryptedText.append((char) (((inputWord.charAt(i) - 97) * key) % 26 + 97));
            }
        }

        System.out.println(decryptedText);
        return new NewCaesarMenu();
    }
}
