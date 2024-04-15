package ss11_Stack_Queue.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DQ {
    public static void main(String[] args) {
        Person o1 = new Person("Viet", "Nam", 22);
        Person o2 = new Person("Na", "Nu", 20);


        Queue<Person> female = new LinkedList<>();
        Queue<Person> male = new LinkedList<>();

        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(o1);
        arrayList.add(o2);

        System.out.println("Before: ");
        arrayList.forEach(System.out::println);

        arrayList.forEach(
                element -> {

                    if (element.getGender().equals("Nu")) {
                        female.add(element);
                    } else {
                        male.add(element);
                    }
                });

        arrayList.clear();

        while (!female.isEmpty()) {
            arrayList.add(female.remove());
        }

        while (!male.isEmpty()) {
            arrayList.add(male.remove());
        }

        System.out.println("After: ");
        arrayList.forEach(System.out::println);
    }
}
