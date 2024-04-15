package Exam.services;

import java.util.List;

public interface BaseFunction <T>{
    void create(T t);
    void delete(int code);

    void search(int code);
    List<T> findAll();

}
