package ss10_DSA.exercise.TK_LinkedList;


public class MyLinkedListTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyLinkedList<Integer> ll = new MyLinkedList<>(10);
        ll.addFirst(11);
        ll.addFirst(20);
        ll.addFirst(12);
        ll.addFirst(22);
//        ll.add(0, 30);

        ll.addLast(55);

        //  ll.remove(1);

        if (ll.remove1(12)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

//        ll.clone();

//        if(ll.add1(2)){
//            System.out.println("OK");
//        }

//
//        if(ll.contains(10)){
//            System.out.println("Yes");
//        }else {
//            System.out.println("No");
//        }

        //    System.out.println( ll.get(0));
        //    System.out.println(ll.indexOf(12));
        ll.printList();


        //   System.out.println(ll.size());

//        System.out.println(ll.size());
//
//        System.out.println(ll.getFirst());
//        System.out.println(ll.getLast());
//        ll.clear();

    }
}
