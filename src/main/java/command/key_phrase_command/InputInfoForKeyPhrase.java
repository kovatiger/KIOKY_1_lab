package command.key_phrase_command;

import java.util.Scanner;

public class InputInfoForKeyPhrase {

    public String inputWord(){
        System.out.println("Введите фразу");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public String inputKey(){
        System.out.println("Введите ключ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
