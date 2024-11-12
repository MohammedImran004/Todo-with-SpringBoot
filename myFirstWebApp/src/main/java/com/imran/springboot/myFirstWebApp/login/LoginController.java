package com.imran.springboot.myFirstWebApp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("login")
    public String Login(@RequestParam String namee, ModelMap model){
        model.put("name",namee);
        logger.debug("debug level");
        logger.info("Thi is Printed In Info Level");
        System.out.println("Hello "+namee);
        return "Login";
    }
}
