package command.caesar_command;

import java.util.Scanner;

public class InputInfoForCaesar {

    public String inputWord() {
        System.out.println("Введите строку");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int inputKey() {
        System.out.println("Введите ключ (обязательно натуральное число)");
        Scanner sc = new Scanner(System.in);
        try {
            int key = sc.nextInt();
            if (key <= 0) {
                throw new Exception();
            }
            return key;
        } catch (Exception ex) {
            System.out.println("Введено неверное число");
            return 0;
        }
    }
}
