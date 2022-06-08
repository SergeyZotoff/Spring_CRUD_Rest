package ru.sergey.springboot.springboot.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.sergey.springboot.springboot.entities.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> allUser();
    User addUser(User user);
    User getUserById(long id);
    User updateUser(User user);
    void removeUserById(long id);
    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
