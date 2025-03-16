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

    private final Map<Integer, String> tens = Map.ofEntries(
            Map.entry(2, "двадцать"),
            Map.entry(3, "тридцать"),
            Map.entry(4, "сорок"),
            Map.entry(5, "пятьдесят"),
            Map.entry(6, "шестьдесят"),
            Map.entry(7, "семьдесят"),
            Map.entry(8, "восемьдесят"),
            Map.entry(9, "девяносто")
    );

   // private List<String> tens = Arrays.asList("десять", "сто", "тысяча", "миллион", "миллиард");
    
    public Vocabulary() {
       
    }

    public String getRepresentation(int count, int number) {
        switch (count) {
            case 1:
                return digits.get(number);
            case 2:
                if(number >= 20 && number <= 99) return tens.get(number / 10) + " " + digits.get(number % 10);
                else return numbers.get(number);
            default:
                return "";
        }
    }

   
}
