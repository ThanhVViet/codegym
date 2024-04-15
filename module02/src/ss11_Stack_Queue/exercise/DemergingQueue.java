package ss11_Stack_Queue.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DemergingQueue {
    public static void main(String[] args) {
        Person o1 = new Person("a", "nu", 10);
        Person o2 = new Person("b", "nam", 11);
        Person o3 = new Person("c", "nu", 12);
        Person o4 = new Person("d", "nam", 13);
        Person o5 = new Person("e", "nam", 14);
        Person o6 = new Person("f", "nu", 15);

        Queue<Person> qFemale = new LinkedList<>();
        Queue<Person> qMale = new LinkedList<>();

        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(o1);
        arrayList.add(o2);
        arrayList.add(o3);
        arrayList.add(o4);
        arrayList.add(o5);
        arrayList.add(o6);

        System.out.println("Before: ");
        arrayList.forEach(System.out::println);

        arrayList.forEach(
                o -> {
                    // should be use equal, this case true because gender string on pool = "nu" literal
                    if (o.getGender() == "nu") {
                        qFemale.add(o);
                    } else {
                        qMale.add(o);
                    }
                });

        arrayList.clear();

        while (!qFemale.isEmpty()) {
            arrayList.add(qFemale.remove());
        }

        while (!qMale.isEmpty()) {
            arrayList.add(qMale.remove());
        }

        System.out.println("After: ");
        arrayList.forEach(System.out::println);
    }
}
