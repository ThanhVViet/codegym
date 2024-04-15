package ss12_Java_Collection_FrameWork.exemple;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapStudy {
    public static void main(String[] args) {
        Map<Integer, String> stringMap = new LinkedHashMap<>();

        stringMap.put(1, "Nguyễn Văn A");
        stringMap.put(2, "Nguyễn Văn B");
        stringMap.put(2, "Nguyễn Văn X");
        stringMap.put(null, "Nguyễn Văn C");
        stringMap.put(null, "Nguyễn Văn D");
        stringMap.put(null, "Nguyễn Văn E");
        stringMap.put(null, "Nguyễn Văn F");
        stringMap.put(null, "Nguyễn Văn G");

        Set<Integer> integerSet = stringMap.keySet();
        for (Integer key : integerSet) {
            System.out.println(stringMap.get(key));
        }
    }
}
