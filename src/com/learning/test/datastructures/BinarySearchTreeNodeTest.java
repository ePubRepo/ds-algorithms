package com.learning.test.datastructures;

import com.learning.datastructures.BinarySearchTreeNode;

import junit.framework.TestCase;

/**
 * Test the binary search tree node.
 */
public class BinarySearchTreeNodeTest extends TestCase {
  BinarySearchTreeNode<String> sL = null;
  BinarySearchTreeNode<String> sG = null;
  BinarySearchTreeNode<String> sA = null;
  BinarySearchTreeNode<String> sE = null;
  BinarySearchTreeNode<String> sI = null;
  BinarySearchTreeNode<String> sK = null;
  BinarySearchTreeNode<String> sQ = null;
  BinarySearchTreeNode<String> sO = null;
  BinarySearchTreeNode<String> sT = null;
  BinarySearchTreeNode<String> sW = null;
  
  protected void setUp() {
    sL = new BinarySearchTreeNode<String>("L");
    sG = new BinarySearchTreeNode<String>("G");
    sA = new BinarySearchTreeNode<String>("A");
    sE = new BinarySearchTreeNode<String>("E");
    sI = new BinarySearchTreeNode<String>("I");
    sK = new BinarySearchTreeNode<String>("K");
    sQ = new BinarySearchTreeNode<String>("Q");
    sO = new BinarySearchTreeNode<String>("O");
    sT = new BinarySearchTreeNode<String>("T");
    sW = new BinarySearchTreeNode<String>("W");

    // Set the root node.
    sL.setLeftChild(sG);
    
    // Set the left half of the tree.
    sG.setParent(sL);
    sG.setLeftChild(sA);
    sA.setParent(sG);
    sA.setRightChild(sE);
    sE.setParent(sA);
    sG.setRightChild(sI);
    sI.setParent(sG);
    sI.setRightChild(sK);
    sK.setParent(sI);
    
    // Set the right half of the tree.
    sQ.setParent(sL);
    sL.setRightChild(sQ);
    sO.setParent(sQ);
    sQ.setLeftChild(sO);
    sQ.setRightChild(sT);
    sT.setParent(sQ);
    sT.setRightChild(sW);
    sW.setParent(sT);
  }
  
  protected void tearDown() {
    sL = null;
    sG = null;
    sA = null;
    sE = null;
    sI = null;
    sK = null;
    sQ = null;
    sO = null;
    sT = null;
    sW = null;
  }
  
  public void testGetValue() {
    assertEquals("L", sL.getValue());
    assertEquals("G", sG.getValue());
    assertEquals("A", sA.getValue());
  }

  public void testMaximum() {
    assertEquals(sW, sL.maximum());
    assertEquals(sK, sG.maximum());
    assertEquals(sE, sE.maximum());
    assertEquals(sW, sQ.maximum());
    assertEquals(sO, sO.maximum());
    assertEquals(sW, sW.maximum());
  }
  
  public void testMinimum() {
    assertEquals(sA, sL.minimum());
    assertEquals(sA, sG.minimum());
    assertEquals(sE, sE.minimum());
    assertEquals(sO, sQ.minimum());
    assertEquals(sO, sO.minimum());
    assertEquals(sW, sW.minimum());
  }
  
  public void testPredecessor() {
    assertEquals(sK, sL.predecessor());
    assertEquals(sO, sQ.predecessor());
    assertEquals(sE, sG.predecessor());
    assertEquals(sI, sK.predecessor());

    assertEquals(sQ, sT.predecessor());
    assertEquals(sL, sO.predecessor());
    assertEquals(sA, sE.predecessor());
    assertEquals(null, sA.predecessor());
  }

  public void testSuccessor() {
    assertEquals(sO, sL.successor());
    assertEquals(sT, sQ.successor());
    assertEquals(sI, sG.successor());
    assertEquals(sL, sK.successor());

    assertEquals(sW, sT.successor());
    assertEquals(sQ, sO.successor());
    assertEquals(sG, sE.successor());
    assertEquals(null, sW.successor());
  }
}
