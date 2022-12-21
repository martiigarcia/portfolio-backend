package com.springproyect.service;

import com.springproyect.apiService.IUserService;
import com.springproyect.model.User;
import com.springproyect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = findUser(id);
        userRepository.delete(user);
    }

    @Override
    public User findUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return null;
    }
}
