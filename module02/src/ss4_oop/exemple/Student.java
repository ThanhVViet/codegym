package ss4_oop.exemple;

public class Student {

        int id; // Định danh duy nhất
        String name;
        double score; // thuộc tính

        public Student() {
        }

        public Student(String name, double score) {
            this.name = name;
            this.score = score;
        }

        public Student(int id, String name, double score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }

        void run() { // phương thức
            System.out.println(name + " có thể chạy");
        }

        String display() {
            return String.format("%s - %s - %s", this.id, name, score);
        }
    }


