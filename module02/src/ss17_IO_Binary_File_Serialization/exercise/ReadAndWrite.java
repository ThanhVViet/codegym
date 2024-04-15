package ss17_IO_Binary_File_Serialization.exercise;


import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class ReadAndWrite {

    //    public static void writeToFile(String PATH) {
//        try {
//            FileOutputStream fileOutputStream =
//                    new FileOutputStream(PATH,false);
//            ObjectOutputStream objectOutputStream =
//                    new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(products);
//            objectOutputStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Set<Product> readDataFromFile(String PATH) {
//        Set<Product> products =  new LinkedHashSet<>();
//        try {
//            FileInputStream fileInputStream =
//                    new FileInputStream(PATH);
//            ObjectInputStream objectInputStream =
//                    new ObjectInputStream(fileInputStream);
//            products = (Set<Product>) objectInputStream.readObject();
//            System.out.println(products);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return products;
//    }
    private static String PATH = "/Users/thanhviet/Documents/codegym/module2/src/ss17_IO_Binary_File_Serialization/exercise/product.txt";

    public void write(Set<Product> productSet) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(PATH));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(productSet);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }


    public Set<Product> read() {
        Set<Product> studentList = new LinkedHashSet<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(PATH));
            ois = new ObjectInputStream(fis);
            studentList = (Set<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return studentList;
    }


    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
