package ss10_DSA.exercise.TK_ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class MyList<E> implements Cloneable {
    private int size = 0;
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    public void add(E e) {
        elements[size++] = e;
    }

    public static int input() {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        int n = 0;
        while (!check) {
            System.out.print(" ");
            try {
                n = input.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("You must enter a number");
                input.nextLine();
            }
        }
        return (n);
    }

    public MyList(int size) {
        this.size = size;
        elements = new Object[size];
    }

    public void add(int index, E e) {
        if (size == elements.length) {
            System.out.println("Runout of space");
            int minCapacity = -1;
            System.out.println("Enter amount of space that you want to increase: ");
            minCapacity = input();
            ensureCapasity(minCapacity);
        } else {
            for (int z = elements.length - 1; z > index; z--) {
                elements[z] = elements[z - 1];
            }
            elements[index] = e;
            size++;
        }
    }

    public void ensureCapasity(int minCapacity) {
        if (minCapacity < 0 || minCapacity == 1) {
            System.out.println("The parameter must be larger than 0 !!");
        } else {
            int newSize = minCapacity * elements.length;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    public E remove(int index) {
        E e = (E) elements[index];
        for (int v = index; v < elements.length - 1; v++) {
            elements[v] = elements[v + 1];
        }
        size--;
        return e;
    }

    public int size() {
        return size;
    }

    public E clone() {
        int size = elements.length;
        E[] clone_arr = (E[]) Arrays.copyOf(elements, size);
        return (E) clone_arr;
    }

    public boolean contains(E o) {
        for (int i = 0; i < elements.length; i++) {
            if (o.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        int i;
        for (i = 0; i < elements.length; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean add1(E o) {
        if (size < elements.length) {
            elements[size++] = o;
            return true;
        }
        return false;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public void clear() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(elements[i]);
            if (i < size - 1) result.append(", ");
        }

        return result.toString() + "]";
    }

    public Object clone1() throws CloneNotSupportedException {
        return super.clone();
    }
}
