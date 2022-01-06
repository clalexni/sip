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
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    return findMin(this.root).data;
  }

  private Node<T> findMin(Node<T> node) {
    if (node != null) {
      while (node.left != null) {
        node = node.left;
      }
    }
    return node;
  }

  public T findMax() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    return findMax(this.root).data;
  }

  private Node<T> findMax(Node<T> node) {
    if (node == null) {
      return null;
    } else if (node.right == null) {
      return node;
    } else {
      return findMax(node.right);
    }
  }

  public boolean contains(T x) {
    return contains(x, this.root);
  }

  private boolean contains(T x, Node<T> node) {
    if (node == null) {
      return false;
    }
    int compareResult = x.compareTo(node.data);
    if (compareResult < 0) { // x < node.data
      return contains(x, node.left);
    } else if (compareResult > 0) {
      return contains(x, node.right);
    } else {
      return true;
    }
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

    System.out.println(bst.findMin());
    System.out.println(bst.findMax());

    System.out.println(bst.contains(-1));
    System.out.println(bst.contains(1));
  }
}