package ss9_mvc.service;


import ss9_mvc.model.Student;

public interface IStudentService {
    void display();
    void save(Student student);
    void del();

    int find(int id);
}
