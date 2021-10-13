package ic.doc;

import java.util.LinkedList;

public class RecentlyUsedList<T> {

  private final LinkedList<T> elements;

  public RecentlyUsedList() {
    this.elements = new LinkedList<>();
  }

  public boolean isEmpty() {
    return elements.size() == 0;
  }

  public boolean add(T elem) {
    if (elem == null) {
      throw new IllegalArgumentException("Cannot add null to the list.");
    }
    elements.remove(elem);
    elements.addFirst(elem);
    return true;
  }

  public T retrieve(int i) {
    return elements.get(i);
  }

  public int size() {
    return elements.size();
  }
}
