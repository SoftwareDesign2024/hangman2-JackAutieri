package game;

import util.DisplayWord;
import util.HangmanDictionary;

public abstract class AbstractExecutioner {
    protected String secretWord;
    protected DisplayWord displayWord;

    public AbstractExecutioner(HangmanDictionary dictionary, int wordLength) {
        secretWord = makeSecretWord(dictionary, wordLength);
        displayWord = new DisplayWord(secretWord);
    }

    public boolean checkGuess(char guess) {
        if (secretWord.indexOf(guess) >= 0) {
            displayWord.update(guess, secretWord);
            return true;
        }
        return false;
    }

    public boolean isWordGuessed() {
        return displayWord.equals(secretWord);
    }

    public String getDisplayWord() {
        return displayWord.toString();
    }

    protected abstract String makeSecretWord(HangmanDictionary dictionary, int wordLength);
}
