// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

package project2;

import java.util.ArrayDeque;
import java.util.Queue;

public class BST<T extends Comparable<? super T>> {

  private Node<T> root;
  private static final int ALLOWED_IMBALANCE = 1;

  private static class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
      this.data = data;
    }

    // public Node(T data, Node<T> left, Node<T> right) {
    // this.data = data;
    // this.left = left;
    // this.right = right;
    // }
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
    this.root = remove(x, this.root);
  }

  private Node<T> remove(T x, Node<T> node) {
    if (node == null) {
      return null;
    }
    int compareResult = x.compareTo(node.data);
    if (compareResult < 0) { // x < node.data
      node.left = remove(x, node.left);
    } else if (compareResult > 0) {
      node.right = remove(x, node.right);
    } else if (node.left != null && node.right != null) {
      node.data = findMin(node.right).data;
      node.right = remove(node.data, node.right);
    } else { // one or no child
      node = (node.left == null) ? node.right : node.left;
    }
    return node;
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
  
  // not used
  private int height(Node<T> t) {
    if (t == null)
      return -1;
    else
      return 1 + Math.max(height(t.left), height(t.right));
  }

  /* P2 starts here */
  public int size() {
    return size(this.root);
  }

  private int size(Node<T> node) {
    if (node == null) {
      return 0;
    } else {
      return 1 + size(node.left) + size(node.right);
    }
  }

  public int numLeaves() {
    return numLeaves(this.root);
  }

  private int numLeaves(Node<T> node) {
    if (node == null) {
      return 0;
    }
    if (node.left == null && node.right == null) {
      return 1;
    } else {
      return numLeaves(node.left) + numLeaves(node.right);
    }
  }

  public int numLeftChildren() {
    return numLeftChildren(this.root);
  }

  private int numLeftChildren(Node<T> node) {
    if (node == null) {
      return 0;
    } else {
      int count = (node.left == null) ? 0 : 1;
      return count + numLeftChildren(node.left) + numLeftChildren(node.right);
    }
  }

  public boolean isFull() {
    return isFull(this.root);
  }

  private boolean isFull(Node<T> node) {
    if (node == null) {
      return true;
    } else if (node.left == null && node.right == null) {
      return true;
    } else if (node.left == null || node.right == null) {
      return false;
    } else {
      return isFull(node.left) && isFull(node.right);
    }
  }

  public int nodeDepth(T x) {
    return nodeDepth(x, this.root);
  }

  private int nodeDepth(T x, Node<T> node) {
    if (node == null) {
      return -1;
    }
    int compareResult = x.compareTo(node.data);
    if (compareResult > 0) { // x > node.data
      return 1 + nodeDepth(x, node.right);
    } else if (compareResult < 0) {
      return 1 + nodeDepth(x, node.left);
    } else {
      return 0;
    }
  }

  public void printByLevels() {
    if (isEmpty())  {
      return;
    }
    Queue<Node<T>> queue = new ArrayDeque<>();
    queue.offer(this.root);
    while (queue.peek() != null) {
      Node<T> dequeued = queue.poll();
      if (dequeued.left != null) {
        queue.offer(dequeued.left);
      }
      if (dequeued.right != null) {
        queue.offer(dequeued.right);
      }
      System.out.println(dequeued.data);
    }

  }

  public static void main(String[] args) {
    BST<Integer> bst = new BST<>();

    bst.insert(2);
    bst.insert(1);
    bst.insert(3);
    System.out.println("inserted 2-1-3 print tree: ");
    bst.printTree();

    System.out.println("find min: " + bst.findMin());
    System.out.println("find max: " + bst.findMax());

    System.out.println(bst.contains(-1));
    System.out.println(bst.contains(1));

    bst.remove(2);
    // bst.printTree();
    bst.insert(4);
    // bst.insert(0);

    System.out.println("tree size: " + bst.size());
    System.out.println("leaves count: " + bst.numLeaves());
    System.out.println("left children count: " + bst.numLeftChildren());
    System.out.println("is full: " + bst.isFull());
    bst.insert(0);
    System.out.println("is full: " + bst.isFull());
    System.out.println("depth: " + bst.nodeDepth(4));
    System.out.println("depth: " + bst.nodeDepth(0));
    System.out.println("depth: " + bst.nodeDepth(3));
    System.out.println("depth: " + bst.nodeDepth(1));
    System.out.println("depth: " + bst.nodeDepth(2));
    System.out.println("print by levels: ");
    bst.insert(-1);
    bst.printByLevels();
  }
}
