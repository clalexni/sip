package ex;

public class TypeErasureEx {
  public static void main(String ...args) {
    Cell<String> c1 = new Cell<>("Hello");
    Cell<Integer> c2 = new Cell<>(1);

    System.out.println(c1.getCount());
    System.out.println(c2.getCount()); 
    // print 2 since String and Integer generic types are erased
    // during compile time
    // only one Cell type after compilation
  }
}

class Cell<T> {
  private T value;
  private static int count = 0;
  
  public Cell(T value) {
    this.value = value;
    Cell.count++;
  }
  public int getCount() {
    return Cell.count;
  }
  public T getValue() {
    return this.value;
  }
}
