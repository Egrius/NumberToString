package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VocabularyTest {

    @Test
    //Проверка на правильный перевод цифр
    public void shouldTranslateOneDigitCorrectly() {
        Vocabulary vocabulary = new Vocabulary();
        for(int i = 0; i < 9; i++) {
            Assertions.assertEquals(vocabulary.digits.get(i), vocabulary.translateOne(i));
        }
    }

}