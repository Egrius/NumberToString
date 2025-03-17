package org.example;

import java.util.Map;

public class Vocabulary {

    protected final Map<Integer, String> digits = Map.ofEntries(
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

    protected final Map<Integer, String> numbers = Map.ofEntries(
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

    protected final Map<Integer, String> tens = Map.ofEntries(
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

    protected final Map<Integer, String> hundreds = Map.ofEntries(
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
    private final Declination declinator = new Declination();

    public Vocabulary() { }

    //Зависит от count
    //Однозначные
    protected String translateOne(int number) {
        return digits.get(number);
    }
    //Десятки
    protected String translateTwo(int number) {
        if(number >= 20 && number <= 99) return tens.get(number / 10) + " " + digits.get(number % 10);
        else return numbers.get(number);
    }
    //Сотни
    //Допилить функцию, чтобы переводила разные числа 200, 206, 224 !!!!
    protected String translateThree(int number, int count) {
        if(number != 0) {
            return hundreds.get(number);
        } else return "";
    }

    protected String translateThousands(int number, int count) {
        int tensPart = number / 10; // Десятки
        int unitsPart = number % 10; // Единицы

        String result = "";

        return ""; //Не готово
    }
}