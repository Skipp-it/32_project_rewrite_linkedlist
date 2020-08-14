# Project Rewrite - Linked list

## Story

> This kind of exercise is a classic: your task is to reimplement some basic
> built-in features of a language or its standard library for pedagogical
> reasons without using the feature itself or similar features.
> Caveat: don’t use such code in your commercial projects!

In computer science, a _linked list_ is a linear collection of data elements, whose order is not given by their physical placement in memory. Instead, each element points to the next. It is a data structure consisting of a collection of nodes which together represent a sequence. In its most basic form, each node contains: _data_, and a _reference_ (in other words, a _link_) to the next node in the sequence. This structure allows for efficient insertion or removal of elements from any position in the sequence during iteration. More complex variants add additional links, allowing more efficient insertion or removal of nodes at arbitrary positions. A drawback of linked lists is that access time is linear (and difficult to pipeline). Faster access, such as random access, is not feasible. Arrays have better cache locality compared to linked lists.

On the average, a well-implemented and properly used linked list has the following time complexity characteristics:

- _get_ a value by index: `O(n)`
- _insert/remove_ value at the end: `O(1)`
- _insert/remove_ value in the middle: `search time + O(1)`

There are different alternatives of linked list:

- Singly linked list: contain nodes which have a data field as well as 'next' field, which points to the next node in line of nodes.
- Doubly linked list: In a 'doubly linked list', each node contains, besides the next-node link, a second link field pointing to the 'previous' node in the sequence.
- Multiply linked list: each node contains two or more link fields, each field being used to connect the same set of data records in a different order of same set(e.g., by name, by department, by date of birth, etc.).
- Circular linked list: the last pointer points to the first node. In the case of a circular doubly linked list, the first node also points to the last node of the list.

### Real life usage of linked list

A linked list can be used to implement a queue, another frquently used data structure. The canonical real life example would be a line for a cashier.

A linked list can also be used to implement a stack. The cononical real ife example would be one of those plate dispensers at a buffet restaurant where pull the top plate off the top of the stack.

Now we will focus on Singly Linked List.

## What are you going to learn?

- You will get familiar with a fundamental data structure
- Working with generics

## Tasks

1. Rewrite both `Link`, `SinglyLinkedList` and a tiny part of `SinglyLinkedListTests` to work with any generic `T` types as values.
    - The linked list can be instantiated and work with generic `value` types

2. Implement `add()` method: Append element at the end of the list
    - In case of empty list `add()` method set the given value as head and increase size to 1
    - Method `add()` append the given value at the end of the list while increase its size accordingly e.g. the result of add 42 to a list `[0 -> 1 -> 4]` is  `[0 -> 1 -> 4 -> 42]`

3. Implement the `insert()` method: Inserts a value at an index into the list shifting elements if necessary.
    - Indexing starts with zero which means if I insert an element at index `0` it will become the first element in the list.
e.g. the result of inserting 42 at index 0 into a list
`[0 -> 1 -> 2 -> 3 -> 4]` is 
`[42 -> 0 -> 1 -> 2 -> 3 -> 4]`
    - Method `insert()` places value as a last element if the index equals to the size of the list
e.g. the result of inserting 42 at index 5 into a list
`[0 -> 1 -> 2 -> 3 -> 4]` is 
`[0 -> 1 -> 2 -> 3 -> 4 -> 42]`
    - Method `insert()` places value at first index and shift all other elements back
e.g. the result of inserting 42 at index 3 into a list
`[0 -> 1 -> 2 -> 3 -> 4]` is
`[0 -> 1 -> 2 -> 42 -> 3 -> 4]`
    - In case of negative index the method throws `IndexOutOfBoundException`
    - In case of the given index is bigger than the amount of elements in list it throws an `IndexOutOfBoundException`

4. Implement the `get()` method: return the value based on its index. If the given index is bigger than the size of your list signal it with an appropriate exception.
    - Indexing starts at zero which means if I get the element at index `0` it will return with the first element of the list.
e.g. the result of getting element at index 0 from the following list
`["ZERO" -> "one" -> "two" -> "three" -> "four"]` is "ZERO"
    - Method `get()` returns the value for an existing element in the linked list
e.g. the result of getting element at index 3 from the following list
`["zero", "one" -> "two" -> "THREE" -> "four" -> "five"]` is "THREE"
    - Method `get()` throws `IndexOutOfBoundException` for a non-existing index.

5. Implement the `indexOf()` method: return the index of a searched value.
If the given value cannot be found return with -1.
    - Method `indexOf()` returns the index of value found in list
e.g. the result of searching 42 in a list
`[0 -> 1 -> 2 -> 42 -> 3 -> 4]` is 3
    - Method `indexOf()` returns with -1 if the searched value cannot be found in list
e.g. the result of searching 321 in a list
`[0 -> 1 -> 2 -> 42 -> 3 -> 4]` is -1

6. Implement the `size()` method: returns the amount of elements stored in the list.
    - Method `size()` returns zero in case of empty list.
    - Method `size()` returns with the amount of inserted element in case of non-empty list.
e.g. the size of this list `[0 -> 1 -> 2 -> 42 -> 3 -> 4]` is 6

7. Override the `toString()` method: returns the string representation of the list content
    - In case of empty list `toString()` returns with "[]"
    - In case of non-empty array the `toString()` method returns with the inserted elements in the following form: "[1, 5, 10, 654]"

## General requirements

- All test result is green.
- All code is pushed to GitHub repository by atomic commits. The implementation related commits managed on separated feature branch and merged by a pull request to the `master` branch.

## Hints

- You can see from the method signatures in the starter code that `LinkedList` expects integer type values. One of the tasks is to
  make it _generic_: it should work with any `T` type as values, where `T` is fixed at instantiation. You can do this conversion step at any point, however, we suggest to start with this
  exercise.
- If you make it generic you have to modify the unit tests as well accordingly. But don't be afraid, it means just a few characters.
- We implemented the `remove()` method for you so you can draw some inspiration from it.

## Starting your project

To start your project click [this link](https://journey.code.cool/v2/project/solo/blueprint/rewrite-linkedlist/java).

## Background materials

- <i class="far fa-exclamation"></i> [What is a linked list?](https://en.wikipedia.org/wiki/Linked_list)
- <i class="far fa-exclamation"></i> [Generics and the diamond operator](https://learn.code.cool/full-stack/#/../pages/java/generics-and-the-diamond-operator.md)
- <i class="far fa-exclamation"></i> [Generics in Java](https://www.geeksforgeeks.org/generics-in-java/)
