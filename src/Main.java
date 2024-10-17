import game.*;
import util.HangmanDictionary;

public class HangmanMain {
    public static void main(String[] args) {
        HangmanDictionary dictionary = new HangmanDictionary("lowerwords.txt");

        AbstractGuesser normalGuesser = new NormalGuesser();
        AbstractGuesser autoGuesser = new AutoGuesser();
        AbstractExecutioner normalExecutioner = new NormalExecutioner(dictionary, 5);
        AbstractExecutioner cheatingExecutioner = new CheatingExecutioner(dictionary, 5);

        HangmanGame game1 = new HangmanGame(normalGuesser, normalExecutioner, dictionary, 5, 6);
        game1.play();

        HangmanGame game2 = new HangmanGame(autoGuesser, normalExecutioner, dictionary, 5, 6);
        game2.play();

        HangmanGame game3 = new HangmanGame(normalGuesser, cheatingExecutioner, dictionary, 5, 6);
        game3.play();

        HangmanGame game4 = new HangmanGame(autoGuesser, cheatingExecutioner, dictionary, 5, 6);
        game4.play();
    }
}
