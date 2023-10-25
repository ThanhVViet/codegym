package com.example.validate_register_form.service;

import com.example.validate_register_form.model.User;
import com.example.validate_register_form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private IUserRepository iUserRepository;

    @Autowired
    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public void save(User user){
        iUserRepository.save(user);
    }

}
