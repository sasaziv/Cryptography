package main;

import java.util.List;

public interface LanguageRules {

    List<Character> getAllCharacters();

    double bruteForce(String string);

    double bruteForce(List<String> string);

}
