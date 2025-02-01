package Containers;

import Collections.List;

public interface Storage {
    String save(List list);
    List load(String id, boolean isLinked);
}
