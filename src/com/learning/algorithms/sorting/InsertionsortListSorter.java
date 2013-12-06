package com.learning.algorithms.sorting;

import java.util.List;

/**
 * Performs insertion sort on a list.
 * @param <T> Generic type.
 */
public class InsertionsortListSorter <T extends Comparable<? super T>>
      implements ListSorter<T> {

  private ListSorterHelper<T> helper;
  
  public InsertionsortListSorter() {
    helper = new ListSorterHelper<T>();
  }
  
  @Override
  public List<T> sort(List<T> list) {
    int innerIndex;
    for (int sortedIndex = 1; sortedIndex < list.size(); sortedIndex++) {
      for (innerIndex = sortedIndex;
          innerIndex > 0 &&
          innerIndex < list.size() && 
          list.get(innerIndex).compareTo(list.get(innerIndex - 1)) < 0;
          innerIndex--) {
        helper.swap(list, innerIndex, innerIndex - 1);
      }
    }
    return list;
  }
}
