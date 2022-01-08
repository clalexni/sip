// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x (unimplemented)
// boolean contains( x )  --> Return true if x is present
// boolean remove( x )    --> Return true if x was present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

package ex;

public class AvlTree<T extends Comparable<? super T>> {

  private Node<T> root;
  private static final int ALLOWED_IMBALANCE = 1;

  private static class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;
    public int height;

    public Node(T data) {
      this.data = data;
    }
  }

  public AvlTree() {
    this.root = null;
  }

  private Node<T> balance(Node<T> node) {
    if (node == null) {
      return null;
    }
    if (height(node.left) - height(node.right) > ALLOWED_IMBALANCE) { 
      if (height(node.left.left) > height(node.left.right)) {
        // LL single rotation
        node = LLSingleRotation(node);
      } else if (height(node.left.right) > height(node.left.left)) {
        // LR double rotation
      } else {
        System.out.println("how did you end up here?");
      }
    } else if (height(node.right) - height(node.left) > ALLOWED_IMBALANCE) {
      if (height(node.right.right) > height(node.right.left)) {
        // RR single rotation
      } else if (height(node.right.right) < height(node.right.left)) {
        // RL double rotation
      } else {
        System.out.println("how did you end up here 2?");
      }
    }
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    return node;
  }

  private Node<T> LLSingleRotation(Node<T> k2) {
    Node<T> k1 = k2.left;
    k2.left = k1.right;
    k1.right = k2;
    // only k1 and k2's heights changed
    k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
    k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
    return k1;
  }

  private int height(Node<T> node) {
    return (node == null)? -1: node.height;
  }

  public void insert(T x) {
    this.root = insert(x, this.root);
  }

  private Node<T> insert(T x, Node<T> node) {
    if (node == null) {
      return new Node<T>(x);
    }
    int compareResult = x.compareTo(node.data);
    if (compareResult > 0) {
      node.right = insert(x, node.right);
    } else if (compareResult < 0) {
      node.left = insert(x, node.left);
    } else {
      ;
    }
    return balance(node);
  }



  public static void main(String[] args) {
  }
}
