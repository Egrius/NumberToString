package org.example;

/*
Планы:
    - разобраться как работать с файлами
    - обработка отрицательных чисел

    P.S. После написания отдельных методов реализовать функцию, вызывающую эти функции в соответсвии с разрядностью.
    Реализовать логику по принципу разбиения на разряды миллионов, тысяч, сотен, опираясь от count и игнорировать нули.
 */

public class App 
{
    public static void main( String[] args )
    {
        NumberTranslator numberTranslator = new NumberTranslator("-111222333444");
        String result = numberTranslator.printNumber();
        System.out.println(result);

    }
}
