package org.example;

public class Declination {

    private static final String[] decimalBases = {
            "десят", "сот", "тысячн", "десятитысячн", "стотысячн", "миллионн",
            "десятимиллионн", "стомиллионн", "триллион", "десятитриллионн", "стотриллионн"
    };

    //Возврат определенного склонения в зависимости от числа number
    private String getBigIntNumberDeclination(int number, String singular, String few, String many) {
        if (number == 1) return singular;
        else if (number >= 2 && number <= 4) return few;
        else return many;
    }

    //Выбор склонения для целой части числа
    public String getIntDeclination (int number, int count) {
        if (count >= 4 && count <= 6) {
            return getBigIntNumberDeclination(number, "тысяча", "тысячи", "тысяч");
        } else if (count >= 7 && count <= 9) {
            return getBigIntNumberDeclination(number, "миллион", "миллиона", "миллионов");
        } else if (count >= 10 && count <= 12) {
            return getBigIntNumberDeclination(number, "миллиард", "миллиарда", "миллиардов");
        } else if (count >= 13 && count <= 15) {
            return getBigIntNumberDeclination(number, "триллион", "триллиона", "триллионов");
        }
        else return "";
    }

    //Возврат определенного склонения в зависимости от числа number
    private String getDecimalEnding(int number, String singularEnding, String pluralEnding) {
        return (number == 1) ? singularEnding : pluralEnding;
    }

    //Выбор склонения для дробной части числа
    public String getDecimalDeclination (int number, int count) {
        String base = decimalBases[count - 1];
        String ending = getDecimalEnding(number, "ая", "ых");
        return base + ending;
    }

    public Declination() { }
}