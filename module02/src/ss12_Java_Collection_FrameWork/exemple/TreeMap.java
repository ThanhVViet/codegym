package ss12_Java_Collection_FrameWork.exemple;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class TreeMap {
    public static void main(String[] args) {
        Map<Integer, String> stringMap = new java.util.TreeMap<>(Collections.reverseOrder());

        stringMap.put(1, "Nguyễn Văn A");
        stringMap.put(2, "Nguyễn Văn B");
        stringMap.put(-50, "Nguyễn Văn X");
        stringMap.put(80, "Nguyễn Văn X");
        stringMap.put(80, "Nguyễn Văn 80");
        stringMap.put(100, "Nguyễn Văn X");
        stringMap.put(-20, "Nguyễn Văn X");
        stringMap.put(60, "Nguyễn Văn X");
        stringMap.put(90, "Nguyễn Văn X");
        stringMap.put(0, "Nguyễn Văn X");

        Set<Integer> integerSet = stringMap.keySet();
        for (Integer key : integerSet) {
            System.out.println(key + " - " + stringMap.get(key));
        }
    }
}
