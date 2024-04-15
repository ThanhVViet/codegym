package ss16_IO_textfile.practice.write;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("/Users/thanhviet/Text/numbers1.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("/Users/thanhviet/Text/result.txt", maxValue);
    }
}
