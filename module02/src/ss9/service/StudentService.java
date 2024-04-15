package ss9.service;
import ss9.model.Student;
import ss9.repository.IStudentRepository;
import ss9.repository.StudentRepository;

import java.util.Scanner;

public class StudentService implements IStudentService{
    private IStudentRepository iStudentRepository = new StudentRepository();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        Student[] students = iStudentRepository.list();
        for (int i = 0; i < iStudentRepository.getSize(); i++) {
            System.out.printf("Thông tin sinh viên thứ %d:\n", i + 1);
            System.out.println(students[i]);
        }
    }

    @Override
    public void add() {
        System.out.println("Nhập vào id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào tên học sinh: ");
        String name = scanner.nextLine();
        System.out.println("Nhập điểm số: ");
        double score = Double.parseDouble(scanner.nextLine());
        Student[] students = iStudentRepository.list();
        students[iStudentRepository.addSize()] = new Student(id, name, score);
    }

    @Override
    public void edit() {
        System.out.println("Nhập vào id bạn muốn sửa thông tin: ");
        int id1 = Integer.parseInt(scanner.nextLine());
        Student[] students = iStudentRepository.list();
        System.out.println("Nhập vào tên mới học sinh: ");
        String name1 = scanner.nextLine();
        System.out.println("Nhập điểm mới: ");
        double score1 = Double.parseDouble(scanner.nextLine());
        students[find(id1)] = new Student(id1, name1, score1);
//        if (iStudentRepository.find1(id1)) {
//
//        } else {
//            System.out.println("Not Found");
//        }
    }

    @Override
    public void del() {
        System.out.println("Nhập vào id bạn muốn xoá thông tin: ");
        int iddel = Integer.parseInt(scanner.nextLine());
        Student[] students = iStudentRepository.list();
        for (int i = find(iddel); i < iStudentRepository.getSize() - 1; i++) {
            students[i] = students[i + 1];
        }
        students[iStudentRepository.getSize() - 1] = null;
        iStudentRepository.setSize();
        System.out.println("Successful");
        //iStudentRepository.delete(iddel);
    }

    @Override
    public int find(int id) {
        Student[] students = iStudentRepository.list();
        int index = -1;
        int z;
        for (z = 0; z < iStudentRepository.getSize(); z++) {
            if (id == students[z].getId()) {
                index = z;
                break;
            }
        }
        return z;
    }
}
