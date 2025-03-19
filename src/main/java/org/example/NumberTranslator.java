package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class NumberTranslator {
    private String number;

    private final Vocabulary vocabulary;

    public NumberTranslator(String num) {
        number = num;
        vocabulary = new Vocabulary();
    }

    public String printNumber() {
        StringBuilder result = new StringBuilder();

        if(number.charAt(0) == '-') {result.append("минус").append(" "); number = number.substring(1);}

        ArrayList<Integer> digits = new ArrayList<Integer>();

        for(int j = 0; j < number.length(); j++) {
            digits.add(Character.getNumericValue(number.charAt(j)));
        }

        int count = digits.size();
        int num;
        int i = 0;
        int mnozhitel;

        while(i != count) {
            num = 0;

            switch (count - i) {
                case 12, 9, 6, 3:
                    mnozhitel = 100;
                    for(int j = 0; j < 3; j++){
                        num += digits.get(i) * mnozhitel;
                        i++;
                        mnozhitel /= 10;
                    }
                    break;

                case 11, 8, 5, 2:
                    mnozhitel = 10;
                    for(int j = 0; j < 2; j++){
                        num += digits.get(i) * mnozhitel;
                        i++;
                        mnozhitel /= 10;
                    }
                    break;

                case 10, 7, 4, 1:
                    num += digits.get(i);
                    i++;
                    break;
                default:
                    return "Ошибка, число такой длинны не поддерживается!";
            }
            //System.out.println(num);
        }
        return result.toString().trim();
    }
/*
    private ArrayList<Integer> numberToArrayList(int num) {
        ArrayList<Integer> digits = new ArrayList<>();
        int del1 = 10, del2 = 1;
        int buf;
        while(num / del2 > 0) {
            buf = (number % del1) / del2;
            del1 *= 10;
            del2 *= 10;
            digits.add(0, buf);
        }
        return digits;
    }

 */
}