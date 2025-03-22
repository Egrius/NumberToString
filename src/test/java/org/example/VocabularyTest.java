package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

class VocabularyTest {

    @Test
    public void shouldTranslateBeforeThousand() throws IOException {
        NumberTranslator numberTranslator = new NumberTranslator();
        String fullOutputFileName = "src\\test\\java\\org\\example\\data\\numbersBeforeThousand.rba";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fullOutputFileName)));

        for(int i = 0; i < 1000; i++) {
            out.println(numberTranslator.printNumber(String.valueOf(i)));
        }
        out.close();
    }

    @Test
    public void shouldTranslateBeforeMillion() throws IOException {
        NumberTranslator numberTranslator = new NumberTranslator();
        String fullOutputFileName = "src\\test\\java\\org\\example\\data\\numbersBeforeMillion.rba";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fullOutputFileName)));

        for(int i = 1000; i < 1000000; i++) {
            out.println(numberTranslator.printNumber(String.valueOf(i)));
        }
        out.close();
    }
    @Test
    public void shouldTranslateNegativesFromThousand() throws IOException {
        NumberTranslator numberTranslator = new NumberTranslator();
        String fullOutputFileName = "src\\test\\java\\org\\example\\data\\negativeNumbersFromThousand.rba";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fullOutputFileName)));

        for(int i = -1000; i < 0; i++) {
            out.println(numberTranslator.printNumber(String.valueOf(i)));
        }
        out.close();
    }

    @Test
    public void shouldTranslateNumbers() throws IOException {
        NumberTranslator numberTranslator = new NumberTranslator();
        String fullOutputFileName = "src\\test\\java\\org\\example\\data\\randomNumbers.rba";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fullOutputFileName)));


        String buf = numberTranslator.printNumber(String.valueOf(1));
        Assertions.assertEquals("один", buf);
        out.println(buf);

        buf = numberTranslator.printNumber(String.valueOf(1234));
        Assertions.assertEquals("одна тысяча двести тридцать четыре", buf);
        out.println(buf);

        buf = numberTranslator.printNumber(String.valueOf(-150));
        Assertions.assertEquals("минус сто пятьдесят", buf);
        out.println(buf);

        buf = numberTranslator.printNumber("11222333444");
        Assertions.assertEquals("одиннадцать миллиардов двести двадцать два миллиона триста тридцать три тысячи четыреста сорок четыре", buf);
        out.println(buf);

        out.close();
    }
}