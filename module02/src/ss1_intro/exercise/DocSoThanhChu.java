package ss1_intro.exercise;

import java.util.Scanner;

public class DocSoThanhChu {
    private static final String[] donVi = {"", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
    private static final String[] chuc = {"", "mười", "hai mươi", "ba mươi", "bốn mươi", "năm mươi", "sáu mươi", "bảy mươi", "tám mươi", "chín mươi"};
    private static final String[] tram = {"", "một trăm", "hai trăm", "ba trăm", "bốn trăm", "năm trăm", "sáu trăm", "bảy trăm", "tám trăm", "chín trăm"};

    public static String docSoThanhChu(int n) {
        if (n == 0) {
            return "không";
        } else if (n < 10) {
            return donVi[n];
        } else if (n < 20) {
            return "mười " + donVi[n % 10];
        } else if (n < 100) {
            return chuc[n / 10] + " " + docSoThanhChu(n % 10);
        } else if (n < 1000) {
            return tram[n / 100] + " " + docSoThanhChu(n % 100);
        }

        return "Số quá lớn";
    }

    public static void main(String[] args) {
        int so;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter a number :");
            so = Integer.parseInt(sc.nextLine());
            if(so > 999){
                System.out.println("Please enter a number from 0 to 999 !!!");
            }
        }while(so > 999);
        String soChu = docSoThanhChu(so);
        System.out.println("Số " + so + " được đọc thành chữ là: " + soChu);
    }
}
