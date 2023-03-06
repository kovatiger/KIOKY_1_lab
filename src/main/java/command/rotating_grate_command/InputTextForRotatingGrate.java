package command.rotating_grate_command;

import java.util.Scanner;

public class InputTextForRotatingGrate {

    public String inputWord() {
        System.out.println("Введите текст не больше 16 символов:");

        Scanner sc = new Scanner(System.in);

        String inputWord = sc.nextLine();

        if (inputWord.length() > 16) {
            System.out.println("Вы ввели фразу больше 16 символов");
            return "";
        } else {
            return inputWord;
        }
    }
}
