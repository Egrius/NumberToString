package org.example;

public class Declination {

    private static final String[] singularDecimalDeclensions = {
            "десятая", "сотая", "тысячная",
            "дясятитысячная", "статысячная", "миллионная",
            "дясятимиллионная", "стамиллионная"
    };
    private static final String[] pluralDecimalDeclensions = {
            "десятых", "сотых", "тысячных",
            "дясятитысячных", "статысячных", "миллионных",
            "дясятимиллионных", "стамиллионных"
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
        }
        else return "";
    }

    //Возврат определенного склонения в зависимости от числа number
    private String getBigDecimalNumberDeclination(int number, String singular, String many) {
        if (number == 1) return singular;
        else return many;
    }
    //Выбор склонения для дробной части числа
    public String getDecimalDeclination (int number, int count) {

        return getBigDecimalNumberDeclination(number, singularDecimalDeclensions[count-1], pluralDecimalDeclensions[count-1]);
    }


    public Declination() { }
}