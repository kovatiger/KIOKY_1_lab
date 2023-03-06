package menu_command;

import command.Command;
import command.caesar_command.DecryptCaesarCommand;
import command.caesar_command.EncryptCaesarCommand;

import java.util.Scanner;

public class CaesarMenu implements Command {

    @Override
    public Command execute() {
        while (true) {
            System.out.println("Шифр Цезаря.Введите:\n" +
                    "1 - зашифровать\n" +
                    "2 - расшифровать\n" +
                    "3 - вернуться к выбору шифров\n" +
                    "4 - выйти");

            Scanner sc = new Scanner(System.in);

            switch (sc.nextLine()) {
                case "1":
                    return new EncryptCaesarCommand();
                case "2":
                    return new DecryptCaesarCommand();
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
