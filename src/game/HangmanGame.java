package game;

import util.HangmanDictionary;

public class HangmanGame extends AbstractHangmanGame {
    private AbstractGuesser guesser;
    private AbstractExecutioner executioner;

    public HangmanGame(AbstractGuesser guesser, AbstractExecutioner executioner, HangmanDictionary dictionary, int wordLength, int numGuesses) {
        super(dictionary, wordLength, numGuesses);
        this.guesser = guesser;
        this.executioner = executioner;
    }

    @Override
    protected Character getGuess() {
        return guesser.getGuess();
    }

    @Override
    protected String getSecretWord(HangmanDictionary dictionary, int wordLength) {
        return executioner.secretWord; // This will be set during executioner's constructor
    }

    public void play() {
        super.play();
    }
}
