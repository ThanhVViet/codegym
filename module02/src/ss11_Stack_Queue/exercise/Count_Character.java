package ss11_Stack_Queue.exercise;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Count_Character {
    public static void main(String[] args) {
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
    //    int count = 1;
        System.out.println("Hãy nhập vào 1 chuỗi: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toUpperCase();
        char [] arr = str.toCharArray();

        // duyệt qua các kí tự và tăng dần sự xuất hiện của nó trong map
        //  Với mỗi từ trong mảng arr,
        //  chúng ta sử dụng treeMap.put(chars, wordCountMap.getOrDefault(word, 0) + 1)
        //  để thêm từ vào TreeMap và tăng số lần xuất hiện của từ đó. Nếu từ đã tồn tại trong TreeMap,
        //  ta lấy giá trị hiện tại và tăng thêm 1, nếu không ta gán giá trị 0 và tăng thêm 1.

        for (char chars : arr ){
            treeMap.put(chars, treeMap.getOrDefault(chars, 0) + 1  );
        }
        // entrySet lấy từng cặp key và value

        System.out.println("Số từ xuất hiện trong chuỗi:");
        for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
            Character word = entry.getKey();
            int count = entry.getValue();
            System.out.println(word + ": " + count);
        }

    }
}
