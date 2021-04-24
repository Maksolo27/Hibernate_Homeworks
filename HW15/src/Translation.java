import java.sql.*;
import java.util.ArrayList;
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
        List<Translation> dictionary = new ArrayList<>();
        dictionary.add(new Translation("ja","yes"));
        dictionary.add(new Translation("nein", "no"));
        dictionary.add(new Translation("haus", "home"));
        for (Translation translation: dictionary) {
            if(translation.getiWord().equals(inpWord)){
                return translation;
            }
        }
        return new Translation(inpWord, "Такого слова нету");
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
