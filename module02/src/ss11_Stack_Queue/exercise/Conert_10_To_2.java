package ss11_Stack_Queue.exercise;

import java.util.Scanner;
import java.util.Stack;

public class Conert_10_To_2 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập vào một số: ");
        int input = Integer.parseInt(scanner.nextLine());
        System.out.println("Dạng nhị phân của số "+ input + " là " );
        while(input != 0){
            stack.push(input % 2);
            input /= 2;

        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
