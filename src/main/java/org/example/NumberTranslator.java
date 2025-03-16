package org.example;

import java.util.ArrayList;

public class NumberTranslator {
    private final int number;

    private final Vocabulary vocabulary;

    public NumberTranslator(int num) {
        number = num;
        vocabulary = new Vocabulary();
    }

    //1 0 8 4
    public ArrayList<Integer> numberToArrayList() {
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