# Aho-Corsick Algorithm
This is a string-searching algorithm invented by Alfred V. Aho and Margaret J. Corasick. It is a kind of dictionary-matching algorithm 
that locates elements of a finite set of strings (the "dictionary") within an input text. It matches all strings simultaneously.

## Example
### Input:
      text="ababaababcaac"
      list=["a", "ab", "aab", "aac", "bc"]

### Output
      a 	 occurs at 1
      a 	 occurs at 3
      a 	 occurs at 5
      a 	 occurs at 6
      a 	 occurs at 8
      a 	 occurs at 11
      a 	 occurs at 12
      ab 	 occurs at 1
      ab 	 occurs at 3
      ab 	 occurs at 6
      ab 	 occurs at 8
      aab 	 occurs at 5
      bc 	 occurs at 9
      aac 	 occurs at 11

# Explanation
There are two steps for understanding the Aho-corsick Algorithm.
* first building the Trie data structure
* then, goto/fail state transitions

## Building the TRIE Data Structure
Trie represent prefixes for the dictionary which includes the list=["a", "ab", "aab", "aac", "bc"]. We will be going to start from a start node "#"
and we will look for every possible character that we can go to from that starting node. If there is an entire word ending for my dictionary ending 
at a certain note I'm going to list that as output so that node represents an entire word.
Continuing this process recursively, so from "a" once I've seen "a" what character is next it is "b" and so on if it is end end of that output add the
output node to it and add the word to it.

## Building the fail/goto state relationship
Each of the root node's children (here start node "#") fail to the start node itself. If at certain point there is a node that doesn't have any matching 
children then that node fails to it's parent node and then that parent node tries to match the character it its child nodes and if there is no success then
again it fails to it's parent node.
What basically we will do here is we start with the children of root node and put then in a queue and then start the level order traversal for it and pop 
each unitl empty.
Note for each each time you set a fail node you also have to add the output of the node it is failing to it.
