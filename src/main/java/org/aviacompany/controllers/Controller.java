package org.aviacompany.controllers;

import org.aviacompany.FlightDaoImpl;
import org.aviacompany.UsersDaoImpl;
import org.aviacompany.model.Flight;
import org.aviacompany.model.User;
import org.aviacompany.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class Controller {

    @Autowired
    private UsersDaoImpl usersDao;

    @Autowired
    private FlightDaoImpl flightDaoImpl;

    @RequestMapping(value = "/{id}", produces = "application/json", method = RequestMethod.GET)
    public User getUserJSON(@PathVariable int id) {
        User user = usersDao.getUserById(id);
        return user;
    }
    @RequestMapping(value = "/xml/{id}", produces = "application/xml", method = RequestMethod.GET)
    public User getUserXML(@PathVariable int id) {
        User user = usersDao.getUserById(id);
        return user;
    }

    @GetMapping(value ="/users", produces = "application/json")
    public List<User> getUsers2() {
        List<User> users = usersDao.getAll();
        return users;
    }
    @GetMapping(value ="/usersXml", produces = {MediaType.APPLICATION_XML_VALUE})
    public Users getUsersInXml2() {
        List<User> usersList = usersDao.getAll();
        Users users = new Users();
        users.setUsers(usersList);
        return users;
    }
    @GetMapping(value ="/flights", produces = "application/json")
    public List<Flight> getFlights() {
        List<Flight> users = flightDaoImpl.getAll();
        return users;
    }

}

