package ss9_mvc.repository;

import ss9_mvc.model.Student;

import java.util.Optional;

public interface IStudentRepository {

//    Student[] findALL();
    Optional<Student> findById(int id);
    Student[] list();
    int getSize();
    int addSize();
    int find(int id);
    void delete(int id);
    boolean find1 (int id);
    int setSize();

    void save(Student student);

}
