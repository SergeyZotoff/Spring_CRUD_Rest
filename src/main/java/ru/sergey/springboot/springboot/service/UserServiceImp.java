package ru.sergey.springboot.springboot.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sergey.springboot.springboot.dao.UserDAO;
import ru.sergey.springboot.springboot.entities.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> allUser() {
        return userDAO.allUser();
    }

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDAO.addUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public User updateUser(User user) {
        String oldPassword = getUserById(user.getId()).getPassword();
        String newPassword = user.getPassword();
        if(!oldPassword.equals(newPassword)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userDAO.updateUser(user);

    }

    @Override
    public void removeUserById(long id) {
        userDAO.removeUserById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userDAO.getUserByNickname(email);
        if(user == null) {
            throw new UsernameNotFoundException("User with name" + email);
        }
        return user;
    }
}
