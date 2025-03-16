package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Vocabulary {

    protected Map<Integer, String> digits = Map.ofEntries(
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

    protected Map<Integer, String> numbers = Map.ofEntries(
            Map.entry(10, "десять"),
            Map.entry(11, "одинадцать"),
            Map.entry(12, "двенадцать"),
            Map.entry(13, "тринадцать"),
            Map.entry(14, "четырнадцать"),
            Map.entry(15, "пятнадцать"),
            Map.entry(16, "шестнадцать"),
            Map.entry(17, "семнадцать"),
            Map.entry(18, "восемнадцать"),
            Map.entry(19, "девятнадцать")
    );

    protected Map<Integer, String> tens = Map.ofEntries(
            Map.entry(2, "двадцать"),
            Map.entry(3, "тридцать"),
            Map.entry(4, "сорок"),
            Map.entry(5, "пятьдесят"),
            Map.entry(6, "шестьдесят"),
            Map.entry(7, "семьдесят"),
            Map.entry(8, "восемьдесят"),
            Map.entry(9, "девяносто")
    );

    private  Map<Integer, String> hundreds = Map.ofEntries(
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

   private List<String> bigNumbers = Arrays.asList("тысяча", "миллион", "миллиард");
    
    public Vocabulary() {
       
    }

    //Зависит от count
    protected String translateOne(int number) {
        return digits.get(number);
    }

    protected String translateTwo(int number) {
        if(number >= 20 && number <= 99) return tens.get(number / 10) + " " + digits.get(number % 10);
        else return numbers.get(number);
    }

    protected String translateThree(int number) {
        if(number != 0) {
            return hundreds.get(number);
        } else return "";
    }

    //Склонения для тысяч
    protected String translateFour(int number) {
        if (number == 1) {
            return "одна тысяча";

        } else if (number >= 2 && number <= 4) {
            if(number == 2) return "две тысячи";
            else return digits.get(number)  + " тысячи";

        } else {
            return digits.get(number) + " тысяч";
        }
    }

}
