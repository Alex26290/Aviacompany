package org.aviacompany;

import org.aviacompany.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@ComponentScan("org.aviacompany")
public class UsersDaoImpl {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Session getSession() {
        return sessionFactory.openSession();
    }


    public List<User> getAll() {
        List<User> users = getSession().createQuery("From User ", User.class).list();
        System.out.println(users.size());
        for (User user : users) {
            System.out.println(user.getLogin() + " " + user.getPassword());
        }
        return users;
    }


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


    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        getSession().save(user);
    }


    public User getUserById(long id) {
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

    //    @Transactional
    public void updateUsersCash(long user_id, int newUserCash) {
        System.out.println("Обновляем деньги у пользователя");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
//            getSession().update();
            getSession().createQuery("Update User set money = " + newUserCash + " Where id = " + user_id).executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        transaction.commit();
        session.close();
    }

    public boolean updateUsersCash(User user1) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        try {
            System.out.println("Обновляем данные пользователя");
            System.out.println("Денег у пользователя -  " + user1.getMoney());
            session.saveOrUpdate(user1);
            if (user1.getMoney() < 0) {
                tr.rollback();
                session.close();
                return false;
            } else {
                tr.commit();
                session.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            return false;
        }
    }
}
