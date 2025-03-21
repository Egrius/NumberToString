package org.example;

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


    /*
    @Test
    public void shouldTranslateBeforeBillion() throws IOException {
        NumberTranslator numberTranslator = new NumberTranslator();
        String fullOutputFileName = "src\\test\\java\\org\\example\\data\\numbersBeforeBillion.rba";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fullOutputFileName)));

        for(int i = 1000000; i < 1000000000; i++) {
            out.println(numberTranslator.printNumber(String.valueOf(i)));
        }
        out.close();
        //Лишние гигабайты памяти? Запустите этот тест
    }
*/

}