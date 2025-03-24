package org.example;

import java.util.ArrayList;
import java.util.List;

public class NumberTranslator {

    private final Vocabulary vocabulary;

    private final StringBuilder result = new StringBuilder();

    public NumberTranslator() {
        vocabulary = new Vocabulary();
    }

    private boolean specialCase(StringBuilder result, String number) throws startsFromZeroException{
        if (number.equals("-0") || number.equals("0")) {
            result.append("ноль");
            return true;
        }
        if((number.startsWith("-0") || number.startsWith("0")) && number.length() > 2) {
            throw new startsFromZeroException();
        }
        return false;
    }

    private String checkForNegative(String number) {
        if(number.charAt(0) == '-') {
            result.append("минус").append(" ");
            number = number.substring(1);
            return number;
        }
        return number;
    }

    private List<Integer> numberToDigits(String number) {
        List<Integer> digits = new ArrayList<>();
        for(int j = 0; j < number.length(); j++) {
            digits.add(Character.getNumericValue(number.charAt(j)));
        }
        return digits;
    }

    private String translatePart(int number, int countToPass) {
        return vocabulary.translateNumber(number, countToPass);
    }

    private void buildNumber(StringBuilder result, List<Integer> digits) {
        int count = digits.size();
        int i = 0;

        while(i < count) {
            int num = 0;
            int countToPass = count - i;

            if(countToPass % 3 == 0) {
                num += digits.get(i) * 100 + digits.get(i+1) * 10 + digits.get(i + 2);
                i+=3;

            } else if (countToPass % 3 == 2) {
                num += digits.get(i) * 10 + digits.get(i + 1);
                i+=2;

            } else  {
                num += digits.get(i);
                i++;
            }
            result.append(translatePart(num, countToPass)).append(" ");
        }
    }

    public String printNumber(String number) {
        try {
            if (specialCase(result, number)) {
                return result.toString();
            }
        } catch (startsFromZeroException e) {
            System.out.println("Ошибка! Целое число не может начинаться с нуля!");
            return "";
        }
        number = checkForNegative(number);
        List<Integer> digits = numberToDigits(number);
        buildNumber(result, digits);

        return result.toString().trim();
    }
}
