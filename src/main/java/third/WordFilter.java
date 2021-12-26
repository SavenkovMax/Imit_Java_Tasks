package third;

public class WordFilter implements IFilter {
    private final String word;

    public WordFilter(String word) {
        if (word == null) {
            throw new IllegalArgumentException("The word string is null");
        }
        this.word = new String(word);
    }

    public boolean apply(String str) {
        return str.contains(word);
    }
}
