package ss11_Stack_Queue.exercise;


import java.util.Arrays;
import java.util.Stack;

public class RI2 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        System.out.println("Mảng trước khi đảo ngược: ");
        System.out.print(Arrays.toString(arr));
        System.out.println();
        System.out.println("Mảng sau khi đảo ngược");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.print(Arrays.toString(arr));
    }
}
