package ss10_DSA.exercise.TK_ArrayList;


import java.util.Arrays;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(10);
        listInteger.add(1);
        listInteger.add(0);
        listInteger.add(0, 30);
        System.out.println(listInteger.remove(1));
        //  listInteger.clear();
        System.out.println(listInteger);
        System.out.println(listInteger.size());
        System.out.println(listInteger.clone());
        System.out.println(listInteger.indexOf(1));
        if (listInteger.contains(0)) {
            System.out.println("In the array");
        } else {
            System.out.println("Not in the array");
        }
    }
}
