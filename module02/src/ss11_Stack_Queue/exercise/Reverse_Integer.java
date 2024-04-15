package ss11_Stack_Queue.exercise;

import java.util.Arrays;
import java.util.Stack;

public class Reverse_Integer {
    public static void main(String[] args) {
        /*range without last
        int[] intArray = IntStream.range(1, 11).toArray();
        range with last
        int[] intArray = IntStream.rangeClosed(1, 10).toArray()*/
//                int[] arr= IntStream.of(1,2,3,4,8,9).toArray();
        Integer[] a= new Integer[3];
        a[0]=1;
        a[1]=2;
        a[2]=4;

        System.out.println("Arrays Integer before reserve:");
        Arrays.asList(a).forEach(System.out::println);

        Stack<Integer> stack= new Stack<>();
        Arrays.asList(a).forEach(e->stack.push(e));

        int size= stack.size();
        for (int i = 0; i < size; i++) {
            a[i]= stack.pop();
        }

        System.out.println("Arrays Integer after reserve:");
        Arrays.asList(a).forEach(System.out::println);

        System.out.println("-----------------");
        Stack<String> stringStack= new Stack<>();
        String b= "Hello World";
        System.out.println("Arrays String before reserve:");
        System.out.println(b);
        Arrays.asList(b.split("")).forEach(e-> stringStack.push(e));

        StringBuilder strReseve= new StringBuilder();
        int sizeStringStack= stringStack.size();

        for (int i = 0; i < sizeStringStack; i++) {
            strReseve.append(stringStack.pop());
        }

        System.out.println("Arrays String after reserve:");
        System.out.println(strReseve);

        // reserve by string builder
/*        StringBuilder stringBuilder1= new StringBuilder(b);
        stringBuilder1.reverse();
        System.out.println(stringBuilder1);*/

    }
}
