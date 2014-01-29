package com.learning.test.algorithms;

import com.learning.algorithms.sorting.ListSorter;
import com.learning.algorithms.sorting.ShellsortListSorter;


/**
 * Tests the sorting functionality of the shell sort implementation.
 */
public class ShellsortListSorterTest extends AbstractListSorterTest {
  @Override
  protected <T extends Comparable<? super T>> ListSorter<T> createListSorter() {
    return new ShellsortListSorter<T>();
  }
}
