package com.codegym.webservice.repository;

import com.codegym.webservice.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRepository extends JpaRepository<ClassRoom, Integer> {
}
