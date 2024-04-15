package ss16_IO_textfile.exercise;

import java.io.*;


public class Copy {
    public static void main(String[] args) {
        String pathFileInput = "/Users/thanhviet/Text/source_file.txt";
        String pathFileOutput = "/Users/thanhviet/Text/target_file.txt";

        try {
            CopyData(pathFileInput, pathFileOutput);
            CountCharacter(pathFileOutput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void CopyData(String pathFileInput, String pathFileOutput) throws IOException {
        InputStream ip = new FileInputStream(pathFileInput);
        OutputStream op = new FileOutputStream(pathFileOutput);

        int length;

        byte[] buffer = new byte[1024];

        // copy the file content in bytes
        while ((length = ip.read(buffer)) > 0) {
            op.write(buffer, 0, length);
        }
        System.out.println("File is copied successful!");

        ip.close();
        op.close();

    }

    public static void CountCharacter(String path) throws IOException {
        File file = new File(path);
        if (file.canRead()) {
            file.setReadable(true);
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        String data = "";
        while ((line = bufferedReader.readLine()) != null) {
            data += line;
        }
        bufferedReader.close();

        int stringLengthWithoutSpaces = data.replace(" ", "").length();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        bufferedWriter.write("\nTotal character: " + stringLengthWithoutSpaces);
        bufferedWriter.close();

    }
}

