package game;

import util.ConsoleReader;

public class NormalGuesser extends AbstractGuesser {
    @Override
    public Character getGuess() {
        String guess = ConsoleReader.promptString("Make a guess: ");
        if (guess.length() == 1 && Character.isAlphabetic(guess.charAt(0))) {
            return guess.toLowerCase().charAt(0);
        } else {
            System.out.println("Please enter a single letter ...");
            return getGuess();
        }
    }
}
