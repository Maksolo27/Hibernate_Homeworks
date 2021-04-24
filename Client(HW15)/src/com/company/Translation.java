package com.company;

/**
 * Created by maxim on 24.04.2021.
 */
public class Translation {

    private String iWord;
    private String oWord;

    public String getiWord() {
        return iWord;
    }

    public void setiWord(String iWord) {
        this.iWord = iWord;
    }

    public String getoWord() {
        return oWord;
    }

    public void setoWord(String oWord) {
        this.oWord = oWord;
    }

    @Override
    public String toString() {
        return "Translation{" +
                "iWord='" + iWord + '\'' +
                ", oWord='" + oWord + '\'' +
                '}';
    }
}
