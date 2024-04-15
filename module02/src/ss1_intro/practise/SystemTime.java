package ss1_intro.practise;

import java.util.Date;

//Trong phần này, chúng ta sẽ tạo một ứng dụng Java để hiển thị thời gian hiện tại của máy tính.
public class SystemTime {
    public static void main(String[] args) {
        Date now = new Date(); // Lấy ra thời gian hiện tại
        System.out.println("Now is: " + now);
    }
}
