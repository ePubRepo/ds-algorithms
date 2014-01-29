package com.learning.algorithms.sorting;

import java.util.List;

/**
 * Performs Quicksort on a List.
 * @param <T> Generic type.
 */
public class QuicksortListSorter <T extends Comparable<? super T>>
    implements ListSorter<T> {
  
  private ListSorterHelper<T> listSorterHelper;
  
  public QuicksortListSorter() {
    listSorterHelper = new ListSorterHelper<T>();
  }
  
  @Override
  public List<T> sort(List<T> list) {
    quickSort(list, 0, list.size() - 1);
    return list;
  }
  
  private void quickSort(List<T> list, int startIndex, int endIndex) {
    // BASE CASE: List contains one or fewer elements or is out of bounds.
    if (endIndex <= startIndex || endIndex < 0 || endIndex >= list.size()) {
      return;
    }

    // RECURSIVE CASE: The current list can still be divided into sublists.
    // Partition the lists into two lists and return the index of the element
    // that served as the pivot (i.e., the element that divided the two lists).
    int partionedIndex = partitionList(list, startIndex, endIndex);

    // With the list sorted into two halves around a pivot index,
    // sort each half individually.
    quickSort(list, startIndex, partionedIndex - 1);
    quickSort(list, partionedIndex + 1, endIndex);
  }
  
  private int partitionList(List<T> list, int leftIndex, int rightIndex) {
    // Choose the right most position of the list as the pivot. This will
    // remain fixed until the very end when it will be swapped if necessary.
    int initialPivotIndex = rightIndex;

    // As long as the left index pointer does not intersect with the right
    // index pointer, the list is not necessarily partitioned yet. So,
    // keep finding the next element on the right and the next element on the
    // left that are out of place so you can swap them.
    while (leftIndex < rightIndex) {
      //  2, 13, 20, 15, 11
      // As long as the left element is less than the pivot, move the left
      // index forward one and start again. Once you reach a place where
      // the value of the element at the left index is greater than
      // the pivot, the if statement won't evaluate true and we move on
      // to finding the first element on the right side that is out of position.
      if (list.get(leftIndex).compareTo(list.get(initialPivotIndex)) < 0) {
        leftIndex++;
        continue;
      }
      
      // Find the first value on the right that is out of place (i.e., smaller
      // than the pivot value). This is done by looping through the list
      // and decrementing the right index by one for each element on the right
      // that is in proper order (i.e., that is larger than the pivot).
      if (list.get(rightIndex).compareTo(list.get(initialPivotIndex)) >= 0) {
        rightIndex--;
        continue;
      }
      
      // Two elements, both out of position on the opposite side of the pivot
      // are swapped.
      listSorterHelper.swap (list, leftIndex, rightIndex);
      leftIndex++;
    }
    
    // Since we made the pivot index the rightmost element of the list and
    // this pivot stayed in place during the partition, we now need to
    // place this pivot element into its final place. If the pivot element
    // is smaller than the point where the right and left pointer met,
    // then we need to move up the left pointer so that when we swap
    // the pivot element with the left pointer, the order is correct (i.e.,
    // the smaller element--pivot--ends up to the left).
    if (list.get(leftIndex).compareTo(list.get(initialPivotIndex)) < 0) {
      leftIndex++;
    }
    listSorterHelper.swap(list, leftIndex, initialPivotIndex);
    
    return leftIndex;
  }
}
