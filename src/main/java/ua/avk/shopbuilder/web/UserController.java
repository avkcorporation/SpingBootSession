package ua.avk.shopbuilder.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.avk.shopbuilder.dao.RoleRepository;
import ua.avk.shopbuilder.entity.User;
import ua.avk.shopbuilder.service.SecurityService;
import ua.avk.shopbuilder.service.UserService;
import ua.avk.shopbuilder.validator.UserValidator;

@Controller
public class UserController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            logger.debug("Registration FALSE");
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        logger.debug("Registration SUSSES");

        return "redirect:/page3";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/page3"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        logger.debug("Page-3");
        return "page3";
    }


    @RequestMapping(value = {"/page1"}, method = RequestMethod.GET)
    public String page1(Model model) {
        logger.debug("Page-1");
        return "/page1";
    }


    @RequestMapping(value = {"/page2"}, method = RequestMethod.GET)
    public String page2(Model model) {
        logger.debug("Page-2");
        return "/admin/page2";
    }

    @RequestMapping(value = {"/page4"}, method = RequestMethod.GET)
    public String page4(Model model) {
        logger.debug("Page-4");
        return "/page4";
    }
}
