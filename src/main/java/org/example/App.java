package org.example;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число, которое нужно перевести: ");
        String input = scanner.nextLine();

        NumberTranslator numberTranslator = new NumberTranslator();

        String result = numberTranslator.printNumber(input);
        System.out.println("\nРезультат перевода:\n\n" + result);
    }
}