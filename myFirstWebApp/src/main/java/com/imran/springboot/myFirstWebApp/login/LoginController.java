package com.imran.springboot.myFirstWebApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
    private AuthenticationController authenticate;

    public LoginController(AuthenticationController authenticate) {
        super();
        this.authenticate = authenticate;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "Login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String welcome(@RequestParam String name, @RequestParam String password, ModelMap model) {
        if (authenticate.authenticate(name, password)) {
            model.put("name", name);
            model.put("pass", password);
            return "Welcome";
        } else if (!authenticate.authenticate(name, password)) {
            model.put("errorMessage", "Invalid username or password");
            return "Login";
        }
        return "Login";
    }
}
