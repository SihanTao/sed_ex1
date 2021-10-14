package ic.doc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

    RecentlyUsedList<Integer> recentlyUsedList2 = new RecentlyUsedList<>();
    recentlyUsedList2.add(3);
    recentlyUsedList2.add(4);
    recentlyUsedList2.add(5);
    assertThat(recentlyUsedList2.retrieve(0), is(5));

    recentlyUsedList2.add(4);
    recentlyUsedList2.add(3);
    assertThat(recentlyUsedList2.retrieve(0), is(3));
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
    recentlyUsedList.add(3);
    recentlyUsedList.add(2);
    assertThat(recentlyUsedList.retrieve(0), is(2));
    assertThat(recentlyUsedList.retrieve(1), is(3));
    assertThat(recentlyUsedList.retrieve(2), is(1));
    assertThat(recentlyUsedList.size(), is(3));
  }

  @Test
  public void failToAddNull() {
    RecentlyUsedList<Integer> recentlyUsedList = new RecentlyUsedList<>();
    try {
      recentlyUsedList.add(null);
      fail("Should throw an exception.");
    } catch (IllegalArgumentException e) {
      assertThat(e.getMessage(), containsString("Cannot add null to the list."));
    }
  }

}
