package ic.doc;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class RecentlyUsedListTest {

  @Test
  public void listEmptyWhenInit() {
    assertTrue(new RecentlyUsedList<Integer>().isEmpty());
  }

  @Test
  public void ableToAddToList() {
    assertTrue(new RecentlyUsedList<Integer>().add(1));
    assertTrue(new RecentlyUsedList<Integer>().add(2));
  }

  @Test
  public void ableToRetrieveFromList() {
    RecentlyUsedList<Integer> recentlyUsedList = new RecentlyUsedList<>();
    recentlyUsedList.add(100);
    assertThat(recentlyUsedList.retrieve(0), is(100));
  }

  @Test
  public void mostRecentItemIsTheFirst() {
    RecentlyUsedList<Integer> recentlyUsedList = new RecentlyUsedList<>();
    recentlyUsedList.add(1);
    recentlyUsedList.add(2);
    recentlyUsedList.add(3);
    assertThat(recentlyUsedList.retrieve(0), is(3));
  }

  @Test
  public void duplicateInsertionsRemoved() {
    RecentlyUsedList<Integer> recentlyUsedList = new RecentlyUsedList<>();
    recentlyUsedList.add(1);
    recentlyUsedList.add(2);
    recentlyUsedList.add(3);
    recentlyUsedList.add(2);
    assertThat(recentlyUsedList.retrieve(0), is(2));
    assertThat(recentlyUsedList.retrieve(1), is(3));
    assertThat(recentlyUsedList.retrieve(2), is(1));
    assertThat(recentlyUsedList.size(), is(3));
  }

}
