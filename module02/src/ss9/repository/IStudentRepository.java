package ss9.repository;
import ss9.model.Student;

public interface IStudentRepository {
    Student[] list();
    int getSize();
    int addSize();
    int find(int id);
    void delete(int delid);
    boolean find1 (int id);
    int setSize();

}
