package edu.ics211.h10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;





/**
 * BinarySearchTree binary search-tree.
 * @author Alexander Moshir
 * @param <E>
 *
 */
public class BinarySearchTree<E> implements InOrder<E>, SearchTree<E> {
  
  
  private class BinaryNode {
    E data;
    BinaryNode left;
    BinaryNode right;
    
    public BinaryNode(E item) {
      this.data = item;
      left = null;
      right = null;
    }
  }
  
  private Comparator<E> comp;
  private int size;
  private BinaryNode root;
  private boolean addReturn;
  private E deleteReturn;

  /**
   * BinarySearchTree initializes variables.
   * @param c the comparator to use for determining the order;
   */
  public BinarySearchTree(Comparator<E> c) {
    size = 0;
    comp = c;
  }
  
  // method for inOrder found on discord
  private void inOrderTraverse(BinaryNode node, List<E> list) {
    if (node != null) {
      inOrderTraverse(node.left, list);
      list.add(node.data);
      inOrderTraverse(node.right, list);
    } 
  }

  /**
   * Returns the items in sorted order.
   * @return The items in sorted order.
   */
  public List<E> inorder() {
    ArrayList<E> list = new ArrayList<>();
    inOrderTraverse(root, list);
    return list;
  }
  
  /**
   * Inserts item into where it belongs in the tree.
   * Found in Data Structures: Abstraction and Design, Section 6.5 
   * @param item the item to add.
   * @return true if item is inserted, false if item is already in tree.
   */
  public boolean add(E item) { 
    root = add(root, item); 
    size++;
    return addReturn; 
  } 
  
  /** Recursive add method. 
    post: The data field addReturn is set true if the item is added to the tree, 
    false if the item is already in the tree. 
    @param localRoot The local root of the subtree 
    @param item The object to be inserted 
    @return The new local root that now contains the  
            inserted item 
  */ 
  private BinaryNode add(BinaryNode localRoot, E item) { 
    if (localRoot == null) { 
      // item is not in the tree — insert it. 
      addReturn = true; 
      return new BinaryNode(item); 
    } else if (comp.compare(item, localRoot.data) == 0) { 
      // item is equal to localRoot.data 
      addReturn = false; 
      return localRoot; 
    } else if (comp.compare(item, localRoot.data) < 0) { 
      // item is less than localRoot.data 
      localRoot.left = add(localRoot.left, item); 
      return localRoot; 
    } else { 
      // item is greater than localRoot.data 
      localRoot.right = add(localRoot.right, item); 
      return localRoot; 
    } 
  }


  /**
   * Returns true if the item is in this SearchTree.
   *
   * @param item the item to find.
   * @return true if item is in the tree, false otherwise.
   */
  public boolean contains(E item) {   
    if (find(item) == null) {
      return false;
    }
      
    return true;
  }


  /**
   * Returns a reference to the target if it is in this SearchTree or null if it is not.
   * Found in Data Structures: Abstraction and Design, Section 6.5 
   * @param target the item to find.
   * @return a reference to the target if found, null if target isn't in the tree.
   */
  public E find(E target) {
    return find(root, target);
  }
  
  /** Recursive find method. 
  @param localRoot The local subtree's root 
  @param target The object being sought 
  @return The object, if found, otherwise null 
  */ 
  private E find(BinaryNode localRoot, E target) { 
    if (localRoot == null) {
      return null; 
    }
      
    // Compare the target with the data field at the root. 
    int compResult = comp.compare(target, localRoot.data); 
    if (compResult == 0) {
      return localRoot.data; 
    } else if (compResult < 0) {
      return find(localRoot.left, target); 
    } else {
      return find(localRoot.right, target); 
    }
  }


  /**
   * Removes target from the tree.
   *
   * @param target the item to remove.
   * @return a reference to the target if found, null if target isn't in the tree.
   */
  public E delete(E target) {
    size--;
    root = delete(root, target); 
    return deleteReturn;
  }
  
  /** Recursive delete method. 
  post: The item is not in the tree; 
        deleteReturn is equal to the deleted item 
        as it was stored in the tree or null 
        if the item was not found. 
  @param localRoot The root of the current subtree 
  @param item The item to be deleted 
  @return The modified local root that does not contain 
          the item 
  */ 
  private BinaryNode delete(BinaryNode localRoot, E item) { 
    if (localRoot == null) { 
      // item is not in the tree. 
      deleteReturn = null; 
      return localRoot; 
    } 
  
    // Search for item to delete. 
    int compResult = comp.compare(item, localRoot.data); 
    if (compResult < 0) { 
      // item is smaller than localRoot.data. 
      localRoot.left = delete(localRoot.left, item); 
      return localRoot; 
    } else if (compResult > 0) { 
      // item is larger than localRoot.data. 
      localRoot.right = delete(localRoot.right, item); 
      return localRoot; 
    } else {  
      // item is at local root. 
      deleteReturn = localRoot.data; 
      if (localRoot.left == null) { 
        // If there is no left child, return right child 
        // which can also be null. 
        return localRoot.right; 
      } else if (localRoot.right == null) { 
        // If there is no right child, return left child. 
        return localRoot.left; 
      } else { 
        // Node being deleted has 2 children, replace the data 
        // with inorder predecessor.  
        if (localRoot.left.right == null) { 
          // The left child has no right child. 
          // Replace the data with the data in the 
          // left child. 
          localRoot.data = localRoot.left.data; 
          // Replace the left child with its left child. 
          localRoot.left = localRoot.left.left; 
          return localRoot; 
        } else { 
          // Search for the inorder predecessor (ip) and 
          // replace deleted node's data with ip. 
          localRoot.data = findLargestChild(localRoot.left); 
          return localRoot; 
        } 
      } 
    } 
  }
  
  /** Find the node that is the 
  inorder predecessor and replace it  
  with its left child (if any). 
  post: The inorder predecessor is removed from the tree. 
  @param parent The parent of possible inorder  
                predecessor (ip) 
  @return The data in the ip 
  */ 
  public E findLargestChild(BinaryNode parent) { 
    // If the right child has no right child, it is 
    // the inorder predecessor. 
    if (parent.right.right == null) { 
      E returnValue = parent.right.data; 
      parent.right = parent.right.left; 
      return returnValue; 
    } else { 
      return findLargestChild(parent.right); 
    } 
  }

  /**
   * Removes target from the tree.
   *
   * @param item the item to remove.
   * @return true if target was in the tree, false otherwise.
   */
  public boolean remove(E item) {
    if (delete(item) == null) {
      return false;
    }
          
    return true;
  }

  /**
   * Returns the number of items in this search tree.
   * @return the number of items in this search tree.
   */
  public int size() {
    return size;
  }
}
