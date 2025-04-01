package org.example;

import java.util.Scanner;
/**
 *  Класс App представляет собой основную точку запуска программы NumberTranslator.
 *  Пользователь вводит число для перевода, и программа обрабатывает введенные данные,
 *  возвращая строковое представление числа.
 * @author Egrius.
 * @version 2.1.
 */
public class App
{
    /**
     * Точка входа в программу. Запрашивает у пользователя ввод числа и переводит его в строковое представление.
     * <p>
     * Пример использования:
     * <pre>
     *     Введите число: 123.45
     *     Результат перевода:
     *     сто двадцать три целых сорок пять сотых
     * </pre>
     *
     * @param args массив аргументов командной строки (не используется в данной реализации).
     * Обрабатывает возможные исключения, возникающие при переводе числа:
     * @throws StartsFromZeroException если введенное число начинается с нуля, что недопустимо.
     * @throws StringIndexOutOfBoundsException если входная строка пуста.
     * @throws InvalidCharException выбрасывается, если входная строка содержит символы,
     *                              отличные от цифр, точки или запятой.
     */
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число, которое нужно перевести: ");
        String input = scanner.nextLine();

        NumberTranslator numberTranslator = new NumberTranslator();

        try {
            String result = numberTranslator.printNumber(input);
            System.out.println("\nРезультат перевода:\n\n" + result);
        } catch (StartsFromZeroException e) {
            System.out.println("Ошибка! Целое число не может начинаться с нуля!");
        } catch (StringIndexOutOfBoundsException | InvalidCharException e) {
            System.out.println(e.getMessage());
        }
    }
}
