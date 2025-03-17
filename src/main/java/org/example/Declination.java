package org.example;

public class Declination {
    private String getBigNumberDeclination(int number, String singular, String few, String many) {
        if (number == 1) return singular;
        else if (number >= 2 && number <= 4) return few;
        else return many;
    }

    public String getDeclination (int count, int number) {
        if (count >= 4 && count <= 6) {
            return getBigNumberDeclination(number, "тысяча", "тысячи", "тысяч");
        } else if (count >= 7 && count <= 9) {
            return getBigNumberDeclination(number, "миллион", "миллиона", "миллионов");
        } else if (count >= 10 && count <= 13) {
            return getBigNumberDeclination(number, "миллиард", "миллиарда", "миллиардов");
        }
        else return "";
    }
    public Declination() {

    }
}
