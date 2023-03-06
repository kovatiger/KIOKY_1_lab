package menu_command;

import command.Command;
import command.rotating_grate_command.DecryptRotatingGrateMatrix;
import command.rotating_grate_command.EncryptRotatingGrateCommand;

import java.util.Scanner;

public class RotatingGrateMenu implements Command {

    @Override
    public Command execute() {
        while (true) {
            System.out.println("Шифр поворачивающейся решетки.Введите:\n" +
                    "1 - зашифровать\n" +
                    "2 - расшифровать\n" +
                    "3 - вернуться к выбору шифров\n" +
                    "4 - выйти");

            Scanner sc = new Scanner(System.in);

            switch (sc.nextLine()) {
                case "1":
                    return new EncryptRotatingGrateCommand();
                case "2":
                    return new DecryptRotatingGrateMatrix();
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
