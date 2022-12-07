package com.company;

import java.util.Scanner;

public class Main {
    private static final int OFFSET = 3;
    private static final String QUIT_LETTER = "Q";
    private static final char FIRST_LETTER = 'A';
    private static final char LAST_LETTER = 'Z';
    private static final int FIRST_LETTER_CODE = 65;
    private static final int LAST_LETTER_CODE = 90;

    private static String encryptMessage(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (array[i] >= FIRST_LETTER && array[i] <= LAST_LETTER) {
                int index = ((int) array[i]) + OFFSET;
                if (index > LAST_LETTER_CODE) {
                    array[i] = (char)(FIRST_LETTER_CODE + index - LAST_LETTER_CODE - 1);
                } else {
                    array[i] = (char)(index);
                }
            }
        }

        return new String(array);
    }

    private static String decryptMessage(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (array[i] >= FIRST_LETTER && array[i] <= LAST_LETTER) {
                int index = ((int) array[i]) - OFFSET;
                if (index < FIRST_LETTER_CODE) {
                    array[i] = (char)(index + 1 + LAST_LETTER_CODE - FIRST_LETTER_CODE);
                } else {
                    array[i] = (char)(index);
                }
            }
        }

        return new String(array);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Press q or Q to exit!");

        while(in.hasNextLine()) {
            String s = in.nextLine().toUpperCase();
            if (QUIT_LETTER.equalsIgnoreCase(s)) {
                break;
            }
            System.out.println("You entered: " + s);
            String e = encryptMessage(s);
            System.out.println("Encrypted message: " + e);
            String d = decryptMessage(e);
            System.out.println("Decrypted message: " + d);
        }

        in.close();
    }
}
