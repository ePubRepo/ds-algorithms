package com.learning.test.datastructures;

import com.learning.datastructures.BinarySearchTreeNode;

import junit.framework.TestCase;

/**
 * Test the binary search tree node.
 */
public class BinarySearchTreeNodeTest extends TestCase {
  BinarySearchTreeNode<String> nodeL = null;
  BinarySearchTreeNode<String> nodeG = null;
  BinarySearchTreeNode<String> nodeA = null;
  BinarySearchTreeNode<String> nodeE = null;
  BinarySearchTreeNode<String> nodeI = null;
  BinarySearchTreeNode<String> nodeK = null;
  BinarySearchTreeNode<String> nodeQ = null;
  BinarySearchTreeNode<String> nodeO = null;
  BinarySearchTreeNode<String> nodeT = null;
  BinarySearchTreeNode<String> nodeW = null;
  
  protected void setUp() {
    nodeL = new BinarySearchTreeNode<String>("L");
    nodeG = new BinarySearchTreeNode<String>("G");
    nodeA = new BinarySearchTreeNode<String>("A");
    nodeE = new BinarySearchTreeNode<String>("E");
    nodeI = new BinarySearchTreeNode<String>("I");
    nodeK = new BinarySearchTreeNode<String>("K");
    nodeQ = new BinarySearchTreeNode<String>("Q");
    nodeO = new BinarySearchTreeNode<String>("O");
    nodeT = new BinarySearchTreeNode<String>("T");
    nodeW = new BinarySearchTreeNode<String>("W");

    // Set the root node.
    nodeL.setLeftChild(nodeG);
    
    // Set the left half of the tree.
    nodeG.setParent(nodeL);
    nodeG.setLeftChild(nodeA);
    nodeA.setParent(nodeG);
    nodeA.setRightChild(nodeE);
    nodeE.setParent(nodeA);
    nodeG.setRightChild(nodeI);
    nodeI.setParent(nodeG);
    nodeI.setRightChild(nodeK);
    nodeK.setParent(nodeI);
    
    // Set the right half of the tree.
    nodeQ.setParent(nodeL);
    nodeL.setRightChild(nodeQ);
    nodeO.setParent(nodeQ);
    nodeQ.setLeftChild(nodeO);
    nodeQ.setRightChild(nodeT);
    nodeT.setParent(nodeQ);
    nodeT.setRightChild(nodeW);
    nodeW.setParent(nodeT);
  }
  
  protected void tearDown() {
    nodeL = null;
    nodeG = null;
    nodeA = null;
    nodeE = null;
    nodeI = null;
    nodeK = null;
    nodeQ = null;
    nodeO = null;
    nodeT = null;
    nodeW = null;
  }
  
  public void testCanGetValueFromBinarySearchTreeNode() {
    assertEquals("L", nodeL.getValue());
    assertEquals("G", nodeG.getValue());
    assertEquals("A", nodeA.getValue());
  }

  public void testGetMaximumNode() {
    assertEquals(nodeW, nodeL.getMaximum());
    assertEquals(nodeK, nodeG.getMaximum());
    assertEquals(nodeE, nodeE.getMaximum());
    assertEquals(nodeW, nodeQ.getMaximum());
    assertEquals(nodeO, nodeO.getMaximum());
    assertEquals(nodeW, nodeW.getMaximum());
  }

  public void testGetMinimumOfBinarySearchTree() {
    assertEquals(nodeA, nodeL.getMinimum());
    assertEquals(nodeA, nodeG.getMinimum());
    assertEquals(nodeE, nodeE.getMinimum());
    assertEquals(nodeO, nodeQ.getMinimum());
    assertEquals(nodeO, nodeO.getMinimum());
    assertEquals(nodeW, nodeW.getMinimum());
  }
  
  public void testGetPredecessorNodeInBinarySearchTree() {
    assertEquals(nodeK, nodeL.getPredecessor());
    assertEquals(nodeO, nodeQ.getPredecessor());
    assertEquals(nodeE, nodeG.getPredecessor());
    assertEquals(nodeI, nodeK.getPredecessor());

    assertEquals(nodeQ, nodeT.getPredecessor());
    assertEquals(nodeL, nodeO.getPredecessor());
    assertEquals(nodeA, nodeE.getPredecessor());
    assertEquals(null, nodeA.getPredecessor());
  }

  public void testGetSuccessorNodeInBinarySearchTree() {
    assertEquals(nodeO, nodeL.getSuccessor());
    assertEquals(nodeT, nodeQ.getSuccessor());
    assertEquals(nodeI, nodeG.getSuccessor());
    assertEquals(nodeL, nodeK.getSuccessor());

    assertEquals(nodeW, nodeT.getSuccessor());
    assertEquals(nodeQ, nodeO.getSuccessor());
    assertEquals(nodeG, nodeE.getSuccessor());
    assertEquals(null, nodeW.getSuccessor());
  }
}
