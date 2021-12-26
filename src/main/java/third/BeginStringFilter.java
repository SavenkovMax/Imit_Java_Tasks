package third;

public class BeginStringFilter implements IFilter {
    private final String pattern;

    public BeginStringFilter(String pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("The pattern string is null");
        }
        this.pattern = new String(pattern);
    }

    public boolean apply(String str) {

        return str.split(" ")[0].equals(pattern);
    }
}
