package bester;

public interface Bestable<T> {
    boolean isBetterThan(T opponent);
}
