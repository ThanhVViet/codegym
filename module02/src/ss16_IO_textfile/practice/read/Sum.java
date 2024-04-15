package ss16_IO_textfile.practice.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Sum {
    public void readFileText(String filePath) {
        try {
            // Đọc file theo đường dẫn
            File file = new File(filePath);

            // Kiểm tra nếu file không tồn tại thì ném ra ngoại lệ.
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            // Đọc từng dòng của file và tiến hành cộng tổng lại
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "" ;
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();

            // Hiển thị ra màn hình tổng các số nguyên trong file
            System.out.println("Tổng = " + sum);
        } catch (Exception e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Fie không tồn tại hoac nội dung có lỗi!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        Sum readFileEx = new Sum();
        readFileEx.readFileText(path);
    }
}
//  /Users/thanhviet/Text/numbers.txt

//private static final String PATH="src\\_16_io_text_file\\practice\\p1\\numbers.txt";
//
//    public static void main(String[] args) {
//        try{
//            File file= new File(PATH);
//            if (!file.exists()) {
//                throw new FileNotFoundException();
//            }
//
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String line;
//            int sum = 0;
//            while ((line = br.readLine()) != null) {
//                sum += Integer.parseInt(line);
//            }
//            br.close();
//            System.out.println(sum);
//        }
//        catch (Exception ex){
//            System.err.println("Fie not exists or content error!");
//        }
//    }