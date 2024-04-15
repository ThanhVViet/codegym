package ss11_Stack_Queue.exercise.Queue_DSLKvong;

public class Queue<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
    void enQueue(T t) {
        Node node = new Node(t);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }

        tail = node;
        tail.next = head; // thiết lập liên kê vòng gán tham chiếu next của tail cho head
        size++;
    }

    void deQueue() {
        if (head != null) {
            if (head.equals(tail)) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }

            size--;
        }
    }

    boolean contains(T t) {
        Node tmp = head;

        if (head == null) {
            return false;
        }

        do {
            if (t.equals(tmp.data)) {
                return true;
            }

            tmp = tmp.next;
        } while (tmp.next != head);

        return false;
    }

    void display() {
        if (head != null) {
            Node tmp = head;

            do {
                System.out.print(tmp.data + " ");
                tmp = tmp.next;
            } while (tmp != head);
        }
    }

}
