package menu_command;

import command.Command;
import command.new_caesar_command.DecryptNewCaesarCommand;
import command.new_caesar_command.EncryptNewCaesarCommand;

import java.util.Scanner;

public class NewCaesarMenu implements Command {

    @Override
    public Command execute() {
        while (true) {
            System.out.println("Новый шифр Цезаря.Введите:\n" +
                    "1 - зашифровать\n" +
                    "2 - расшифровать\n" +
                    "3 - вернуться к выбору шифров\n" +
                    "4 - выйти");

            Scanner sc = new Scanner(System.in);

            switch (sc.nextLine()) {
                case "1":
                    return new EncryptNewCaesarCommand();
                case "2":
                    return new DecryptNewCaesarCommand();
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
