package Exam.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile<T> {
    public List<String> readFile(String filePath) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



    public void write(String path, List<T> list, boolean isAppend) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, isAppend));
            for (T obj : list) {
                writer.write(obj.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
