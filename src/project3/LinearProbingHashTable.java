package project3;

public class LinearProbingHashTable <K, V>{
  private static class Entry<K, V> {
    public K key;
    public V value;
    public boolean isActive;

    public Entry(K key, V value, boolean isActive) {
      this.key = key;
      this.value = value;
      this.isActive = isActive;
    }
  }

  private Entry<K, V>[] table;
  private int occupied;
  private int size;

  public LinearProbingHashTable() {

  }

  public boolean insert(K key, V value) {
    return false;
  }

  public V find(K key) {
    return null;
  }

  public boolean delete(K key) {
    return false;
  }

  private void rehash() {
  }

  public int getHashValue(K key) {
    return 0;
  }

  public int getLocation(K key) {
    return 0;
  }

  public String toString() {
    return "";
  }

  public static void main(String[] args) {
  }
}