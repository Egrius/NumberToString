package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class FillData {
    public static void main(String[] args) {
        final String path = "src\\test\\java\\org\\example\\data\\";
        final String filename = "input.txt";

        try {
            FileWriter myWriter = new FileWriter(path+filename);
            int i = 1;

            for(i = 1; i < Integer.MAX_VALUE; i++) {
                myWriter.write(i + "\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
