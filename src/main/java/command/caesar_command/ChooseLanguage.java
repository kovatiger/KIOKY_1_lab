package command.caesar_command;

import java.util.Scanner;

public class ChooseLanguage {

    public String chooseLanguage() {

        System.out.println("Выберите язык:\n" +
                "1 - русский\n" +
                "2 - английский");

        Scanner sc = new Scanner(System.in);

        while (true) {
            switch (sc.nextLine()) {
                case "1":
                    return Languages.RUSSIAN.name();
                case "2":
                    return Languages.ENGLISH.name();
                default:
                    System.out.println("Неправильный ввод");
            }
        }
    }
}
