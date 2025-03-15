package org.example;

import java.util.Map;

public class Vocabulary {
   
    private Map<Integer,String> digits = Map.of(
        1, "один", 
        2, "два", 
        3,"три", 
        4, "четыре",
        5, "пять",
        6, "шесть",
        7, "семь",
        8, "восемь",
        9, "девять"       
        );

    private Map<Integer,String> nums = Map.of(
        10, "десять",
        11, "одинадцать",
        12, "двенадцать",
        13, "тринадцать",
        14, "четырнадцать",
        15, "пятнадцать",
        16, "шестнадцать",
        17, "семнадцать",
        18, "восемнадцать",
        19, "девятнадцать"
    );

    private Map<Integer,String> tens = Map.of(
        2, "двадцать",
        3, "тридцать",
        4, "сорок",
        5, "пятьдесят",
        6, "шестьдесят",
        7, "семьдесят",
        8, "восемьдесят",
        9, "девяносто"
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
                else return nums.get(number);
            default:
                return "";
        }
    }

   
}
