package bester;

public class Cookie implements Bestable<Cookie> {

    private final int numberOfChocolateChips;

    public Cookie(final int numberOfChocolateChips) {
        this.numberOfChocolateChips = numberOfChocolateChips;
    }

    @Override
    public boolean isBetterThan(Cookie opponent) {
        return numberOfChocolateChips > opponent.numberOfChocolateChips;
    }
}