package org.example;

import java.util.ArrayList;
import java.util.List;

public class NumberTranslator {

    private final Vocabulary vocabulary;

    public NumberTranslator() {
        vocabulary = new Vocabulary();
    }

    private void specialCase(StringBuilder result, String number) throws startsFromZeroException {
        if (number.equals("-0") || number.equals("0")) {
            result.append("ноль");
        }
        if ((number.startsWith("-0") || number.startsWith("0")) && number.length() > 2) {
            throw new startsFromZeroException();
        }
    }

    private String checkForNegative(String number, StringBuilder result) {
        if (number.charAt(0) == '-') {
            result.append("минус").append(" ");
            number = number.substring(1);
            return number;
        }
        return number;
    }

    private List<Integer> numberToDigits(String number) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == '.') {
                return digits;
            }
            digits.add(Character.getNumericValue(number.charAt(i)));
        }
        return digits;
    }

    private String translateIntPart(int number, int countToPass) {
        return vocabulary.translateNumber(number, countToPass, NumberPartType.INTEGER);
    }

    private String translateDecimalPart(int number, int countToPass) {
        return vocabulary.translateNumber(number, countToPass, NumberPartType.DECIMAL);
    }

    private void buildNumber(StringBuilder result, List<Integer> digits, NumberPartType type) {
        int count = digits.size();
        int i = 0;

        while (i < count) {
            int num = 0;
            int countToPass = count - i;

            if (countToPass % 3 == 0) {
                num += digits.get(i) * 100 + digits.get(i + 1) * 10 + digits.get(i + 2);
                i += 3;

            } else if (countToPass % 3 == 2) {
                num += digits.get(i) * 10 + digits.get(i + 1);
                i += 2;

            } else {
                num += digits.get(i);
                i++;
            }
            if(type == NumberPartType.INTEGER) result.append(translateIntPart(num, countToPass)).append(" ");
            else result.append(translateDecimalPart(num, countToPass)).append(" ");
        }
    }

    //Десятичная часть
    private List<Integer> deleteEndZeros(List<Integer> digitsDecimal) {
        int lastNonZeroIndex = digitsDecimal.size() - 1;
        while (lastNonZeroIndex >= 0 && digitsDecimal.get(lastNonZeroIndex) == 0) {
            lastNonZeroIndex--;
        }
        return digitsDecimal.stream()
                .limit(lastNonZeroIndex + 1)
                .toList();
    }

    private List<Integer> deleteLeadingZeros(List<Integer> digitsDecimal) {
        return digitsDecimal
                .stream()
                .dropWhile(e -> e == 0)
                .toList();
    }

    private void buildDecimalNumber(StringBuilder result, List<Integer> digitsDecimal, int lastIntDigit) {
        digitsDecimal = deleteEndZeros(digitsDecimal);
        int countToPass = digitsDecimal.size();
        digitsDecimal = deleteLeadingZeros(digitsDecimal);

        if (countToPass > 0) {
            if(lastIntDigit == 1) result.append("целая").append(" ");
            else  result.append("целых").append(" ");

            buildNumber(result, digitsDecimal, NumberPartType.DECIMAL);

            int lastDigit = digitsDecimal.getLast();
            String declension = vocabulary.getDecimalDeclination(lastDigit, countToPass);
            result.append(declension).append(" ");
        }
    }

    public String printNumber(String number) throws startsFromZeroException, StringIndexOutOfBoundsException{
        StringBuilder result = new StringBuilder();
        try {
            number = checkForNegative(number, result);

            String[] parts = number.split("\\.");
            String integerPart = parts[0];
            String decimalPart = parts.length > 1 ? parts[1] : "";

            specialCase(result, integerPart);

            List<Integer> digitsInt;

            if (!decimalPart.isEmpty()) {

                digitsInt = numberToDigits(integerPart);
                buildNumber(result, digitsInt, NumberPartType.DECIMAL);

                List<Integer> digitsDecimal = numberToDigits(decimalPart);
                buildDecimalNumber(result, digitsDecimal, digitsInt.getLast());
            }
            else {
                digitsInt = numberToDigits(integerPart);
                buildNumber(result, digitsInt, NumberPartType.INTEGER);
            }
            return result.toString().trim();

        } catch (startsFromZeroException e) {
            throw new startsFromZeroException();
        } catch (StringIndexOutOfBoundsException e) {
            throw new StringIndexOutOfBoundsException();
        }
    }
}