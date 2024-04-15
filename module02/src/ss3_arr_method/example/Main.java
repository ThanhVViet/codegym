package ss3_arr_method.example;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // nhập vào a,b,c
        // c phải nguyên dương
        int a = inputPositive("a");
        int b = inputPositive("b");
        int c = inputPositive("c");

        int factorialA = cal(a); // a là đối số
        int factorialB = cal(b);
        int factorialC = cal(c);

        int s = factorialA + factorialB + factorialC;
        System.out.println("s = " + s);
    }
    public static  int cal (int number){
        int factoriaNumber = 1;
        for (int i = 2; i <= number ; i++){
            factoriaNumber *= i;
        }
        return factoriaNumber;
    }
    public static int inputPositive(String target){
        int number;
        do{
            System.out.printf("Mời bạn nhập vào %s: ", target);
            number = Integer.parseInt(scanner.nextLine());
            if(number < 0){
                System.out.printf(" Giá trị của bạn vừa nhập không hợp lệ (%s >= 0), Vui lòng nhập lại ! \n ", target);
            }

        } while (number <0 );
        return number;
    }
}
