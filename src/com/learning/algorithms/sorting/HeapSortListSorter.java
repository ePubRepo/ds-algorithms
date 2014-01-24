package com.learning.algorithms.sorting;

import java.util.List;

/**
 * Performs heap sort on a list.
 * @param <T> Generic type.
 */
public class HeapSortListSorter <T extends Comparable<? super T>>
      implements ListSorter<T> {
  private ListSorterHelper<T> listSorterHelper;

  public HeapSortListSorter() {
    listSorterHelper = new ListSorterHelper<T>();
  }

  @Override
  public List<T> sort(List<T> list) {
    // STEP 1: Max-Heapify the Heap
    // Put the input list in max-heap order.
    putIntoMaxHeapOrder(list);

    // STEP 2: Sort the Heap
    // Swap the first and last element of the heap, decrement the boundary of
    // the heap. Then shift down the to put the heap back into max-heap order.
    int endHeapIndex = list.size() - 1;
    while (endHeapIndex > 0) {
      listSorterHelper.swap(list, 0, endHeapIndex);
      endHeapIndex--;
      shiftDown(list, 0, endHeapIndex);
    }
    return list;
  }
  
  /**
   * Place a list into max-heap order.
   * @param list The list to be max-heapified.
   */
  private void putIntoMaxHeapOrder(List<T> list) {
    // The index of the element to begin shifting up from.
    int startShiftIndex = 1;

    // Begin heapifying the list by shifting up to the root, by starting
    // from the left child of the root (if it exists). After heapifying
    // from element 1, move to the next element if it exists and heapify from
    // there.
    while (startShiftIndex < list.size()) {
      shiftUp(list, startShiftIndex);
      startShiftIndex++;
    }
  }
  
  /**
   * Put a heap or subsection of it into max-heap order by shifting down.
   * @param list The list to be placed in max-heap order.
   * @param startIndex The index of the list to start shifting down from.
   * @param endIndex The index of the list to stop shifting down at.
   */
  private void shiftDown(List<T> list, int startIndex, int endIndex) {
    int currentRootIndex = startIndex;
    int currentChildIndex = 0;
    int toSwapIndex = 0;
    final int noSwap = 0;
    
    // As long as there is a child element that is less than the end index,
    // continue shifting down.
    while ((currentRootIndex * 2) + 1 <= endIndex) {
      toSwapIndex = noSwap;
      
      // Calculate the index of the left child to see whether the current
      // parent index should swap with one of its children.
      currentChildIndex = (currentRootIndex * 2) + 1;
      
      // See if the parent is less than the left child.
      if (list.get(currentRootIndex).compareTo(list.get(currentChildIndex)) < 0) {
        toSwapIndex = currentChildIndex;
      }
      
      // Check whether a right child exists and if its bigger than what
      // we previously planned to swap with, the left child, which has
      // already been established to be bigger than the parent.
      if (currentChildIndex + 1 <= endIndex &&
          list.get(toSwapIndex).compareTo(list.get(currentChildIndex + 1)) < 0) {
        toSwapIndex = currentChildIndex + 1;
      }
      
      // Check whether a swap should be performed and if so, perform it.
      // If no swap should be performed, return because we're done.
      if (toSwapIndex != noSwap) {
        listSorterHelper.swap(list, toSwapIndex, currentRootIndex);
        currentRootIndex = toSwapIndex;
      } else {
        return;
      }
    }
  }

  /**
   * Put a list in max-heap order by shifting up.
   * @param list The list to place in max-heap order by shifting up.
   * @param startShiftIndex The index of the list to start shifting up from.
   */
  private void shiftUp(List<T> list, int startShiftIndex) {
    // The child index to start shifting up from.
    int childIndex = startShiftIndex;
    
    int parentIndex;
    
    // As long as the child index is not at the top of the heap, keep
    // working up the tree.
    while (childIndex > 0) {
      parentIndex = (childIndex - 1) / 2;
      
      // If the parent index is less than the child, swap and set the new
      // child index to be the parent index (i.e., the current parent index
      // becomes the new child index).
      if (list.get(parentIndex).compareTo(list.get(childIndex)) < 0) {
        listSorterHelper.swap(list, parentIndex, childIndex);
        childIndex = parentIndex;
      } else {
        return;
      }
    }
  }
}
