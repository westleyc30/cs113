package edu.miracosta.cs113;

import java.util.*;

public class DoubleLinkedList<E> extends AbstractSequentialList<E> {  // Data fields
    private Node<E> head = null;   // points to the head of the list
    private Node<E> tail = null;   //points to the tail of the list
    private int size = 0;    // the number of items in the list

    /**
     * Default constructor
     */
//    public DoubleLinkedList() {
//
//    }


    /**
     * Add an item at position index
     * @param index the position at which the object is to be inserted
     * @param obj The object to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (i < 0 || i > size())
     */
//    public void add(int index, E obj) { // Fill Here
//        listIterator(index).add(obj);
//    }


//    public void addFirst(E obj) { // Fill Here
//        Node<E> tempNode = new Node<>(obj);
//        tempNode.next = this.head;
//        this.head = tempNode;
//        this.size++;
//    }
//
//    public void addLast(E obj) { // Fill Here
//        Node<E> tempNode = new Node<>(obj);
//        tempNode.prev = tail;
//        tempNode.next = null;
//        this.tail = tempNode;
//        this.size++;
//    }
/// TODO
//    public E set(int i, E e) {
//        E returnValue = null;
//        ListIterator<E> iter = listIterator(i);
//        if (iter.hasNext()) {
//            iter.set(e);
//        }
//        return returnValue;
//    }
//    public E get(int index) {
//        try {
//            return (E) listIterator(index).next();
//        } catch (NoSuchElementException exc) {
//            throw new IndexOutOfBoundsException("Index: "+index);
//        }
//    }
//
//    public E getFirst() {
//        return head.data;
//    }
//
//    public E getLast() {
//        return tail.data;
//    }

    public int size() {
        return this.size;
    } // Fill Here

    public E remove(int index) {
        E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext()) {
            returnValue = iter.next();
            iter.remove();
        } else {
            throw new IndexOutOfBoundsException();
        }
        return returnValue;
    }

    public Iterator iterator() {
        return new ListIter(0);
    }

    public ListIterator listIterator() {
        return new ListIter(0);
    }

    public ListIterator listIterator(int index) {
        return new ListIter(index);
    }

    public ListIterator listIterator(ListIterator iter) {
        return new ListIter((ListIter) iter);
    }

    // Inner Classes
    private static class Node<E> {
        private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        private Node(E dataItem)  //constructor
        {
            data = dataItem;
        }
    }  // end class Node

    public class ListIter implements ListIterator<E> {
        private Node<E> nextItem;      // the current node
        private Node<E> lastItemReturned;   // the previous node
        private int index = 0;   //

        public ListIter(int i)  // constructor for ListIter class
        {
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException("Invalid index " + i);
            }
            lastItemReturned = null;

            if (i == size)     // Special case of last item
            {
                index = size;
                nextItem = null;
            } else          // start at the beginning
            {
                nextItem = head;
                for (index = 0; index < i; index++) nextItem = nextItem.next;
            }// end else
        }  // end constructor

        public ListIter(ListIter other) {
//            nextItem = other.nextItem;
//            index = other.index;

        }

        public boolean hasNext() {
            return nextItem != null;
        }

        public boolean hasPrevious() {
            /// CHECK EDGE CASES ALWAYS!!!
            if (head == null) {
                return false;
            }
            return (nextItem == null && size != 0)
                    || nextItem.prev != null;
        }

        public int previousIndex() {
            return index - 1;
        }

        public int nextIndex() {

                return index;

        } // Fill here

        /// CHANGE THE DATA FOOL!!!!!!!!!!!!!
        @Override
        public void set(E item) {
            if (lastItemReturned == null) {
                throw new IllegalStateException();
            }
            lastItemReturned.data = item;
        }
//        public void set(E o) {
//
//            Node<E> newNode = new Node<>(o);
//            if(lastItemReturned == null) {
//                throw new IllegalStateException();
//            }
//            if (lastItemReturned.prev == null) {
//                newNode.prev = null;
//                newNode.next = head.next;
//                head = newNode;
//
//            } else if (lastItemReturned.next == null) {
//                newNode.next = null;
//                newNode.prev = tail.prev;
//                newNode.prev.next = newNode;
//                tail = newNode;
//
//            } else {
//                newNode.next = lastItemReturned.next;
//                newNode.prev = lastItemReturned.prev;
//                newNode.next.prev = newNode;
//                newNode.prev.next = newNode;
//            }
////            nextItem.prev = newNode;
////            newNode.prev = lastItemReturned;
////            newNode.next = nextItem;
////            lastItemReturned.next = newNode;
//        }

        /// remove is based on the last item returned which is set by previous() and next()
//        public void remove() {
//
//            // check if lastItemReturned has been initialized by previous() or next()
//            if (lastItemReturned == null) {
//                throw new IllegalStateException();
//            } else if(lastItemReturned.prev == null) {
//                System.out.println("HEAD REMOVED?");
//                head = nextItem;
//                head.prev = null;
//
//            } else if(lastItemReturned.next == null) {
//                System.out.println("TAIL REMOVED?");
//                tail = tail.prev;
//                tail.next = null;
//            } else {
//                System.out.println("MIDDLE REMOVED");
//                lastItemReturned.next.prev = lastItemReturned.prev;
//                lastItemReturned.prev.next = lastItemReturned.next;
//            }
//            size--;
//            index--;
//            lastItemReturned = null;
//        }


        @Override
        public void remove() {
            if (lastItemReturned == null) {
                throw new IllegalStateException();
            }
            // Unlink this item from its next neighbor
            if (lastItemReturned.next != null) {
                lastItemReturned.next.prev = lastItemReturned.prev;
            } else { // Item is the tail
                tail = lastItemReturned.prev;
                if (tail != null) {
                    tail.next = null;
                } else { // list is now empty
                    head = null;
                }
            }
            // Unlink this item from its prev neighbor
            if (lastItemReturned.prev != null) {
                lastItemReturned.prev.next = lastItemReturned.next;
            } else { // Item is the head
                head = lastItemReturned.next;
                if (head != null) {
                    head.prev = null;
                } else {
                    tail = null;
                }
            }
            // Invalidate lastItemReturned
            lastItemReturned = null;
            // decrement both size and index
            size--;
            index--;
        }




        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        public E previous() {

            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextItem == null) { // Iterator is past the last element
                nextItem = tail;
            } else {
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        public void add(E obj) {
            if (head == null) {
                head = new Node<>(obj);
                tail = head;
            } else if (nextItem == head) {
                Node<E> newNode = new Node<>(obj);
                newNode.next = nextItem;
                nextItem.prev = newNode;
                head = newNode;
            } else if (nextItem == null) {
                Node<E> newNode = new Node<>(obj);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {

                Node<E> newNode = new Node<>(obj);
                // Link it to nextItem.prev.
                newNode.prev = nextItem.prev; // Step 1
                nextItem.prev.next = newNode; // Step 2
                // Link it to the nextItem.
                newNode.next = nextItem; // Step 3
                nextItem.prev = newNode; // Step 4
            }
            size++;
            index++;
            lastItemReturned = null;

        }
    }// end of inner class ListIter


    @Override
    public String toString() {
        ListIterator<E> iter = listIterator();
        if (size == 0) {
            return "[]";
        }
        String output = "[";
        while (iter.hasNext()) {
            if(!iter.hasNext()) {
                output += iter.next().toString();
            } else {
                output += iter.next().toString() + ", ";
            }
        }
        output = output.substring(0, output.length() - 2);
        output += "]";
        return output;
    }
}// end of class DoubleLinkedList
