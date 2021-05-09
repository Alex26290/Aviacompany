package org.aviacompany;

import org.aviacompany.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ComponentScan("org.aviacompany")
public class UsersDaoImpl implements Dao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<User> getAll() {
        List<User> users = getSession().createQuery("From User ", User.class).list();
        System.out.println(users.size());
        for (User user : users) {
            System.out.println(user.getLogin() + " " + user.getPassword());
        }
        return users;
    }

    @Override
    public User getUser(String login) {
        return null;
    }

    public User getUserByEmail(String email) {
        System.out.println("В методе поиска пользователя");
        try {
            List<User> users = getSession().createQuery("From User where email like " + "'" + email + "'", User.class)
                    .list();
            if (!users.isEmpty()) {
                User user = users.get(0);
                if (user != null) {
                    System.out.println("User найден, логин =" + user.getLogin());
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        getSession().save(user);
    }


    public User getUserById(int id) {
        User user = null;
        try {
            List<User> users = getSession().createQuery("From User where id = " + id, User.class).list();
            System.out.println(" размер списка пользователей = " + users.size());
            if (users != null && users.size() != 0) {
                user = users.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
