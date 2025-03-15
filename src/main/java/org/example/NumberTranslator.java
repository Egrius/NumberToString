package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class NumberTranslator {
    private final int number;

    private final Vocabulary vocabulary;

    public NumberTranslator() {
        number = 0;
        vocabulary = new Vocabulary();
    }

    public NumberTranslator(int num) {
        number = num;
        vocabulary = new Vocabulary();
    }

    //1 0 8 4
    public ArrayList<Integer> numberToArrayList() {
        ArrayList<Integer> digits = new ArrayList<>();
        /*
        int index = String.valueOf(number).length() - 1;
        int temp = number;
        while(temp > 0) {

            digits.set(index--, temp % 10);
            temp /= 10;
        }
        */

        int del1 = 10, del2 = 1;
        int buf;
        while(number / del2 > 0) {
            buf = (number % del1) / del2;
            del1*=10;
            del2*=10;
            digits.add(buf);
        }

        Collections.reverse(digits);

        return digits;
    }

    public String printNumber() {
        ArrayList<Integer> digits = numberToArrayList();
        int count = digits.size();

        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;

        switch (count) {
            case 1:
                stringBuilder.append(vocabulary.getRepresentation(count, digits.get(i)));
                break;
            case 2:
                stringBuilder.append(vocabulary.getRepresentation(count, digits.get(i++)*10 + digits.get((i))));
                break;
            default:
                break;
        }
        
        return stringBuilder.toString();
    }
}