package ru.sergey.springboot.springboot.service;

import ru.sergey.springboot.springboot.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> allRole();
    Role findRoleById(Long id);
    void addRole(Role role);
}
