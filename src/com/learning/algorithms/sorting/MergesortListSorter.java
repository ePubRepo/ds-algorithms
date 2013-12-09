package com.learning.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Performs Bubblesort on a List.
 * @param <T> Generic type.
 */
public class MergesortListSorter <T extends Comparable<? super T>>
    implements ListSorter<T> {
  
  @Override
  public List<T> sort(List<T> list) { 
    List<T> sorted = mergeSort(list, 0, list.size() - 1);
    return sorted;
  }
  
  
  /**
   * Sort a list of elements between two indices.
   * @param list The list of items to be sorted.
   * @param startIndex The first index of the list to be sorted.
   * @param endIndex The last index of the list to be sorted.
   * @return List sorted via the merge sort algorithm.
   */
  private List<T> mergeSort(List<T> list, int startIndex, int endIndex) {
    // BASE CASE: There is only one element, which is a sorted list
    if (endIndex == startIndex) {
      List<T> result = new ArrayList<T>();
      result.add(list.get(startIndex));
      return result;
    }

    // RECURSIVE CASE: More than one element in list, so divide in half
    int middleIndex = startIndex + ((endIndex - startIndex) / 2);
    List<T> leftList = mergeSort(list, startIndex, middleIndex);
    List<T> rightList = mergeSort(list, middleIndex + 1, endIndex);
    
    // The sorted list is the merger of the left and right lists
    return merge(leftList, rightList);
  }
  
  
  /**
   * Merge two lists together in order.
   * @param leftList
   * @param rightList
   * @return
   */
  private List<T> merge(List<T> leftList, List<T> rightList) {
    List<T> mergedList = new ArrayList<T>();
    
    // As long as either list has items remaining, continue building up
    // the merged list.
    while (leftList.size() > 0 || rightList.size() > 0) {
      // Case 1: Both lists have elements remaining
      if (leftList.size() > 0 && rightList.size() > 0) {
        if (leftList.get(0).compareTo(rightList.get(0)) < 0) {
          mergedList.add(leftList.remove(0));
        } else {
          mergedList.add(rightList.remove(0));
        }
        continue;
      }
      
      // Case 2: Only the left list has elements remaining
      if (leftList.size() > 0) {
        mergedList.add(leftList.remove(0));
        continue;
      }
      
      // Case 3: Only the right list has elements remaining
      if (rightList.size() > 0) {
        mergedList.add(rightList.remove(0));
        continue;
      }
    }
    return mergedList;
  }
}
