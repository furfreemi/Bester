package bester;

public final class Bester {
    public static <T extends Bestable<T>> T best(T... candidates) {
        if (candidates.length == 0) {
            throw new IllegalArgumentException("No candidates present");
        }
        T currentBest = candidates[0];
        for (T candidate : candidates) {
            if (candidate.isBetterThan(currentBest)) {
                currentBest = candidate;
            }
        }
        return currentBest;
    }
}
