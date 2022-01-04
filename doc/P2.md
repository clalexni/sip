# Add the followings to BST API

## size
- returns an int of the number of nodes in the tree. Use recursion.

## numLeaves
- Returns the number of leaf nodes. Use recursion.

## numLeftChildren
- Returns the number of nodes that have a left child. Use recursion.

## isFull
- Returns true if every node has either two children or no children.
(Assume an empty tree is full.) Use recursion.

## nodeDepth
- Receives a node value and returns the depth of this node, or -1 if not found.
Use recursion.

## printByLevels
- Print the root, then its children, then their children, etc.
This can be done using a queue. Enqueue the root, then while the queue
is not empty, dequeue and print, and enqueue its children.

## main
- Change the main method to demonstrate your new methods.