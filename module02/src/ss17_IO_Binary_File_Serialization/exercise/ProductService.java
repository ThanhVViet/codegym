package ss17_IO_Binary_File_Serialization.exercise;

import java.util.List;
import java.util.Optional;

public interface ProductService extends BaseFunction<Product> {
    void create(Product product);

    List<Product> findAll();

    Optional<Product> get(String id);


}
