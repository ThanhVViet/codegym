package ss5_access_static.example._static;

public class Main2 {
    public static void main(String[] args) {
        Student student = new Student(1, "Nguyễn Văn A");
//        student.setId(10);
//        student.id = 10;
        System.out.println(student.getId());

        student.setScore(100);
//        student.setId(100);

    }

    public void test() {
//        Animal animal = new Animal();
//        animal.age = 9;
      //  super.color = "red";
    }
}
