package org.example;

import org.junit.jupiter.api.Test;
import java.io.*;

class NumberTranslatorTest {

    @Test
    public void shouldTranslateBeforeThousand() {
        NumberTranslator numberTranslator = new NumberTranslator();
        String fullInputFileName = "src\\test\\java\\org\\example\\data\\inputFiles\\beforeThousandInput.txt";
        String fullOutputFileName = "src\\test\\java\\org\\example\\data\\outputFiles\\beforeThousandOutput.txt";

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fullOutputFileName)));
            BufferedReader reader = new BufferedReader(new FileReader(fullInputFileName));

            String line;
            while ((line = reader.readLine()) != null) {
                String translatedNumber = numberTranslator.printNumber(line);

                out.println(translatedNumber);
            }
            out.close();
            reader.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void shouldTranslateBeforeMillion() {
        NumberTranslator numberTranslator = new NumberTranslator();
        String fullInputFileName = "src\\test\\java\\org\\example\\data\\inputFiles\\beforeMillionInput.txt";
        String fullOutputFileName = "src\\test\\java\\org\\example\\data\\outputFiles\\beforeMillionOutput.txt";

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fullOutputFileName)));
            BufferedReader reader = new BufferedReader(new FileReader(fullInputFileName));

            String line;
            while ((line = reader.readLine()) != null) {
                String translatedNumber = numberTranslator.printNumber(line);

                out.println(translatedNumber);
            }
            out.close();
            reader.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void shouldTranslateNumbers() {
       NumberTranslator numberTranslator = new NumberTranslator();
       String fullInputFileName = "src\\test\\java\\org\\example\\data\\inputFiles\\randomBeforeMillion.txt";
       String fullOutputFileName = "src\\test\\java\\org\\example\\data\\outputFiles\\randomBeforeMillionOutput.txt";
       try {
           PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fullOutputFileName)));
           BufferedReader reader = new BufferedReader(new FileReader(fullInputFileName));

           String line;
           while ((line = reader.readLine()) != null) {

               String translatedNumber = numberTranslator.printNumber(line);

               out.println(translatedNumber);
               out.println();

           }
           out.close();
           reader.close();
       } catch(Exception e){
           System.out.println(e);
       }
   }
}