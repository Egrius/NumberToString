package org.example;

import java.util.Scanner;

/*
Планы:
    - Оптимизировать удаление нулей
    - Обработка пустой части decimal
    - покрыть тестами
    - сделать входные и выходные файлы для тестов
*/
public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число, которое нужно перевести: ");
        String input = scanner.nextLine();

        NumberTranslator numberTranslator = new NumberTranslator();

        try {
            String result = numberTranslator.printNumber(input);
            System.out.println("\nРезультат перевода:\n\n" + result);
        } catch (startsFromZeroException e) {
            System.out.println("Ошибка! Целое число не может начинаться с нуля!");
        }
    }
}