package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EnglishLanguage implements LanguageRules {
    List<Character> characterList = new ArrayList<>(List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', ',', '.', '!', '?', ':', '-', '\"'));


    @Override
    public List<Character> getAllCharacters() {
        return characterList;
    }

    // Getting the value of brute force for list
    public double bruteForce(List<String> list) {
        double result = 0;
        for (String string : list) {
            result += bruteForce(string);
        }
        return result;
    }

    // Getting the value of brute force for string
    @Override
    public double bruteForce(String textline) {

        double resultOfTestingWords = containsWord(textline);
        double resultOfTestingSimpleGrammer = mostCommonRulesInEnglish(textline);

        return resultOfTestingWords + resultOfTestingSimpleGrammer;
    }

    // Testing on simple grammar rules. Sentence start with big letter. Space after dot, comma....
    private double mostCommonRulesInEnglish(String textline) {
        double result = 0.0;
        char currentChar;
        char nextChar;
        int countOfDoubleQuotes = 0;
        for (int i = 0; i < textline.length() - 1; i++) {
            currentChar = textline.charAt(i);
            nextChar = textline.charAt(i + 1);
            if (currentChar == '.' && nextChar == ' ' || currentChar == '.' && nextChar == '.') {
                result += 0.5;
            }
            if (currentChar == '!' || currentChar == '?' || currentChar == ',' || currentChar == ':') {
                result += 0.5;
            }
            if (currentChar == '\"') {
                countOfDoubleQuotes++;
            }
        }
        if (countOfDoubleQuotes % 2 == 0) {
            result += 2;
        }
        return result;
    }


    // Testing for most common words and non-existing pairs of chars in English language
    private double containsWord(String textLine) {
        double result = 0.0;
        textLine = textLine.toLowerCase();
        ArrayList<String> mostCommonWordsInEnglish = new ArrayList<>();
        ArrayList<String> nonexistentCharacterStrings = new ArrayList<>();

        // 100 most common words in Wnglish - wikipedia
        mostCommonWordsInEnglish.add("the");
        mostCommonWordsInEnglish.add("be");
        mostCommonWordsInEnglish.add("to");
        mostCommonWordsInEnglish.add(" of");
        mostCommonWordsInEnglish.add(" and");
        mostCommonWordsInEnglish.add(" a");
        mostCommonWordsInEnglish.add(" in");
        mostCommonWordsInEnglish.add(" that");
        mostCommonWordsInEnglish.add(" have");
        mostCommonWordsInEnglish.add(" i ");
        mostCommonWordsInEnglish.add(" it");
        mostCommonWordsInEnglish.add(" for");
        mostCommonWordsInEnglish.add(" not");
        mostCommonWordsInEnglish.add(" on");
        mostCommonWordsInEnglish.add(" with");
        mostCommonWordsInEnglish.add(" he");
        mostCommonWordsInEnglish.add(" as");
        mostCommonWordsInEnglish.add(" you");
        mostCommonWordsInEnglish.add(" do");
        mostCommonWordsInEnglish.add(" at");
        mostCommonWordsInEnglish.add(" this");
        mostCommonWordsInEnglish.add(" but");
        mostCommonWordsInEnglish.add(" his");
        mostCommonWordsInEnglish.add(" by");
        mostCommonWordsInEnglish.add(" from");
        mostCommonWordsInEnglish.add(" they");
        mostCommonWordsInEnglish.add(" we");
        mostCommonWordsInEnglish.add(" say");
        mostCommonWordsInEnglish.add(" her");
        mostCommonWordsInEnglish.add(" she");
        mostCommonWordsInEnglish.add(" or");
        mostCommonWordsInEnglish.add(" an");
        mostCommonWordsInEnglish.add(" will");
        mostCommonWordsInEnglish.add(" my");
        mostCommonWordsInEnglish.add(" one");
        mostCommonWordsInEnglish.add(" all");
        mostCommonWordsInEnglish.add(" would");
        mostCommonWordsInEnglish.add(" there");
        mostCommonWordsInEnglish.add(" their");
        mostCommonWordsInEnglish.add(" what");
        mostCommonWordsInEnglish.add(" so");
        mostCommonWordsInEnglish.add(" up");
        mostCommonWordsInEnglish.add(" out");
        mostCommonWordsInEnglish.add(" if");
        mostCommonWordsInEnglish.add(" about");
        mostCommonWordsInEnglish.add(" who");
        mostCommonWordsInEnglish.add(" get");
        mostCommonWordsInEnglish.add(" which");
        mostCommonWordsInEnglish.add(" go");
        mostCommonWordsInEnglish.add(" me");
        mostCommonWordsInEnglish.add(" when");
        mostCommonWordsInEnglish.add(" make");
        mostCommonWordsInEnglish.add(" can");
        mostCommonWordsInEnglish.add(" like");
        mostCommonWordsInEnglish.add(" time");
        mostCommonWordsInEnglish.add(" no");
        mostCommonWordsInEnglish.add(" just");
        mostCommonWordsInEnglish.add(" him");
        mostCommonWordsInEnglish.add(" know");
        mostCommonWordsInEnglish.add(" take");
        mostCommonWordsInEnglish.add(" people");
        mostCommonWordsInEnglish.add(" into");
        mostCommonWordsInEnglish.add(" year");
        mostCommonWordsInEnglish.add(" your");
        mostCommonWordsInEnglish.add(" good");
        mostCommonWordsInEnglish.add(" some");
        mostCommonWordsInEnglish.add(" could");
        mostCommonWordsInEnglish.add(" them");
        mostCommonWordsInEnglish.add(" see");
        mostCommonWordsInEnglish.add(" other");
        mostCommonWordsInEnglish.add(" than");
        mostCommonWordsInEnglish.add(" then");
        mostCommonWordsInEnglish.add(" now");
        mostCommonWordsInEnglish.add(" look");
        mostCommonWordsInEnglish.add(" only");
        mostCommonWordsInEnglish.add(" its");
        mostCommonWordsInEnglish.add(" over");
        mostCommonWordsInEnglish.add(" think");
        mostCommonWordsInEnglish.add(" also");
        mostCommonWordsInEnglish.add(" back");
        mostCommonWordsInEnglish.add(" after");
        mostCommonWordsInEnglish.add(" use");
        mostCommonWordsInEnglish.add(" two");
        mostCommonWordsInEnglish.add(" how");
        mostCommonWordsInEnglish.add(" our");
        mostCommonWordsInEnglish.add(" work");
        mostCommonWordsInEnglish.add(" first");
        mostCommonWordsInEnglish.add(" well");
        mostCommonWordsInEnglish.add(" way");
        mostCommonWordsInEnglish.add(" even");
        mostCommonWordsInEnglish.add(" new");
        mostCommonWordsInEnglish.add(" want");
        mostCommonWordsInEnglish.add(" because");
        mostCommonWordsInEnglish.add(" any");
        mostCommonWordsInEnglish.add(" these");
        mostCommonWordsInEnglish.add(" give");
        mostCommonWordsInEnglish.add(" day");
        mostCommonWordsInEnglish.add(" most");
        mostCommonWordsInEnglish.add(" us");

        //Non-existent Character Strings (2 char) - from Quora https://www.quora.com/What-are-all-of-the-two-letter-combinations-that-never-occur-in-an-English-dictionary
        nonexistentCharacterStrings.add("bx");
        nonexistentCharacterStrings.add("cj");
        nonexistentCharacterStrings.add("cv");
        nonexistentCharacterStrings.add("cx");
        nonexistentCharacterStrings.add("dx");
        nonexistentCharacterStrings.add("fq");
        nonexistentCharacterStrings.add("fx");
        nonexistentCharacterStrings.add("gq");
        nonexistentCharacterStrings.add("gx");
        nonexistentCharacterStrings.add("hx");
        nonexistentCharacterStrings.add("jc");
        nonexistentCharacterStrings.add("jf");
        nonexistentCharacterStrings.add("jg");
        nonexistentCharacterStrings.add("jq");
        nonexistentCharacterStrings.add("js");
        nonexistentCharacterStrings.add("jv");
        nonexistentCharacterStrings.add("jw");
        nonexistentCharacterStrings.add("jx");
        nonexistentCharacterStrings.add("jz");
        nonexistentCharacterStrings.add("kq");
        nonexistentCharacterStrings.add("kx");
        nonexistentCharacterStrings.add("mx");
        nonexistentCharacterStrings.add("px");
        nonexistentCharacterStrings.add("pz");
        nonexistentCharacterStrings.add("qb");
        nonexistentCharacterStrings.add("qc");
        nonexistentCharacterStrings.add("qd");
        nonexistentCharacterStrings.add("qf");
        nonexistentCharacterStrings.add("qg");
        nonexistentCharacterStrings.add("qh");
        nonexistentCharacterStrings.add("qj");
        nonexistentCharacterStrings.add("qk");
        nonexistentCharacterStrings.add("ql");
        nonexistentCharacterStrings.add("qm");
        nonexistentCharacterStrings.add("qn");
        nonexistentCharacterStrings.add("qp");
        nonexistentCharacterStrings.add("qs");
        nonexistentCharacterStrings.add("qt");
        nonexistentCharacterStrings.add("qv");
        nonexistentCharacterStrings.add("qw");
        nonexistentCharacterStrings.add("qx");
        nonexistentCharacterStrings.add("qy");
        nonexistentCharacterStrings.add("qz");
        nonexistentCharacterStrings.add("sx");
        nonexistentCharacterStrings.add("vb");
        nonexistentCharacterStrings.add("vf");
        nonexistentCharacterStrings.add("vh");
        nonexistentCharacterStrings.add("vj");
        nonexistentCharacterStrings.add("vm");
        nonexistentCharacterStrings.add("vp");
        nonexistentCharacterStrings.add("vq");
        nonexistentCharacterStrings.add("vt");
        nonexistentCharacterStrings.add("vw");
        nonexistentCharacterStrings.add("vx");
        nonexistentCharacterStrings.add("wx");
        nonexistentCharacterStrings.add("xj");
        nonexistentCharacterStrings.add("xx");
        nonexistentCharacterStrings.add("xj");
        nonexistentCharacterStrings.add("zq");
        nonexistentCharacterStrings.add("zx");


        for (String word : mostCommonWordsInEnglish) {
            if (textLine.contains(word)) {
                result++;
            }
        }
        for (String word : nonexistentCharacterStrings) {
            if (textLine.contains(word)) {
                result -= 2;
            }
        }
        return result;
    }
}
