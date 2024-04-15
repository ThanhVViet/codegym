package ss17_IO_Binary_File_Serialization.exercise;

import java.util.List;
import java.util.Optional;

public interface BaseFunction <T>{
    void create(T t);

    List<T> findAll();

    Optional<T> get(String id);
}
