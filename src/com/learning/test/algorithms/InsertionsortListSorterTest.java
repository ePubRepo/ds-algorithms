package com.learning.test.algorithms;

import com.learning.algorithms.sorting.InsertionsortListSorter;
import com.learning.algorithms.sorting.ListSorter;

/**
 * Tests the sorting functionality of the insertion sort implementation.
 */
public class InsertionsortListSorterTest extends AbstractListSorterTest {
  @Override
  protected <T extends Comparable<? super T>> ListSorter<T> createListSorter() {
    return new InsertionsortListSorter<T>();
  }
}
