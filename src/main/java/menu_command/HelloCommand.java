package menu_command;

import command.Command;

import java.util.Scanner;

public class HelloCommand implements Command {

    @Override
    public Command execute() {
        while (true) {
            System.out.println("Выберите шифр, с которым вы хотите работать\n" +
                    "1 - железнодорожная изгородь\n" +
                    "2 - ключевая фраза\n" +
                    "3 - метод поворачивающейся решетки\n" +
                    "4 - шифр Цезаря\n" +
                    "5 - новый шифр Цезаря\n" +
                    "6 - выйти");

            Scanner sc = new Scanner(System.in);

            switch (sc.nextLine()) {
                case "1":
                    return new RailwayFenceMenu();
                case "2":
                    return new KeyPhraseMenu();
                case "3":
                    return new RotatingGrateMenu();
                case "4":
                    return new CaesarMenu();
                case "5":
                    return new NewCaesarMenu();
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Данные введены некорректно ");
            }
        }
    }
}
