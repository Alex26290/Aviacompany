package org.aviacompany;

import org.aviacompany.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class MainController {

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private UsersDaoImpl userDaoImpl;

    @Autowired
    private FlightDaoImpl flightDao;

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userDaoImpl.getAll();
        model.addAttribute("users", users);
        return "redirect:users-rest/users";
    }

    @GetMapping("/userTest")
    public User getUser() {
        return userDaoImpl.getUserByEmail("al@gmail.com");
    }

    @RequestMapping(value = "/window", method = RequestMethod.GET)
    public ModelAndView window() {
        return new ModelAndView("window");
    }

    @RequestMapping("/hello")
    public String showForm(@ModelAttribute("users") ArrayList<String> users,
                           BindingResult result, Model model) {
//        for (String s : users) {
//            System.out.println(s);
//        }
        List<String> professions = new ArrayList<>();
        professions.add("Programmer");
        professions.add("Tester");
        professions.add("Vlogger");
        model.addAttribute("professions", professions);
        return "hello";
    }

    @GetMapping("/model")

    public String showForm2(Model model) {
        Specialist specialist = new Specialist();
        model.addAttribute("specialist", specialist);
        List<String> roles = new ArrayList<>();
        roles.add("Programmer");
        roles.add("Tester");
        roles.add("Vlogger");
        model.addAttribute("roles", roles);
        List<String> names = new ArrayList<>();
        names.add("Alex");
        names.add("Kris");
        names.add("Max");
        names.add("Dima");
        names.add("Alex");
        names.add("Kris");
        names.add("Max");
        names.add("Dima");
        names.add("Alex");
        names.add("Kris");
        names.add("Max");
        names.add("Dima");
        model.addAttribute("names", names);
        return "model";
    }

//не считывает данные пользователя из формы
//    @GetMapping(value = "/user-create")
//    public String createUserTest(User user){
//        return "createUser";
//    }
//
//    @PostMapping(value = "/user-create")
//    public String submit2(@ModelAttribute("user") User user,
//                          BindingResult result, ModelMap model) {
//        System.out.println("В методе добавления пользователя");
//        if (result.hasErrors()) {
//            return "error";
//        }
//        model.addAttribute("login", user.getLogin());
//        model.addAttribute("password", user.getPassword());
//        model.addAttribute("email", user.getEmail());
//        System.out.println("логин = " + user.getLogin());
//        System.out.println("пароль = " + user.getPassword());
//        System.out.println("почта = " + user.getEmail());
//        userDaoImpl.add(user);
//        return "redirect:users";
//    }
//тоже рабочий метод, аналогичный следующему
//    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
//    public ModelAndView showForm2() {
//        return new ModelAndView("sign_up", "user", new User());
//    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String createUserTest2(User user) {
        return "sign_up";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user") User user,
                         BindingResult result, ModelMap model) {
        System.out.println("В методе добавления пользователя");
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("login", user.getEmail());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("email", user.getEmail());
        user.setLogin(user.getEmail());
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_USER);
        user.setRole(Role.ROLE_USER);
        userDaoImpl.add(user);
        return "redirect:users-rest/users";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String registrate() {
        return "registration";
    }

    @RequestMapping(value = "/flights_search", method = RequestMethod.GET )
    public String flights_search(@ModelAttribute("flight") Flight flight, BindingResult result, ModelMap map) {
//        System.out.println(flight.getDepartureCity());
//        System.out.println(flight.getArrivalCity());
        List<Flight> flights = flightDao.findFlightsByCitiesAndDates(flight);
        System.out.println(result.getModel().containsKey("Москва"));
        System.out.println(result.getModel().containsKey("departure_city"));
        System.out.println(result.getModel().containsValue("Москва"));
        System.out.println(result.getModel().containsValue("departure_city"));
        System.out.println(map.getAttribute("departure_city"));
        System.out.println(map.getAttribute("arrival_city"));
        return "flights_search";
    }

    @RequestMapping(value = "/flights", method = RequestMethod.POST)
    public ModelAndView fly(@ModelAttribute("flight") Flight flight, Model model) throws ParseException {
        model.addAttribute("flight", flight);
        System.out.println(flight);
        System.out.println(flight.getArrival_date().toString());
        System.out.println("\n");

        java.sql.Date sqlDate = new java.sql.Date(flight.getArrival_date().getTime());
        System.out.printf("sqlDate = " + sqlDate);
        System.out.println(flight.getArrival_date());
        System.out.println(flight.getDeparture_date());
        List<Flight> flights = flightDao.findFlightsByCitiesAndDates(flight);
        ModelAndView map = new ModelAndView("schedule");
        map.addObject("flights", flights);
        return map;
    }

    //Тестовое отображение данных
    @RequestMapping(value={"/test"}, method = RequestMethod.GET)
    public ModelAndView listEmployee(){
        User user = new User();
        user.setId(5);
        user.setLogin("Sasha");
        user.setPassword("Gubaydulin");
        user.setRole(Role.ROLE_USER);
        user.setEmail("1212@asdad.com");
        User user2 = new User();
        user2.setId(5);
        user2.setLogin("Sasha");
        user2.setPassword("Nechipurovich");
        user2.setRole(Role.ROLE_USER);
        user2.setEmail("1212@asdad.com");
        User user3 = new User();
        user3.setId(5);
        user3.setLogin("login");
        user3.setPassword("password");
        user3.setRole(Role.ROLE_USER);
        user3.setEmail("1212@asdad.com");
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        list.add(user3);
        ModelAndView map = new ModelAndView("test");
        map.addObject("user", user);
        map.addObject("list", list);
        return map;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "list";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String reg(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "Error";
        }
        user.setLogin(user.getEmail());
        user.setRole(Role.ROLE_USER);
        model.addAttribute("password", user.getPassword());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        model.addAttribute("email", user.getEmail());
        userDaoImpl.add(user);
        return "main";

    }

//    @GetMapping("/flights")
//    public List<Flight> getFlight() {
//        return flightDao.getAll();
//    }
}
