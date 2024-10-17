package game;

public class AutoGuesser extends AbstractGuesser {
    private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";
    private String letters;
    private int index;

    public AutoGuesser() {
        this.letters = LETTERS_ORDERED_BY_FREQUENCY;
        this.index = 0;
    }

    @Override
    public Character getGuess() {
        if (index < letters.length()) {
            return letters.charAt(index++);
        }
        return null; 
    }
}
