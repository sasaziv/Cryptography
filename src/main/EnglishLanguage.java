package main;

import main.fileOperations.ReadFile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EnglishLanguage implements LanguageRules {
    List<Character> characterList = new LinkedList<>(List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', ',', '.', '!', '?', ':', '-', '\"'));


    @Override
    public List<Character> getAllCharacters() {
        return characterList;
    }

    @Override
    public double testLanguageRules() {
        return 0;
    }

    @Override
    public double bruteForce(String string) {
        //  Language rules:

        ArrayList<String> mostCommonWordsInEnglish = new ArrayList<>();

        // 100 most common words in Wnglish - wikipedia
        mostCommonWordsInEnglish.add("the");
        mostCommonWordsInEnglish.add(" be");
        mostCommonWordsInEnglish.add(" to ");
        mostCommonWordsInEnglish.add(" of ");
        mostCommonWordsInEnglish.add(" and ");
        mostCommonWordsInEnglish.add(" a ");
        mostCommonWordsInEnglish.add(" in ");
        mostCommonWordsInEnglish.add("that");
        mostCommonWordsInEnglish.add("have");
        mostCommonWordsInEnglish.add(" I ");
        mostCommonWordsInEnglish.add(" it");
        mostCommonWordsInEnglish.add(" for ");
        mostCommonWordsInEnglish.add(" not ");
        mostCommonWordsInEnglish.add(" on ");
        mostCommonWordsInEnglish.add(" with ");
        mostCommonWordsInEnglish.add(" he ");
        mostCommonWordsInEnglish.add(" as ");
        mostCommonWordsInEnglish.add(" you ");
        mostCommonWordsInEnglish.add(" do ");
        mostCommonWordsInEnglish.add(" at ");
        mostCommonWordsInEnglish.add(" this ");
        mostCommonWordsInEnglish.add(" but ");
        mostCommonWordsInEnglish.add(" his ");
        mostCommonWordsInEnglish.add(" by ");
        mostCommonWordsInEnglish.add(" from ");
        mostCommonWordsInEnglish.add(" they ");
        mostCommonWordsInEnglish.add(" we ");
        mostCommonWordsInEnglish.add(" say ");
        mostCommonWordsInEnglish.add(" her ");
        mostCommonWordsInEnglish.add(" she ");
        mostCommonWordsInEnglish.add(" or ");
        mostCommonWordsInEnglish.add(" an ");
        mostCommonWordsInEnglish.add(" will ");
        mostCommonWordsInEnglish.add(" my ");
        mostCommonWordsInEnglish.add(" one ");
        mostCommonWordsInEnglish.add(" all ");
        mostCommonWordsInEnglish.add(" would ");
        mostCommonWordsInEnglish.add(" there ");
        mostCommonWordsInEnglish.add(" their ");
        mostCommonWordsInEnglish.add(" what ");
        mostCommonWordsInEnglish.add(" so ");
        mostCommonWordsInEnglish.add(" up ");
        mostCommonWordsInEnglish.add(" out ");
        mostCommonWordsInEnglish.add(" if ");
        mostCommonWordsInEnglish.add(" if ");
        mostCommonWordsInEnglish.add(" about ");
        mostCommonWordsInEnglish.add(" who ");
        mostCommonWordsInEnglish.add(" get ");
        mostCommonWordsInEnglish.add(" which ");
        mostCommonWordsInEnglish.add(" go ");
        mostCommonWordsInEnglish.add(" me ");
        mostCommonWordsInEnglish.add(" when ");
        mostCommonWordsInEnglish.add(" make ");
        mostCommonWordsInEnglish.add(" can ");
        mostCommonWordsInEnglish.add(" like ");
        mostCommonWordsInEnglish.add(" time ");
        mostCommonWordsInEnglish.add(" no ");
        mostCommonWordsInEnglish.add(" just ");
        mostCommonWordsInEnglish.add(" him ");
        mostCommonWordsInEnglish.add(" know ");
        mostCommonWordsInEnglish.add(" take ");
        mostCommonWordsInEnglish.add(" people ");
        mostCommonWordsInEnglish.add(" into ");
        mostCommonWordsInEnglish.add(" year ");
        mostCommonWordsInEnglish.add(" your ");
        mostCommonWordsInEnglish.add(" good ");
        mostCommonWordsInEnglish.add(" some ");
        mostCommonWordsInEnglish.add(" could ");
        mostCommonWordsInEnglish.add(" them ");
        mostCommonWordsInEnglish.add(" see ");
        mostCommonWordsInEnglish.add(" other ");
        mostCommonWordsInEnglish.add(" than ");
        mostCommonWordsInEnglish.add(" then ");
        mostCommonWordsInEnglish.add(" now ");
        mostCommonWordsInEnglish.add(" look ");
        mostCommonWordsInEnglish.add(" only ");
        mostCommonWordsInEnglish.add(" its ");
        mostCommonWordsInEnglish.add(" over ");
        mostCommonWordsInEnglish.add(" think ");
        mostCommonWordsInEnglish.add(" also ");
        mostCommonWordsInEnglish.add(" back ");
        mostCommonWordsInEnglish.add(" after ");
        mostCommonWordsInEnglish.add(" use ");
        mostCommonWordsInEnglish.add(" two ");
        mostCommonWordsInEnglish.add(" how ");
        mostCommonWordsInEnglish.add(" our ");
        mostCommonWordsInEnglish.add(" work ");
        mostCommonWordsInEnglish.add(" first ");
        mostCommonWordsInEnglish.add(" well ");
        mostCommonWordsInEnglish.add(" way ");
        mostCommonWordsInEnglish.add(" even ");
        mostCommonWordsInEnglish.add(" new ");
        mostCommonWordsInEnglish.add(" want ");
        mostCommonWordsInEnglish.add(" because ");
        mostCommonWordsInEnglish.add(" any ");
        mostCommonWordsInEnglish.add(" these ");
        mostCommonWordsInEnglish.add(" give ");
        mostCommonWordsInEnglish.add(" day ");
        mostCommonWordsInEnglish.add(" most ");
        mostCommonWordsInEnglish.add(" us ");
        return 0.0;
    }

}
