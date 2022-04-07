package ic.doc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RecentlyUsedListTest {

    RecentlyUsedList list = new RecentlyUsedList();

    @Test
    public void emptyWhenInitialised() {
        assertTrue(list.isEmpty());
        assertThat(list.size(), is(0));
    }

    @Test
    public void canAddThingsToList() {
        list.add("Hello");
        assertFalse(list.isEmpty());
        assertThat(list.size(), is(1));
    }

    @Test
    public void canAddManyThingsToList() {
        list.add("one");
        assertThat(list.size(), is(1));
        assertFalse(list.isEmpty());
        list.add("two");
        assertThat(list.size(), is(2));
        list.add("three");
        assertThat(list.size(), is(3));
    }

    @Test
    public void keepTheMostRecentItemAtTheTopOfTheList() {
        list.add("one");
        list.add("two");
        list.add("three");

        assertThat(list.get(0), is("three"));
        assertThat(list.get(1), is("two"));
        assertThat(list.get(2), is("one"));
    }

    @Test
    public void preventsDuplicate() {
        list.add("one");
        list.add("one");
        assertThat(list.size(), is(1));
    }

    @Test
    public void moveTheMostRecentDuplicateToTheTopOfTheStack() {
        list.add("one");
        list.add("two");
        list.add("one");
        assertThat(list.size(), is(2));
        assertThat(list.get(0), is("one"));
    }
}
