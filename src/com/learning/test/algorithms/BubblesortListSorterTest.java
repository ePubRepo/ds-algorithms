package com.learning.test.algorithms;

import com.learning.algorithms.sorting.BubblesortListSorter;
import com.learning.algorithms.sorting.ListSorter;

/**
 * Tests the sorting functionality of the Bubblesort implementation.
 */
public class BubblesortListSorterTest extends AbstractListSorterTest {
  @Override
  protected <T extends Comparable<? super T>> ListSorter<T> createListSorter() {
    return new BubblesortListSorter<T>();
  }
}
