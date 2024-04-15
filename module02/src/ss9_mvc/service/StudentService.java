package ss9_mvc.service;

import ss9_mvc.model.Student;
import ss9_mvc.repository.IStudentRepository;
import ss9_mvc.repository.StudentRepository;

import java.util.*;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();
    Scanner scanner = new Scanner(System.in);

    public int find(int id) {
       return studentRepository.find(id);
    }

    @Override
    public void display() {
        Student[] students = studentRepository.list();
        for (int i = 0; i < studentRepository.getSize(); i++) {
            System.out.printf("Thông tin sinh viên thứ %d:\n", i + 1);
            System.out.println(students[i]);
        }
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

//        studentRepository.save(student);

//    @Override
//    public void edit() {
//        System.out.println("Nhập vào id bạn muốn sửa thông tin: ");
//        int id1 = Integer.parseInt(scanner.nextLine());
//        Student[] students = studentRepository.list();
//        System.out.println("Nhập vào tên mới học sinh: ");
//        String name1 = scanner.nextLine();
//        System.out.println("Nhập điểm mới: ");
//        double score1 = Double.parseDouble(scanner.nextLine());
//        students[find(id1)] = new Student(id1, name1, score1);
////        if (iStudentRepository.find1(id1)) {
////
////        } else {
////            System.out.println("Not Found");
////        }
//    }

    @Override
    public void del() {
        System.out.println("Nhập vào id bạn muốn xoá thông tin: ");
        int iddel = Integer.parseInt(scanner.nextLine());
        Student[] students = studentRepository.list();
        for (int i = find(iddel); i < studentRepository.getSize() - 1; i++) {
            students[i] = students[i + 1];
        }
        students[studentRepository.getSize() - 1] = null;
        studentRepository.setSize();
        System.out.println("Successful");
        //iStudentRepository.delete(iddel);
    }
}
