package ss17_IO_Binary_File_Serialization.exercise;


import java.util.*;

public class ProductServiceImpl implements ProductService {

  //  private static String PATH = "/Users/thanhviet/Documents/codegym/module2/src/ss17_IO_Binary_File_Serialization/exercise/product.txt";
    private static Set<Product> productSet = new LinkedHashSet<>();

    private ReadAndWrite file = new ReadAndWrite();

//    static {
//        productSet.add(new Product("P3","Viet","Na",200,"None"));
//    }


    @Override
    public void create(Product product) {
        productSet.add(product);
       file.write(productSet);
        // Collections.singleton(product)
    }

    @Override
    public List<Product> findAll() {
        return productSet.stream().toList();
    }

    @Override
    public Optional<Product> get(String id) {
        return productSet.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

}
