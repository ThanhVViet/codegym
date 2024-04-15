package ss3_arr_method.example;

public class Main3 {
    public static void main(String[] args) {
        String str1 = "Lê Thanh Việt";
        String str2 = "Lê Thanh Việt";
        String str3 = new String("Lê Thanh Việt");

        System.out.println(str1 == str2); // true
        System.out.println(str1.equals(str2)); // true

        System.out.println(str1 == str3); // false
        System.out.println(str1.equals(str3));//true
    }
}
