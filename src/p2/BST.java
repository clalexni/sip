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


public class BST<T extends Comparable <? super T>>{

  private Node<T> root;  

  private static class Node <T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
      this.data = data;
    }

    // public Node(T data, Node<T> left, Node<T> right) {
    //   this.data = data;
    //   this.left = left;
    //   this.right = right;
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
      node = (node.left == null)? node.right : node.left;
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

  /* P2 starts here*/
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
  public int numLeftChildren()  {
    return numLeftChildren(this.root);
  }

  private int numLeftChildren(Node<T> node) {
    if (node == null) {
      return 0;
    } else {
      int count = (node.left == null)? 0: 1;
      return count + numLeftChildren(node.left) + numLeftChildren(node.right);
    }
  }

  public boolean isFull() {
    return false;
  }

  public int nodeDepth() {
    return 0;
  }

  public void printByLevels() {
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

    bst.remove(2);
    // bst.printTree();
    bst.insert(4);
    bst.insert(0);
    System.out.println("tree size: " + bst.size());
    
    System.out.println("leaves count: " + bst.numLeaves());
    
    System.out.println("left children count: " + bst.numLeftChildren());
  }
}
