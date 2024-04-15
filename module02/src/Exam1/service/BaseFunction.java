package Exam1.service;

import java.util.List;

public interface BaseFunction <T>{
    void create(T t);

    void edit(T t);

    List<T> findAll();

    void find(String t);
    void findByName(String t);
    void delete(String phoneNumber);

}
