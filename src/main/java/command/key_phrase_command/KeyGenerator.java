package command.key_phrase_command;

import java.util.Arrays;

public class KeyGenerator {

    public int[] getKey(String key) {

        String newKey = key.toUpperCase();

        char[] arrayOfCharacter = newKey.toCharArray();

        int[] intArrayOfCharacter = new int[newKey.length()];

        int[] simpleResultArray = new int[newKey.length()];

        for (int i = 0; i < key.length(); i++) {
            intArrayOfCharacter[i] = arrayOfCharacter[i];
        }

        Arrays.sort(intArrayOfCharacter);

        int numberOfCharacterInTheResultArray = 1;

        for (int i = 0; i < newKey.length(); i++) {
            for (int j = 0; j < newKey.length(); j++) {
                if (intArrayOfCharacter[i] == (int) arrayOfCharacter[j]) {
                    arrayOfCharacter[j] = ' ';
                    intArrayOfCharacter[i] = 0;
                    simpleResultArray[j] = numberOfCharacterInTheResultArray;
                    ++numberOfCharacterInTheResultArray;
                }
            }
        }

        return simpleResultArray;
    }
}
