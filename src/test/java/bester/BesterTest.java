package bester;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class BesterTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldCrashOnEmptyInputToBest() {
        Bester.best(/* No args */);
    }

    @Test
    public void shouldReturnCandidateWhenGivenOnlyOneCandidate() throws Exception {
        Bestable candidate = new MockBestable();

        assertEquals(candidate, Bester.best(candidate));
    }

    @Test
    public void shouldReturnBetterCandidateWhenGivenTwoCandidates() throws Exception {
        Bestable worse = new MockBestable();
        Bestable better = new MockBestable().whenAskedIfBetter(true);

        assertEquals(better, Bester.best(worse, better));
    }

    @Test
    public void shouldReturnBestCandidateWhenGivenManyCandidates() throws Exception {
        Bestable worse = new MockBestable();
        Bestable better = new MockBestable().whenAskedIfBetter(true);
        Bestable best = new MockBestable().whenAskedIfBetter(true);

        assertEquals(best, Bester.best(worse, better, best));
    }

    @Test
    public void shouldFindChocolatiestCookie() {
        Cookie best = new Cookie(100);
        Bestable[] bestables = new Cookie[]{new Cookie(1), new Cookie(5), best};

        assertEquals(best, Bester.best(bestables));
    }

    @Test
    public void shouldFindBiggestRectangle() {
        Rectangle best = new Rectangle(100, 100);
        Bestable[] bestables = new Rectangle[]{new Rectangle(1, 1), new Rectangle(3, 5), best};

        assertEquals(best, Bester.best(bestables));
    }

    private class MockBestable implements Bestable {
        private boolean best;

        Bestable whenAskedIfBetter(boolean best) {
            this.best = best;
            return this;
        }

        @Override
        public boolean isBetterThan(Object candidate) {
            return best;
        }
    }
}
