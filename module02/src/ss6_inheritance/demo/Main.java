package ss6_inheritance.demo;

public class Main {
    public static void main(String[] args) {
        
        Person[] people = new Person[2];
        people[0] = new Teacher(1,"Nguyen van",9000);
        people[1] = new Student(1, "Nguyen Van B", 9.6);
        
        Person person = new Teacher(1,"Nguyen van",9000);
        Person person2 = new Student(1, "Nguyen Van B", 9.6);
        
        //Da hinh luc runtime
        System.out.println(person.toString());
        System.out.println(person.equals(person2)); // true
        
        //Da hinh luc compile time
        System.out.println(person.sum(1,2));
        
        // ====== Kieu du lieu luc tham chieu
        if(person instanceof Student){
            System.out.println(((Student)person).getScore());
        }else {
            System.out.println(((Teacher)person).getSlary());
        }
        
        
        
        

        
        // kieu du lieu nguyen thuy
        int num = 2;
        long b = num;//ép ngầm định
        int c = (int) b;// ép tường minh tự ép
        System.out.println(c);
    }
}
