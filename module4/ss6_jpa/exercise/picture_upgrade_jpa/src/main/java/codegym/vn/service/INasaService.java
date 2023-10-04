package codegym.vn.service;

import codegym.vn.entity.Nasa;

import java.util.List;

public interface INasaService {
    List<Nasa> findAll();

    boolean create(Nasa nasa);
}
