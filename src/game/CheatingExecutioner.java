package game;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class CheatingExecutioner extends AbstractExecutioner {
    private List<String> remainingWords;

    public CheatingExecutioner(HangmanDictionary dictionary, int wordLength) {
        super(dictionary, wordLength);
        remainingWords = dictionary.getWords(wordLength);
    }

    @Override
    protected String makeSecretWord(HangmanDictionary dictionary, int wordLength) {
        return dictionary.getRandomWord(wordLength).toLowerCase();
    }

    public void cheat(char guess) {
        HashMap<DisplayWord, List<String>> templatedWords = new HashMap<>();
        for (String word : remainingWords) {
            DisplayWord template = new DisplayWord(displayWord);
            template.update(guess, word);
            templatedWords.computeIfAbsent(template, k -> new ArrayList<>()).add(word);
        }

        int maxMatches = 0;
        DisplayWord bestTemplate = null;
        for (Entry<DisplayWord, List<String>> entry : templatedWords.entrySet()) {
            if (entry.getValue().size() > maxMatches) {
                maxMatches = entry.getValue().size();
                bestTemplate = entry.getKey();
            }
        }

        remainingWords = templatedWords.get(bestTemplate);
        Collections.shuffle(remainingWords);
        secretWord = remainingWords.get(0);
        displayWord = bestTemplate;
    }
}
