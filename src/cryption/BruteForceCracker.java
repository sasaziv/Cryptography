package cryption;

import languages.LanguageRules;

import java.util.ArrayList;
import java.util.List;

public class BruteForceCracker{

    List<Character> characters;
    LanguageRules languageRules;

    public BruteForceCracker(LanguageRules languageRules) {
        this.languageRules = languageRules;
        this.characters = languageRules.getCharacters();
    }

    public int bruteForce(List<String> listInput, LanguageRules languageRules) {
        ArrayList<Double> decryptionValue = new ArrayList<>();
        for (int i = 0; i < characters.size(); i++) {
            CaesarCipher caesarCipher = new CaesarCipher(i, languageRules);
            List<String> list = caesarCipher.decodeFile(listInput);
            decryptionValue.add(i, languageRules.bruteForce(list));
        }
        double maxScore = decryptionValue.get(0);
        for (double score : decryptionValue) {
            if (score > maxScore) {
                maxScore = score;
            }
        }
        return decryptionValue.indexOf(maxScore);
    }
}
