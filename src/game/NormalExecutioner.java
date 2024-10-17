package game;

import util.HangmanDictionary;

public class NormalExecutioner extends AbstractExecutioner {
    public NormalExecutioner(HangmanDictionary dictionary, int wordLength) {
        super(dictionary, wordLength);
    }

    @Override
    protected String makeSecretWord(HangmanDictionary dictionary, int wordLength) {
        return dictionary.getRandomWord(wordLength).toLowerCase();
    }
}
