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
    if (isEmpty()) {
      throw new UnsupportedOperationException(
          "RecentlyUsedList.java: retrieve: " + "Unsupported Operation: The index is negative");
    }

    if (i < 0) {
      throw new IllegalArgumentException(
          "RecentlyUsedList.java: retrieve: " + "Illegal Argument: The index is negative.");
    }

    if (i >= size()) {
      throw new IndexOutOfBoundsException(
          "RecentlyUsedList.java: retrieve: " + "Index Out Of Bounds: The index is too large");
    }

    return elements.get(i);
  }

  public int size() {
    return elements.size();
  }
}
