package org.aviacompany;

import org.aviacompany.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Dao {
    List<User> getAll();
    User getUser(String login);
    void add(User user);
}
