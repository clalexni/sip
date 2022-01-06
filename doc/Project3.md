## Objective
- Work with hash tables by creating a hash table using linear probing.
## Description:
- Create a generic class called LinearProbingHashTable<K,V>.
- It should contain a private static class, Entry<K,V>.
- Because Java cannot create an array of a generic class, create the array for the table like this:
```java
Entry<K,V> table[]; // declare generic
table = new Entry[size]; // create as non-generic
```
- Note that this will generate a warning message when compiled.
- Perform checking of the parameters and throw exceptions where
appropriate.

## API
### ```public boolean insert(K key, V value)```
- inserts entry, rehashes if half full,
can re-use deleted entries, throws
exception if key is null, returns
true if inserted, false if duplicate.

### ```public V find(K key)```
- returns value for key, or null if not found

### ```public boolean delete(K key)```
- marks the entry deleted but leaves it there,
returns true if deleted, false if not found

### ```private void rehash( )```
- doubles the table size, hashes everything to
the new table, omitting items marked deleted

### ```public int getHashValue(K key)```
- returns the hash value for the given key. (this is the value before probing occurs)

### ```public int getLocation(K key)```
- returns the location for the given key,
or -1 if not found.
(this is the value after probing occurs)

### ```public String toString()```
- returns a formatted string of the hash table,
where k, v is the key and value at this location:
```
0 k, v
1
2 k, v deleted
...
```