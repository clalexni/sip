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
  }



  public static void main(String[] args) {
  }
}
