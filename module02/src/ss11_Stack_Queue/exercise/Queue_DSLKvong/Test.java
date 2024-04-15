package ss11_Stack_Queue.exercise.Queue_DSLKvong;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(1);
        queue.enQueue(6);
        queue.enQueue(10);
        queue.enQueue(61);
        queue.enQueue(16);

        System.out.println("contain is: "+  queue.contains(3));

        queue.deQueue();

        queue.display();

    }
}
