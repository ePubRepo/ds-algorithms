package com.learning.test.algorithms;

import com.learning.algorithms.sorting.ListSorter;

import junit.framework.TestCase;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Sets up tests on string and integer lists that can be shared among
 * different types of list sorting algorithms.
 */
public abstract class AbstractListSorterTest extends TestCase {
  private List<String> unsortedStringList;
  private List<String> sortedStringList;

  private List<Timestamp> unsortedTimestampList;
  private List<Timestamp> sortedTimestampList;
  
  protected void setUp() throws Exception {
    unsortedStringList = new ArrayList<String>();
    unsortedStringList.add("my string");
    unsortedStringList.add("my String");
    unsortedStringList.add("My String");
    unsortedStringList.add("A");
    unsortedStringList.add("A123");
    unsortedStringList.add("123");

    sortedStringList = new ArrayList<String>();
    sortedStringList.add("123");
    sortedStringList.add("A");
    sortedStringList.add("A123");
    sortedStringList.add("My String");
    sortedStringList.add("my String");
    sortedStringList.add("my string");

    unsortedTimestampList = new ArrayList<Timestamp>();
    unsortedTimestampList.add(new Timestamp(1386037882000L));
    unsortedTimestampList.add(new Timestamp(1386037876000L));
    unsortedTimestampList.add(new Timestamp(1386037886000L));
    unsortedTimestampList.add(new Timestamp(1386037881000L));

    sortedTimestampList = new ArrayList<Timestamp>();
    sortedTimestampList.add(new Timestamp(1386037876000L));
    sortedTimestampList.add(new Timestamp(1386037881000L));
    sortedTimestampList.add(new Timestamp(1386037882000L));
    sortedTimestampList.add(new Timestamp(1386037886000L));
  }
  
  protected void tearDown() throws Exception {
    unsortedStringList = null;
    sortedStringList = null;

    unsortedTimestampList = null;
    sortedTimestampList = null;
  }

  protected abstract <T extends Comparable<? super T>> ListSorter<T>
    createListSorter();

  public void testSortSimpleStrings() {
    ListSorter<String> sorter = createListSorter();
    List<String> result = sorter.sort(unsortedStringList);
    
    assertEquals(unsortedStringList.size(), result.size());

    Iterator<String> actual = result.iterator();
    Iterator<String> expected = sortedStringList.iterator();

    while (actual.hasNext() && expected.hasNext()) {
      assertEquals(expected.next(), actual.next());
    }
  }

  public void testSortSimpleLongs() {
    ListSorter<Timestamp> sorter = createListSorter();
    List<Timestamp> result = sorter.sort(unsortedTimestampList);
    
    assertEquals(unsortedTimestampList.size(), result.size());

    Iterator<Timestamp> actual = result.iterator();
    Iterator<Timestamp> expected = sortedTimestampList.iterator();

    while (actual.hasNext() && expected.hasNext()) {
      assertEquals(expected.next(), actual.next());
    }
  }
}
