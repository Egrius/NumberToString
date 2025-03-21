package org.example;

import java.util.ArrayList;

public class NumberTranslator {

    private final Vocabulary vocabulary;

    public NumberTranslator() {
        vocabulary = new Vocabulary();
    }

    public String printNumber(String number) {
        StringBuilder result = new StringBuilder();

        if (number.equals("-0") || number.equals("0")) {
            return "ноль";
        }
        if((number.startsWith("-0") || number.startsWith("0")) && number.length() > 2) return "Число не должно начинаться с нуля!";

        if(number.charAt(0) == '-') {result.append("минус").append(" "); number = number.substring(1);}

        ArrayList<Integer> digits = new ArrayList<>();

        for(int j = 0; j < number.length(); j++) {
            digits.add(Character.getNumericValue(number.charAt(j)));
        }

        int count = digits.size();
        int num;
        int i = 0;
        int multiplier;
        int countToPass;
        while(i != count) {
            num = 0;
            countToPass = count - i;
            switch (countToPass) {
                case 12, 9, 6, 3:
                    multiplier = 100;
                    for(int j = 0; j < 3; j++){
                        num += digits.get(i) * multiplier;
                        i++;
                        multiplier /= 10;
                    }
                    break;

                case 11, 8, 5, 2:
                    multiplier = 10;
                    for(int j = 0; j < 2; j++){
                        num += digits.get(i) * multiplier;

                        i++;
                        multiplier /= 10;
                    }
                    break;

                case 10, 7, 4, 1:
                    num += digits.get(i);

                    i++;
                    break;
                default:
                    return "Ошибка, число такой длинны не поддерживается!";
            }
            result.append(vocabulary.translateThousands(num, countToPass)).append(" ");
        }
        return result.toString().trim();
    }
}