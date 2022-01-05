package ex;

public class PrintTree {
  private static class Node <T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data, Node<T> left, Node<T> right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static <T> void inorder(Node<T> root) {
    if (root == null) {
      return;
    } else {
      inorder(root.left);
      System.out.println(root.data);
      inorder(root.right);
    }
  }

  public static <T> void preorder(Node<T> root) {
    if (root != null) {
      System.out.println(root.data);
      preorder(root.left);
      preorder(root.right);
    }
  }

  public static <T> void postorder(Node<T> root) {
    if (root != null) {
      postorder(root.left);
      postorder(root.right);
      System.out.println(root.data);
    }
  }
  public static void main(String[] args) {
    Node<String> d = new Node<>("D", null, null);
    Node<String> e = new Node<>("E", null, null);
    Node<String> f = new Node<>("F", null, null);
    Node<String> g = new Node<>("G", null, null);

    Node<String> b = new Node<>("B", d, e);
    Node<String> c = new Node<>("C", f, g);

    Node<String> a = new Node<>("A", b, c);

    System.out.println("Preorder: ");
    preorder(a);
    System.out.println("Postorder: ");
    postorder(a);
    System.out.println("Inorder");
    inorder(a);
  }
}
