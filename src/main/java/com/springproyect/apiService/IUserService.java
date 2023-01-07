package com.springproyect.apiService;

import com.springproyect.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {

    List<User> getUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    User findUser(Long id);
}
