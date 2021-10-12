package ic.doc;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class RecentlyUsedListTest {

  @Test
  public void listEmptyWhenInit() {
    assertTrue(new RecentUsedList<Integer>().isEmpty());
  }

  @Test
  public void ableToAddToList() {
    assertTrue(new RecentUsedList<Integer>().add(1));
    assertTrue(new RecentUsedList<Integer>().add(2));
  }

  @Test
  public void ableToRetrieveFromList() {
    RecentUsedList<Integer> recentUsedList = new RecentUsedList<>();
    recentUsedList.add(100);
    assertThat(recentUsedList.retrieve(0), is(100));
  }

  @Test
  public void mostRecentItemIsTheFirst() {
    RecentUsedList<Integer> recentUsedList = new RecentUsedList<>();
    recentUsedList.add(1);
    recentUsedList.add(2);
    recentUsedList.add(3);
    assertThat(recentUsedList.retrieve(0), is(3));
  }

}
