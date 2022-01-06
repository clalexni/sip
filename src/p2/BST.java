package p2;
/*
insert
remove
findMin
findMax
contains
makeEmpty
isEmpty
printTree
*/

import javax.xml.transform.Source;

public class BST<T extends Comparable <? super T>>{

  private Node<T> root;  

  private static class Node <T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
      this.data = data;
    }

    public Node(T data, Node<T> left, Node<T> right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public BST() {
    root = null;
  }

  public void insert(T x) {
    root = insert(x, root);
  }
  
  private Node<T> insert(T x, Node<T> node) {
    if (node == null) { 
      return new Node<>(x);
    }
    int compareResult = x.compareTo(node.data);
    if (compareResult > 0) { // x > node.data
      node.right = insert(x, node.right);
    } else if (compareResult < 0) { // x < node.data
      node.left = insert(x, node.left);
    } else {  
    }
    return node;
  }

  public void remove(T x) {
  }

  public T findMin() {
    return null;
  }

  public T findMax() {
    return null;
  }

  public boolean contains(T x) {
    return false;
  }

  public void makeEmpty() {
    root = null;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public void printTree() {
    if (isEmpty()) {
      System.out.println("Empty Tree");
    } else {
      printTree(this.root);
    }
  }

  // print tree in sorted order, which is inorder traversal
  private void printTree(Node<T> node) {
    if (node != null) {
      printTree(node.left);
      System.out.println(node.data);
      printTree(node.right);
    }
  }

  public static void main(String[] args) {
    BST<Integer> bst = new BST<>();
    bst.insert(2);
    bst.insert(1);
    bst.insert(3);
    bst.printTree();
  }
}