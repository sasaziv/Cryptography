package languages;

import java.util.List;

public interface LanguageRules {

    List<Character> getCharacters();

    double bruteForce(String string);

    double bruteForce(List<String> string);

}
