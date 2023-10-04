package codegym.vn.repository;

import codegym.vn.entity.Nasa;

import java.util.List;

public interface Repository {
    List<Nasa> findAll();

    boolean create(Nasa nasa);

}
