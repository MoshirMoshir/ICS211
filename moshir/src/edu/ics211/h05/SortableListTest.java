package edu.ics211.h05;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import edu.ics211.h04.StringComparator;
import org.junit.jupiter.api.Test;


class SortableListTest {

  // Tests to see if list exists
  @Test
  void testSortableList() {
    SortableList<String> list = new SortableList<>();
    assertEquals(0, list.size());
  }


  // Tests that list is sortable
  @Test
  void testSortableListInt() {
    SortableList<String> list = new SortableList<>();
    list.add("foo");
    list.add("bar");
    list.add("baz");
    list.insertionSort(new StringComparator());
    assertEquals("bar", list.get(0));
    assertEquals("baz", list.get(1));
    assertEquals("foo", list.get(2));
  }


  // Tests that the get method works as intended
  @Test
  void testGet() {
    SortableList<String> list = new SortableList<>();
    list.add("foo");
    list.add("bar");
    list.add("baz");
    assertEquals("foo", list.get(0));
    assertEquals("baz", list.get(list.size() - 1));
    try {
      list.get(-1);
      fail("Able to grab index of -1");
    } catch (IndexOutOfBoundsException ioe) {
      // this is what we want
    }
    try {
      list.get(list.size());
      fail("Able to grab index of (list.size())");
    } catch (IndexOutOfBoundsException ioe) {
      // this is what we want
    }
  }


  // Tests that the set method works as intended
  @Test
  void testSet() {
    SortableList<String> list = new SortableList<>();
    list.add("foo");
    list.add("bar");
    list.set(0, "baz");
    list.set(1, "foo");
    list.set(1, "bar");
    assertEquals("baz", list.get(0));
    assertEquals("bar", list.get(1));
  }


  // Tests that it is able to get the indexOf an object
  @Test
  void testIndexOf() {
    SortableList<String> list = new SortableList<>();
    list.add("foo");
    list.add("bar");
    list.add("baz");
    assertEquals(0, list.indexOf("foo"));
    assertEquals(1, list.indexOf("bar"));
    assertEquals(2, list.indexOf("baz"));
  }


  // Tests to see if it is able to get the size of the list
  @Test
  void testSize() {
    SortableList<String> list = new SortableList<>();
    list.add("foo");
    list.add("bar");
    list.add("baz");
    assertEquals(3, list.size());
  }


  // Tests that you can add to the end of the list
  @Test
  void testAddE() {
    SortableList<String> list = new SortableList<>();
    list.add("foo");
    assertEquals("foo", list.get(0));
    list.add("bar");
    assertEquals("bar", list.get(1));
    list.add("baz");
    assertEquals("baz", list.get(list.size() - 1));
  }


  // Tests that you can add at index of the list`
  @Test
  void testAddIntE() {
    SortableList<String> list = new SortableList<>();
    list.add("foo");
    list.add("bar");
    list.add(0, "baz");
    assertEquals("baz", list.get(0));
    assertEquals("foo", list.get(1));
    assertEquals("bar", list.get(2));
  }


  // Tests that you can remove an object from the list
  @Test
  void testRemove() {
    SortableList<String> list = new SortableList<>();
    list.add("foo");
    list.add("bar");
    list.add("baz");
    list.remove(1);
    assertEquals("foo", list.get(0));
    assertEquals("baz", list.get(1));
  }


  // Tests to see if InsertionSort sorts the list
  @Test
  void testInsertionSort() {
    SortableList<String> list = new SortableList<>();
    list.add("aaaaa");
    list.add("aaa");
    list.add("aa");
    list.add("aaaa");
    list.add("a");
    StringComparator comp = new StringComparator();
    list.insertionSort(comp);
    assertEquals("a", list.get(0));
    assertEquals("aa", list.get(1));
    assertEquals("aaa", list.get(2));
    assertEquals("aaaa", list.get(3));
    assertEquals("aaaaa", list.get(4));
  }


  // Tests to see if BubbleSort sorts the list
  @Test
  void testBubbleSort() {
    SortableList<String> list = new SortableList<>();
    list.add("aaaaaa");
    list.add("aaaaaaa");
    list.add("aaaaaaaa");
    list.add("aaaaaaaaa");
    list.add("aaaaaaaaaa");
    list.add("aaaaa");
    list.add("aaa");
    list.add("aa");
    list.add("aaaa");
    list.add("a");
    StringComparator comp = new StringComparator();
    list.bubbleSort(comp);
    assertEquals("a", list.get(0));
    assertEquals("aa", list.get(1));
    assertEquals("aaa", list.get(2));
    assertEquals("aaaa", list.get(3));
    assertEquals("aaaaa", list.get(4));
  }


  // Tests to see if SelectionSort sorts the list
  @Test
  void testSelectionSort() {
    SortableList<String> list = new SortableList<>();
    list.add("aaaaa");
    list.add("aaa");
    list.add("aa");
    list.add("aaaa");
    list.add("a");
    StringComparator comp = new StringComparator();
    list.selectionSort(comp);
    assertEquals("a", list.get(0));
    assertEquals("aa", list.get(1));
    assertEquals("aaa", list.get(2));
    assertEquals("aaaa", list.get(3));
    assertEquals("aaaaa", list.get(4));
  }
  
  
  // Tests if it gets the right number of swaps
  @Test
  void testGetNumberOfSwaps() {
    SortableList<String> list = new SortableList<>();
    list.add("aaaaa");
    list.add("aaa");
    list.add("aa");
    list.add("aaaa");
    list.add("a");
    StringComparator comp = new StringComparator();
    list.selectionSort(comp);
    assertEquals(4, list.getNumberOfSwaps());
  }


  // Tests if it gets the right number of comparisons
  @Test
  void testGetNumberOfComparisons() {
    SortableList<String> list = new SortableList<>();
    list.add("aaaaa");
    list.add("aaa");
    list.add("aa");
    list.add("aaaa");
    list.add("a");
    StringComparator comp = new StringComparator();
    list.selectionSort(comp);
    assertEquals(10, list.getNumberOfComparisons());
  }


  // Tests to see if it is getting the sort time properly 
  @Test
  void testGetSortTime() {
    SortableList<String> list = new SortableList<>();
    list.add("aaaaa");
    list.add("aaa");
    list.add("aa");
    list.add("aaaa");
    list.add("a");
    StringComparator comp = new StringComparator();
    list.selectionSort(comp);
    final double small = list.getSortTime();
    list.add("aaaaa");
    list.add("aaa");
    list.add("aa");
    list.add("aaaa");
    list.add("a");
    list.selectionSort(comp);
    final double large = list.getSortTime();
    assertTrue(small < large);
  }

}
