package ss5_access_static.exercise;

public class Only_Write {
    public static void main(String[] args) {
        Student st1 = new Student();
        st1.setName("Viet");
        st1.setClasses("21TCLC-DT4");
        System.out.println(st1);
    }

    static class Student {
        private String name = " Jhon";
        private String classes = "CO2 ";

        public Student() {

        }

        public void setName(String name) {
            this.name = name;
        }

        public void setClasses(String classname) {
            this.classes = classname;
        }

        public String toString() {
            return "Student : " + this.name + " study at class " + this.classes;
        }
    }
}
