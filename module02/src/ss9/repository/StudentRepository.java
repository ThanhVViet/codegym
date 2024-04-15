package ss9.repository;
import ss9.model.Student;


public class StudentRepository implements IStudentRepository{
    static Student[] students = new Student[100];
    Student student = new Student();
    static int size = 0;

    static {
        students[0] = new Student(1, "Nguyễn Văn A", 9.6);
        students[1] = new Student(2, "Nguyễn Văn B", 5.6);
        students[2] = new Student(3, "Nguyễn Văn C", 6.7);
        size = 3;
    }

    @Override
    public Student[] list() {
        return students;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int addSize() {
        return size++;
    }
    @Override
    public int setSize() {
        return size--;
    }

    @Override
    public int find(int id) {
        int index = -1;
        int z;
        for (z = 0; z < size; z++) {
            if (id == students[z].getId()) {
                index = z;
                break;
            }
        }
        return z;
    }

    @Override
    public void delete(int iddel) {
        int index_del = -1;
        for (int z = 0; z < size; z++) {
            if (iddel == students[z].getId()) {
                index_del = z;
                break;
            }
        }
        for (int i = index_del; i < size - 1; i++) {
            students[i] = students[i + 1];
        }
        students[size - 1] = null;
        size--;
        System.out.println("Successful");
    }

    @Override
    public boolean find1(int id) {
        for (Student student : students) {
            if (id == student.getId()) {
                return true;
            }
        }
        return false;
    }

}
