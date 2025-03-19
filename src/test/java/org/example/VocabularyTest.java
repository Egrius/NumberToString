package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VocabularyTest {

    @Test
    //Проверка на правильный перевод цифр
    public void shouldTranslateOneDigitCorrectly() {
        Vocabulary vocabulary = new Vocabulary();
        for(int i = 0; i < 9; i++) {
            Assertions.assertEquals(vocabulary.digits.get(i), vocabulary.translateOne(i));
        }
    }

    @Test
    public void shouldTranslateThousandDigitCorrectly() {
        Vocabulary vocabulary = new Vocabulary();
        Assertions.assertEquals("сто пятьдесят три", vocabulary.translateThousands(153, 3));
        Assertions.assertEquals("сорок шесть", vocabulary.translateThousands(46, 2));
        Assertions.assertEquals("одиннадцать", vocabulary.translateThousands(11, 2));
        Assertions.assertEquals("семь", vocabulary.translateThousands(7, 1));
        Assertions.assertEquals("сто девяносто одна тысяча", vocabulary.translateThousands(191, 6));
        Assertions.assertEquals("восемьдесят три тысячи", vocabulary.translateThousands(83, 5));
        Assertions.assertEquals("триста тридцать три тысячи", vocabulary.translateThousands(333, 6));
        Assertions.assertEquals("девять тысяч", vocabulary.translateThousands(9, 4));
        Assertions.assertEquals("одиннадцать миллиардов", vocabulary.translateThousands(11, 11));
        Assertions.assertEquals("сто тридцать один миллиард", vocabulary.translateThousands(131, 12));

    }

}