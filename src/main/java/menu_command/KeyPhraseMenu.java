package menu_command;

import command.Command;
import command.key_phrase_command.DecryptKeyPhraseCommand;
import command.key_phrase_command.EncryptKeyPhraseCommand;

import java.util.Scanner;

public class KeyPhraseMenu implements Command {

    @Override
    public Command execute() {
        while (true) {
            System.out.println("Шифр ключевой фразой.Введите:\n" +
                    "1 - зашифровать\n" +
                    "2 - расшифровать\n" +
                    "3 - вернуться к выбору шифров\n" +
                    "4 - выйти");

            Scanner sc = new Scanner(System.in);

            switch (sc.nextLine()) {
                case "1":
                    return new EncryptKeyPhraseCommand();
                case "2":
                    return new DecryptKeyPhraseCommand();
                case "3":
                    return new HelloCommand();
                case "4":
                    System.exit(0);
                default:
                    System.out.println("Данные введены некорректно");
            }
        }
    }
}
