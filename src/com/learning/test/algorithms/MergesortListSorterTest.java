package com.learning.test.algorithms;

import com.learning.algorithms.sorting.ListSorter;
import com.learning.algorithms.sorting.MergesortListSorter;

/**
 * Tests the sorting functionality of the Mergesort implementation.
 */
public class MergesortListSorterTest extends AbstractListSorterTest {
  @Override
  protected <T extends Comparable<? super T>> ListSorter<T> createListSorter() {
    return new MergesortListSorter<T>();
  }
}
