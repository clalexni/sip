# LL

## Adding the following to LL API

### itemCount

- receives a value and returns a count of the number of times this item is found in the list.

### swap

- receives two index positions as parameters and swaps the two nodes
(the nodes, not just the values inside) at these positions, provided
both positions are within the current size.

### sublist

- receives two indexes and returns an ArrayList of node values from the first
index to the second index, provided the indexes are valid.

### select

- receives a variable number of indexes, and returns an ArrayList of node values
corresponding to each index given, provided the indexes are valid.

### reverse

- returns a new MyLinkedList that has the elements in reverse order.

### erase

- receives an index position and number of elements as parameters, and
removes elements beginning at the index position for the number of
elements specified, provided the index position is within the size
and together with the number of elements does not exceed the size.

### insertList

- receives a List and an index position as parameters, and copies all of the
passed list into the existing list at the position specified by the parameter,
provided the index position does not exceed the size.

### shift

- receives an integer and shifts the list this many nodes forward or backward,
for example, if passed 2, the first two nodes move to the tail, or if
passed -3, the last three nodes move to the front.
  - +2: abcde -> cdeab -3: abcde -> cdeab
