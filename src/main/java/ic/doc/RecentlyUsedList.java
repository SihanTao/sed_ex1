package ic.doc;

import java.util.ArrayList;
import java.util.List;

public class RecentlyUsedList {
    private final List<String> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void add(String elem) {
        list.remove(elem);
        list.add(0, elem);
    }

    public int size() {
        return list.size();
    }

    public String get(int i) {
        return list.get(i);
    }
}
