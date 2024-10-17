package game;

import util.DisplayWord;
import util.HangmanDictionary;

public abstract class AbstractHangmanGame {
    protected static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    protected String mySecretWord;
    protected int myNumGuessesLeft;
    protected DisplayWord myDisplayWord;
    protected StringBuilder myLettersLeftToGuess;

    public AbstractHangmanGame(HangmanDictionary dictionary, int wordLength, int numGuesses) {
        mySecretWord = getSecretWord(dictionary, wordLength);  // Abstract method
        myNumGuessesLeft = numGuesses;
        myLettersLeftToGuess = new StringBuilder(ALPHABET);
        myDisplayWord = new DisplayWord(mySecretWord);
    }

    public void play() {
        boolean gameOver = false;
        while (!gameOver) {
            printStatus();
            Character guess = getGuess(); // Abstract method for game-specific guessing logic
            makeGuess(guess);
            if (isGameLost()) {
                System.out.println("YOU ARE HUNG!!!");
                gameOver = true;
            } else if (isGameWon()) {
                System.out.println("YOU WIN!!!");
                gameOver = true;
            }
        }
        System.out.println("The secret word was " + mySecretWord);
    }

    protected void makeGuess(char guess) {
        int index = myLettersLeftToGuess.indexOf("" + guess);
        if (index >= 0) {
            recordGuess(index);
            if (!checkGuessInSecret(guess)) {
                myNumGuessesLeft -= 1;
            }
        }
    }

    protected void recordGuess(int index) {
        myLettersLeftToGuess.deleteCharAt(index);
    }

    protected boolean checkGuessInSecret(char guess) {
        if (mySecretWord.indexOf(guess) >= 0) {
            myDisplayWord.update(guess, mySecretWord);
            return true;
        }
        return false;
    }

    protected boolean isGameWon() {
        return myDisplayWord.equals(mySecretWord);
    }

    protected boolean isGameLost() {
        return myNumGuessesLeft == 0;
    }

    protected void printStatus() {
        System.out.println(myDisplayWord);
        System.out.println("# misses left = " + myNumGuessesLeft);
        System.out.println("letters not yet guessed = " + myLettersLeftToGuess);
    }

    protected abstract Character getGuess();
    protected abstract String getSecretWord(HangmanDictionary dictionary, int wordLength);
}
