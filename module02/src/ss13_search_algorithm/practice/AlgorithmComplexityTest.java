package ss13_search_algorithm.practice;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();
        // ban dau tat ca gia tri phan tu trong mang co gia tri khoi tao la 0
        int[] frequentChar = new int[255];                         //{1}
        for (int i = 0; i < inputString.length(); i++) {           //{2}
            /* Tìm ví trí tương ứng của ký tự trong bảng ASCII */
            // chuyen ki tu thanh so tuong ung
            int ascii = inputString.charAt(i);                     //{3}
            // a = 97, l = 108, o = 111
            System.out.println(ascii);
            /* Tăng giá trị tần suất */
            frequentChar[ascii] += 1;                              //{4}
            System.out.println(frequentChar[ascii]);
        }

        int max = 0;                                             //{5}
        char character = (char) 255; /* empty character */      //{6}

        for (int j = 0; j < 255; j++) {                         //{7}
            if (frequentChar[j] > max) {                        //{8}
                System.out.println(frequentChar[j]);
                max = frequentChar[j];                          //{9}
                character = (char) j;                           //{10}
            }
        }
        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");
    }
}
// 1,3,4,5,6,8,9,10 ton O(1)
//Vòng lặp {2} thực hiện (n) lần, mỗi lần O(1) do đó vòng lặp {2} tốn O((n).1) = O(n)  với  n là độ dài chuỗi ký tự.
//{7} thực hiện (255) lần, mỗi lần O(1) do đó vòng lặp {7} tốn O((255).1) = O(255).
/*TH1: n <= 255

        Khi đó độ phức tạp của thuật toán  sẽ là thời gian thực hiện lệnh {7} và bằng O(255)

        TH2: n> 255

        Khi đó độ phức tạp của thuật toán  sẽ là thời gian thực hiện lệnh {2} và bằng O(n)

 */

