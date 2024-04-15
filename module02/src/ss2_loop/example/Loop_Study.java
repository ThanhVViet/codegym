package ss2_loop.example;

import java.util.Scanner;

public class Loop_Study {
    public static void main(String[] args) {
        //        int i=0;
//        while(true){
//            i++;
//            if(i % 2 ==0){
//                continue;
//            }
//            if(i % 5 ==0){
//                break;
//            }
//            System.out.println(i);
//        }
        int n;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập vào một số n: ");
            n = Integer.parseInt(scanner.nextLine());
            if(n<0){
                System.out.println("Giá trị nhập vào không hợp lệ vui lòng nhập lại");
            }
        } while(n<0);
        System.out.println("n = " + n);

    }
}
