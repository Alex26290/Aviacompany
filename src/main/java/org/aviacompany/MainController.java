package org.aviacompany;

import org.aviacompany.model.*;
import org.aviacompany.utils.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class MainController {

    @InitBinder
    public final void initBinderFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private UsersDaoImpl userDaoImpl;

    @Autowired
    private FlightDaoImpl flightDao;

    @Autowired
    private TicketDaoImpl ticketDao;

    @Autowired
    private FlightData flightData;

    @Autowired
    private UserValidator validator;


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
        validator.validate(user, result);
        if (result.hasErrors()) {
            return "sign_up";
        }
        model.addAttribute("login", user.getEmail());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("email", user.getEmail());
        user.setLogin(user.getEmail());
        System.out.println(user.getRole());
        user.setRole(user.getRole());
        userDaoImpl.add(user);
        return "redirect:users-rest/users";
    }

    @RequestMapping(value = "/registerFlight", method = RequestMethod.POST)
    public String regFlight(@ModelAttribute("flight") Flight flight,
                            BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        flightDao.add(flight);
        return "admin";
    }

    @RequestMapping(value = "/testFlight", method = RequestMethod.POST)
    public String testFlight(@ModelAttribute("flight") Flight flight,
                            BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        System.out.println(flight);
        return "lala";
    }

    @RequestMapping(value = "/testFlight", method = RequestMethod.GET)
    public String testFlight() {
        System.out.println(flightData.getId());
        return "testFlight";
    }


    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String registrate() {
        return "registration";
    }


    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal().toString());
        String email = authentication.getName();
        System.out.println(authentication.getCredentials());
        System.out.println(authentication.getDetails());
        User u = (User) authentication.getPrincipal();
        System.out.println("User login = " + u.getLogin());
        System.out.println("authentication.getName() = " + email);
        User user = userDaoImpl.getUserByEmail(email);
        return "registration";
    }


    @RequestMapping(value = "/flights_search", method = RequestMethod.GET)
    public String flights_search(@ModelAttribute("flight") Flight flight, BindingResult result, ModelMap map) {
        List<Flight> flights = flightDao.findFlightsByCitiesAndDates(flight);
        return "flights_search";
    }

    @RequestMapping(value = "/flights", method = RequestMethod.POST)
    public ModelAndView fly(@ModelAttribute("flight") Flight flight, Model model) {
        model.addAttribute("flight", flight);
        List<Flight> flights = flightDao.findFlightsByCitiesAndDates(flight);
        ModelAndView map = new ModelAndView("schedule");
        map.addObject("flights", flights);
        return map;
    }

    //Тестовое отображение данных
//    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
//    public ModelAndView listEmployee() {
//        User user = new User();
//        user.setId(5);
//        user.setLogin("Sasha");
//        user.setPassword("Gubaydulin");
//        user.setRole(Role.ROLE_USER);
//        user.setEmail("1212@asdad.com");
//        User user2 = new User();
//        user2.setId(5);
//        user2.setLogin("Sasha");
//        user2.setPassword("Nechipurovich");
//        user2.setRole(Role.ROLE_USER);
//        user2.setEmail("1212@asdad.com");
//        User user3 = new User();
//        user3.setId(5);
//        user3.setLogin("login");
//        user3.setPassword("password");
//        user3.setRole(Role.ROLE_USER);
//        user3.setEmail("1212@asdad.com");
//        ArrayList<User> list = new ArrayList<>();
//        list.add(user);
//        list.add(user2);
//        list.add(user3);
//        ModelAndView map = new ModelAndView("test");
//        map.addObject("user", user);
//        map.addObject("list", list);
//        return map;
//    }
//    @RequestMapping(value = {"/testValue"}, method = RequestMethod.POST)
//    public String testValue(@ModelAttribute("login") String login, BindingResult result, ModelMap model) {
//        System.out.println("login = " + login);
//        return "/test";
//    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "list";
    }


    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String reg(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {
        validator.validate(user, result);
        if (result.hasErrors()) {
            return "reg";
        }
        user.setLogin(user.getEmail());
        user.setRole(Role.ROLE_USER);
        model.addAttribute("password", user.getPassword());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        model.addAttribute("email", user.getEmail());
        userDaoImpl.add(user);
        return "login";

    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage() {
        return "admin";
    }


    @RequestMapping(value = "/ticket_buying", method = RequestMethod.GET)
    public String ticketBuying(@ModelAttribute("flight") Flight flight) {
        return "ticket_buying";
    }

    @RequestMapping(value = "/ticket_buying/{flightId}", method = RequestMethod.GET)
    public ModelAndView ticketBuying(@PathVariable int flightId) {
        Flight flight = flightDao.getById(flightId);
        ModelAndView map = new ModelAndView("ticket_buying");
        map.addObject("flight", flight);
        return map;
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public ModelAndView tickets(@ModelAttribute("flight_id") int flight_id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = (User) authentication.getPrincipal();
        Flight flight = flightDao.getById(flight_id);
        Ticket ticket = new Ticket(flight.getFlight_price(),u.getId(),flight.getFlight_number(), flight.getDeparture_city(), flight.getArrival_city(), flight.getDeparture_airport(), flight.getArrival_airport(), flight.getDeparture_date(), flight.getArrival_date(), flight.getDeparture_time(), flight.getArrival_time());
        User user = userDaoImpl.getUserById(ticket.getUser_id());
        int newUserCash = u.getMoney()-ticket.getTicket_price();
        user.setMoney(newUserCash);
        boolean isEnoughMoney = userDaoImpl.updateUsersCash(user);
        String message = "";
        if(isEnoughMoney) {
            ticketDao.add(ticket);
            message = "Билет был успешно куплен";
        } else{
            message = "Недостаточно денег для покупки билета";
        }
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("message", message);
        ModelAndView map = new ModelAndView("tickets",modelMap);
        List<Ticket> ticketsOfUser = ticketDao.getTicketsByUser(user.getId());
        for(Ticket t : ticketsOfUser){
            System.out.println("В цикле");
            System.out.println(t);
        }
        map.addObject("tickets", ticketsOfUser);
        return map;
    }


    @RequestMapping(value = "/lk", method = RequestMethod.GET)
    public String lk(ModelMap model) {

        return "lk";
    }

//    @RequestMapping(value = "/testMessage", method = RequestMethod.GET)
//    public ModelAndView test(ModelMap map) {
//        map.addAttribute("message", "Password changed successfully");
//       return new ModelAndView("testMessage", map);
//    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public ModelAndView test2(ModelMap map) {
        return new ModelAndView("test2", map);
    }
}
