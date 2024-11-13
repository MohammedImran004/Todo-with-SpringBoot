package com.imran.springboot.myFirstWebApp.TODO;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoservice;
    
    public TodoController(TodoService todoservice) {
        this.todoservice = todoservice;
    }

    @RequestMapping("List-todos")
    public String TodoHandler(ModelMap model){
        List<Todo> todos = todoservice.findByUsername("Imran");
        model.addAttribute("todos",todos);
        return "List-todos";
    }
}
