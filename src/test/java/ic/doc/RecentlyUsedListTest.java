package ic.doc;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class RecentlyUsedListTest {

    @Test
    public void listEmptyWhenInit() {
        assertTrue(new RecentUsedList().isEmpty());
    }

    @Test
    public void ableToAddToList() {
        assertTrue(new RecentUsedList().add(1));
    }

}
