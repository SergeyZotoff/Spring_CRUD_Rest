package ru.sergey.springboot.springboot.dao;

import ru.sergey.springboot.springboot.entities.Role;


import java.util.List;

public interface RoleDAO {

    List<Role> allRole();
    Role findRoleById(Long id);
    void addRole(Role role);
}