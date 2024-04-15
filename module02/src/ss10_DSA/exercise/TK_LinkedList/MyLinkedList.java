package ss10_DSA.exercise.TK_LinkedList;

import org.w3c.dom.Node;

public class MyLinkedList<E> implements Cloneable {
    private Node head;
    private int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }

    public class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, E elements) {
        Node temp = head;
        Node holder;
        if (index == 0) {
            addFirst(elements);
        }
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(elements);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E elements) {
        Node temp = head;
        head = new Node(elements);
        head.next = temp;
        numNodes++;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public int size() {
        return numNodes;
    }

    public void addLast(E elements) {
        if (head == null) {
            addFirst(elements);
            //When the list is empty, i.e, head points to null
        } else {//When list is populated
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(elements);
            numNodes++;
        }
    }

    public Node remove(int index) {
        Node temp = head;
        if (index == 0) {
            head = temp.next;
        }
        for (int i = 0; temp != null && i < index - 1; i++)
            temp = temp.next;
        Node next = temp.next.next;
        temp.next = next;
        numNodes--;
        return temp.next;
    }

    public boolean remove1(Object e) {
        Node temp = head;
        Node pre = null;
        while (temp != null) {
            if ((temp.data).equals(e)) {
                Node next = temp.next;
                pre.next = next;
                numNodes--;
                return true;
            }
            pre = temp;
            temp = temp.next;
        }

        return false;

    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean contains(E o) {
        Node temp = head;
        while (temp != null) {
            if ((temp.data).equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public E get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp.next = temp;
        }
        return (E) temp.data;
    }

    public int indexOf(E o) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if ((temp.data).equals(o)) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public boolean add1(E e) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (i == 0) {
                addFirst(e);
                break;
            }
            temp = temp.next;
        }
        return false;
    }

    public void clear() {
        numNodes = 0;
        head = null;
    }

    public E getFirst() {
        return (E) head.data;
    }

    public E getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

}
