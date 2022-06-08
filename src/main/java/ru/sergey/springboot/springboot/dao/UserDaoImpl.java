package ru.sergey.springboot.springboot.dao;

import org.springframework.stereotype.Repository;
import ru.sergey.springboot.springboot.entities.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext()
    EntityManager entityManager;
    

    @Override
    public List<User> allUser() {
        return entityManager.createQuery(
                "from User ", User.class).getResultList();
    }

    @Override
    public User addUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User getUserById(long id) {
       return entityManager.find(User.class, id);
    }

    @Override
    public User updateUser(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public void removeUserById(long id) {
        User user = getUserById(id);
        if (user != null) {
            entityManager.remove(user);
        } else {
            System.out.println("There is no such user");
        }
    }

    @Override
    public User getUserByNickname(String email) {
        Query q = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        q.setParameter("email",email);
        User user = (User) q.getSingleResult();
        return user;
    }

}
