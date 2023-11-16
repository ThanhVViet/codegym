package com.codegym.webservice.service;

import com.codegym.webservice.model.ClassRoom;

import java.util.List;

public interface IClassService {
    List<ClassRoom> findAll();
}
