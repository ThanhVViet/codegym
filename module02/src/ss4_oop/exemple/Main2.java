package ss4_oop.exemple;

public class Main2 {
    public static void main(String[] args) {
//        String name = null; // Không được phép sửa
//        System.out.println("Nguyễn Văn A".equals(name));
//        Student student = new Student("Nguyễn Văn A", 9.6);
//        System.out.println(student.display());
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < 1000000000; i++) {i++;}

        long endTime = System.currentTimeMillis();

        System.out.println(" Thời gian chạy: " + (endTime - startTime));
    }
}
