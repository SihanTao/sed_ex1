package ic.doc;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecentUsedList<T> {

  private final LinkedList<T> elements;

  public RecentUsedList() {
    this.elements = new LinkedList<>();
  }

  public boolean isEmpty() {
    return true;
  }

  public boolean add(T elem) {
    if (elements.contains(elem)) {
      elements.remove(elem);
    }
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
