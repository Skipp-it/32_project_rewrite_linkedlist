package com.codecool.linkedlist;

import javax.swing.plaf.IconUIResource;

public class SinglyLinkedList {

    private class Link {

        private int value;
        private Link next;

        Link(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }

        Link getNext() {
            return next;
        }

        void setNext(Link next) {
            this.next = next;
        }
    }

    private Link head;
    private int addedTimes =0;

    public SinglyLinkedList() {
    }


    /**
     * Add a new element to the list.
     * The new element is appended to the current last item.
     *
     * @param value value to be appended
     */

    public void add(int value) {

        if (head == null) {
            this.head = new Link(value);
//            addedTimes = 1;
        } else {
            Link temp = head;
            while (temp.getNext() != null) {
//                addedTimes++;
                temp=temp.getNext();
            }
            temp.setNext(new Link(value));
        }
    }

    /**
     * Get a value based on its index.
     *
     * @param index the position of requested value
     * @return value of element at index
     */

    public int get(int index) {
        Link temp = this.head;
        if (this.size() <= index) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            if (temp == null) {
                throw new IndexOutOfBoundsException();
            }
        } else if (index > 0) {
            int count = 0;
            while (temp.getNext() != null) {
                count += 1;
                temp = temp.getNext();
                if (count == index) {
                    return temp.getValue();
                }
            }
        }
        return temp.getValue();
    }



    /**
     * Returns the zero-based index of the first occurrence of a value in the list.
     *
     * @param number value to be searched
     * @return Index of 'number' if it's in the list, otherwise -1;
     */

    public int indexOf(int number) {
        int count = 0;
        Link temp = this.head;
        if (temp.getValue() == number) {
            return 0;
        }
        while (temp.getNext() != null && temp.getValue() != number) {

            count += 1;
            temp = temp.getNext();
            if (temp.getValue() == number) {
                return count;
            }
        }
        return -1;
    }

    /**
     * Inserts a value at an index into the array shifting elements if necessary.
     *
     * @param index  Position of the new element
     * @param number Value to be inserted.
     */
    public void insert(int index, int number) {
        Link temp = head;
        int count = 1;
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0) {
            head = new Link(number);
            head.setNext(temp);
        }
        else if (index == this.size()) {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Link(number));
        }
//        else if (index ==1){
//            temp.setNext(new Link(number));
//        }
        else if (index > 0) {
            while (temp.getNext() != null) {
                if (index == count+1){
                    temp.setNext(new Link(number));
                }
                count ++;
                temp = temp.getNext();
            }
        }
    }

    /**
     * Returns with the amount of inserted nodes.
     *
     * @return Size of list.
     */
    public int size() {
        int countSize =0;
        Link temp = this.head;
        if (temp != null) {
            countSize = 1;
            while (temp.getNext() != null) {
                countSize += 1;
                temp = temp.getNext();
            }
        }
        return countSize;
    }

    public void removeByValue(int value) {
        int index = this.indexOf(value);
        if (index != -1) {
            this.remove(index);
        }
    }

    /**
     * Removes the element at 'index' from the array.
     *
     * @param index Position of value to be deleted.
     */
    public void remove(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        Link elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Link elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());
    }
}
