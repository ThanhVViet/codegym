package ss9.model;

public class Student {
    private int id;
    private String name;
    private double score;

    public Student() {

    }
    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if ( score < 0 || score > 10) {
            System.out.println("Điểm không hợp lệ");
            // exception
        } else {
            this.score = score;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
