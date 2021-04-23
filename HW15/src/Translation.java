import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by maxim on 23.04.2021.
 */
public class Translation {


    private String iWord;
    private String oWord;

    public Translation(String inputWord, String outputWord) {
        this.iWord = inputWord;
        this.oWord = outputWord;
    }

    public Translation(){

    }

    public static Translation translate(String inpWord){
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("есть", "to eat");
        dictionary.put("животное", "animal");
        dictionary.put("кот", "cat");
        String outWord = dictionary.get(inpWord);
        System.out.println(outWord);
        return new Translation(inpWord, outWord);
    }

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
}
