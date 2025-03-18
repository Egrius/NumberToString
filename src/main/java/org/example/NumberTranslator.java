package org.example;

import java.util.ArrayList;

public class NumberTranslator {
    private final int number;

    private final Vocabulary vocabulary;

    public NumberTranslator(int num) {
        number = num;
        vocabulary = new Vocabulary();
    }

    public String printNumber() {
        ArrayList<Integer> digits = numberToArrayList();
        int count = digits.size();

        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        //return vocabulary.translateThousands(191, 6);

        //В дальнейшем немного переделаю
        switch (count) {
            case 1:
                break;
            case 2:

                break;
            default:
                break;
        }
        return stringBuilder.toString();
    }

    //1 0 8 4
    private ArrayList<Integer> numberToArrayList() {
        ArrayList<Integer> digits = new ArrayList<>();
        int del1 = 10, del2 = 1;
        int buf;
        while(number / del2 > 0) {
            buf = (number % del1) / del2;
            del1 *= 10;
            del2 *= 10;
            digits.add(0, buf);
        }
        return digits;
    }
}