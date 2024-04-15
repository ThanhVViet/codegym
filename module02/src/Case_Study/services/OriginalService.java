package Case_Study.services;

import java.util.List;

public interface OriginalService<T> {
    void create(T t);

    void edit(T t);

    List<T> findAll();
}
