package com.springproyect.apiService;

import com.springproyect.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {

    public List<User> getUsers();

    public void saveUser(User user);

    public void deleteUser(Long id);

    public User findUser(Long id);
}
