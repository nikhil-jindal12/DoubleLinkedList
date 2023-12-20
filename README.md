# DoubleLinkedList

This class contains very basic implementation for a Double Linked List. It is broken down into two classes: `DLNode.java` & `DoubleLinkedList.java`

There is one unique method in the `DoubleLinkedList.java` class, which is the **successorSwap()** method. This method simply swaps the current node with its successor without losing any data.

**Major Concept of the Algorithm:**
1. Traverse through the double linked list, starting at the head, until the desired node is found
2. Determine which of the 4 cases the desired node falls into:
	1. There are nodes before and after, and two after the node
	2. Current node is the head and successor node is the tail
	3. Current node is the head, and there is one node in between that and the tail node
	4. The successor node is the tail
3. Swap the pointers in the correct order so that no node is lost

**Time Complexity:** The runtime for this unique method is `O(n)`, where n is the length of the double linked list. This is the time complexity because in the worst-case scenario, you will have to traverse the entire linked list to find the desired node that you want to swap. Swapping the node will happen in constant time, so it is much less time complex than finding the node itself.