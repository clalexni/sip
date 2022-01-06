package p2;

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
  }

  public static void main(String[] args) {
  }
}