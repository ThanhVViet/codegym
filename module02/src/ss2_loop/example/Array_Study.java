package ss2_loop.example;

import java.util.Arrays;
import java.util.Scanner;

public class Array_Study {
    public static void main(String[] args) {
        // Nhập và xuất mảng 1 chiều
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Nhập: ");
            n= Integer.parseInt(scanner.nextLine());
            if(n<0){
                System.out.println("k dc");
            }
        }while (n<0);
        int [] arr = new int [n];
        for (int i=0; i<n;i++){
            System.out.printf("Nhập vào a[%d]: ", i + 1);
            arr[i]=Integer.parseInt(scanner.nextLine());
        }
        System.out.println(Arrays.toString(arr));

    }
}
