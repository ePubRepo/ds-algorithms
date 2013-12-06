package com.learning.algorithms.sorting;

import java.util.List;

/**
 * Performs Bubblesort on a List.
 * @param <T> Generic type.
 */
public class BubblesortListSorter <T extends Comparable<? super T>>
    implements ListSorter<T> {
  
  private ListSorterHelper<T> helper;
  
  public BubblesortListSorter() {
    helper = new ListSorterHelper<T>();
  }
  
  @Override
  public List<T> sort(List<T> list) {
    for (int outer = 1; outer < list.size(); outer++) {
      for (int left = 0; left < (list.size() - outer); left++) {
        int right = left + 1;
        if (list.get(left).compareTo(list.get(right)) > 0) {
          helper.swap(list, left, right);
        }
      }
    }
    return list;
  }
}
