package ic.doc;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

  @Test
  public void duplicateInsertionsRemoved() {
    RecentUsedList<Integer> recentUsedList = new RecentUsedList<>();
    recentUsedList.add(1);
    recentUsedList.add(2);
    recentUsedList.add(3);
    recentUsedList.add(2);
    assertThat(recentUsedList.retrieve(0), is(2));
    assertThat(recentUsedList.retrieve(1), is(3));
    assertThat(recentUsedList.retrieve(2), is(1));
    assertThat(recentUsedList.size(), is(3));
  }

  @Test
  public void failToAddNull() {
    RecentUsedList<Integer> recentUsedList = new RecentUsedList<>();
    try {
      recentUsedList.add(null);
      fail("Should throw an exception.");
    } catch (IllegalArgumentException e) {
      assertThat(e.getMessage(), containsString("Cannot add null to the list."));
    }
  }

}
