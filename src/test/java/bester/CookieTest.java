package bester;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public final class CookieTest {
    @Test
    public void chocolatierShouldBeBetterThanLessChocolateyCookie() throws Exception {
        final Cookie worseCookie = new Cookie(1);
        final Cookie betterCookie = new Cookie(100);

        assertThat(betterCookie, isBetterThan(worseCookie));
    }

    @Test
    public void lessChocolateyShouldNotBeBetterThanMoreChocolateyCookie() throws Exception {
        final Cookie betterCookie = new Cookie(100);
        final Cookie worseCookie = new Cookie(1);

        assertThat(worseCookie, not(isBetterThan(betterCookie)));
    }

    private <T extends Bestable<T>> Matcher<T> isBetterThan(T worseItem) {
        return new BaseMatcher<T>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Cookie with less chips");
            }

            @Override
            public boolean matches(Object item) {
                return (item instanceof Bestable) && ((Bestable<T>) item).isBetterThan(worseItem);
            }
        };
    }
}
