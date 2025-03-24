package org.example;

import java.util.Map;

public class Vocabulary {

    private final Map<Integer, String> digits = Map.ofEntries(
            Map.entry(1, "один"),
            Map.entry(2, "два"),
            Map.entry(3, "три"),
            Map.entry(4, "четыре"),
            Map.entry(5, "пять"),
            Map.entry(6, "шесть"),
            Map.entry(7, "семь"),
            Map.entry(8, "восемь"),
            Map.entry(9, "девять")
    );

    private final Map<Integer, String> numbers = Map.ofEntries(
            Map.entry(10, "десять"),
            Map.entry(11, "одиннадцать"),
            Map.entry(12, "двенадцать"),
            Map.entry(13, "тринадцать"),
            Map.entry(14, "четырнадцать"),
            Map.entry(15, "пятнадцать"),
            Map.entry(16, "шестнадцать"),
            Map.entry(17, "семнадцать"),
            Map.entry(18, "восемнадцать"),
            Map.entry(19, "девятнадцать")
    );

    private final Map<Integer, String> tens = Map.ofEntries(
            Map.entry(1, "десять"),
            Map.entry(2, "двадцать"),
            Map.entry(3, "тридцать"),
            Map.entry(4, "сорок"),
            Map.entry(5, "пятьдесят"),
            Map.entry(6, "шестьдесят"),
            Map.entry(7, "семьдесят"),
            Map.entry(8, "восемьдесят"),
            Map.entry(9, "девяносто")
    );

    private final Map<Integer, String> hundreds = Map.ofEntries(
            Map.entry(1, "сто"),
            Map.entry(2, "двести"),
            Map.entry(3, "триста"),
            Map.entry(4, "четыреста"),
            Map.entry(5, "пятьсот"),
            Map.entry(6, "шестьсот"),
            Map.entry(7, "семьсот"),
            Map.entry(8, "восемьсот"),
            Map.entry(9, "девятьсот")
    );
    private final Declination declination = new Declination();

    public Vocabulary() { }

    protected String translateIntNumber(int number, int count) {
        int hundredsPart = number / 100;
        int tensAndUnits = number % 100;
        int tensPart = tensAndUnits / 10;
        int unitsPart  = tensAndUnits % 10;

        String result = "";

        if(hundredsPart != 0) {
            result += hundreds.get(hundredsPart) + " ";
        }

        if (tensAndUnits >= 10 && tensAndUnits <= 19){
            result += numbers.get(tensAndUnits) + " " + declination.getIntDeclination(tensAndUnits, count);
            return result.trim();

        } else {
            if (tensPart >= 2) {
                result += tens.get(tensPart) + " ";
            }
            if (unitsPart != 0) {
                switch (count) {
                    case 1,2,3:
                        result += digits.get(unitsPart);
                        return result.trim();

                    case 4, 5, 6:
                        if (unitsPart == 1) result += "одна" + " ";
                        else if (unitsPart == 2) result += "две" + " ";
                        else result += digits.get(unitsPart) + " ";
                        break;

                   default:
                        result += digits.get(unitsPart) + " ";
                        break;
                }
            }
        }
        if(number != 0) result += declination.getIntDeclination(unitsPart != 0 ? unitsPart : tensAndUnits, count);
        return result.trim();
    }

    //Сделать перевод десятичной части!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    protected String translateDecimalNumber(int number, int count) {
        int hundredsPart = number / 100;
        int tensAndUnits = number % 100;
        int tensPart = tensAndUnits / 10;
        int unitsPart  = tensAndUnits % 10;

        String result = "";

        if(hundredsPart != 0) {
            result += hundreds.get(hundredsPart) + " ";
        }

        if (tensAndUnits >= 10 && tensAndUnits <= 19){
            result += numbers.get(tensAndUnits) + " " + declination.getIntDeclination(tensAndUnits, count);
            return result.trim();

        } else {
            if (tensPart >= 2) {
                result += tens.get(tensPart) + " ";
            }
            if (unitsPart != 0) {
                switch (count) {
                    case 1,2,3:
                        result += digits.get(unitsPart);
                        return result.trim();

                    case 4, 5, 6:
                        if (unitsPart == 1) result += "одна" + " ";
                        else if (unitsPart == 2) result += "две" + " ";
                        else result += digits.get(unitsPart) + " ";
                        break;

                    default:
                        result += digits.get(unitsPart) + " ";
                        break;
                }
            }
        }
        if(number != 0) result += declination.getIntDeclination(unitsPart != 0 ? unitsPart : tensAndUnits, count);
        return result.trim();
    }
}