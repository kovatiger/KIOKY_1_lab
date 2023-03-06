package menu_command;

import command.Command;
import command.railway_fence_command.DecryptRailwayFenceCommand;
import command.railway_fence_command.EncryptRailwayFenceCommand;

import java.util.Scanner;

public class RailwayFenceMenu implements Command {

    @Override
    public Command execute() {
        while (true) {
            System.out.println("Шифр железнодорожной изгороди.Введите:\n" +
                    "1 - зашифровать\n" +
                    "2 - расшифровать\n" +
                    "3 - вернуться к выбору шифров\n" +
                    "4 - выйти");

            Scanner sc = new Scanner(System.in);

            switch (sc.nextLine()) {
                case "1":
                    return new EncryptRailwayFenceCommand();
                case "2":
                    return new DecryptRailwayFenceCommand();
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
