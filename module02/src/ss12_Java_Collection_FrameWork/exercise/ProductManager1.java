package ss12_Java_Collection_FrameWork.exercise;


import java.util.*;
import java.util.Comparator;

public class ProductManager1 {
    private ArrayList<Product1> products = new ArrayList<>();

    void addProduct(Product1 p){
       products.add(p);
    }

    public static int nhap() {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        int n = 0;
        while (!check) {
            System.out.print(" ");
            try {
                n = input.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Ban phai nhap so! hay nhap lai...");
                input.nextLine();
            }
        }
        return (n);
    }

    void display(){
        if(products.isEmpty()){
            System.out.println("Hãy thêm sản phẩm !!!");
        }
        else {
            for(Product1 product1: products){
                System.out.println(product1);
            }
        }
    }
    List<Product1> findAll(){
        if(products.isEmpty()){
            System.out.println("Hãy thêm sản phẩm");
        }
        else {
            System.out.println("Danh sách sản phẩm: ");
        }
        return products;
    }
    void update(Product1 product1){
        for (int i = 0; i < products.size() ; i++) {
            if(products.get(i).getId() == product1.getId()){
                products.set(i, product1);
                break;
            }
        }
        products.set(products.indexOf(product1),product1);
    }

    void delete(int id){
        for (int i = 0; i < products.size() ; i++) {
            if(products.get(i).getId() == id){
                products.remove(i);
                break;
            }
            else {
                System.out.println("Sản phẩm muốn xoá không tồn tại !!!!");
            }
        }

      //  products.removeIf(e -> e.getId() == id);

    }

    List<Product1> searchByName(String name){
        List result = new ArrayList<Product1>();

        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getName().equals(name)){
               result.add(products.get(i));
            }
            else {
                System.out.println("Not found");
            }

        }
        return result;
    }

    void sort(boolean isASC){
        Collections.sort(products, (o1, o2) -> isASC ? (int)(o1.getPrice() - o2.getPrice()) : (int)(o2.getPrice() - o1.getPrice()));
    }
}
