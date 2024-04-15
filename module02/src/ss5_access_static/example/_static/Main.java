package ss5_access_static.example._static;

public class Main {
    public static void main(String[] args) {
        //        System.out.println(Math.PI);
        Student student = new Student(1, "Nguyễn Văn A");
        Student student2 = new Student(2, "Nguyễn Văn B");
        student.count++;
        ++student2.count;
        Student.count++;

        System.out.println(student.count); //? 2 => 4
        System.out.println(Student.count); //? 2 => 4
        System.out.println(Math.sqrt(4));

        int a = InputUtil.inputPositive("a");

        methodStatic();
//        methodNonStatic();
    }

    public static void methodStatic() {

    }

    public void methodNonStatic() {
        methodStatic();
    }
}

