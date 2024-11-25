package com.imran.springboot.myFirstWebApp.TODO;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;



// @Controller
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
    @RequestMapping("add-todo")
    public String addTodos(ModelMap model){
        String username = getLoggedInUsername(model);
        Todo todo = new Todo(0, username, "Defaut desc", null, false);
        model.addAttribute("todo",todo);
        return "add-todo";
    }
    @PostMapping("/add-todo")
    public String afterAdding(@Valid Todo todo, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            System.out.println("Validation Errors: " + result.getAllErrors());
            return "add-todo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoservice.addTodo(todo.getDescription(), todo.getUsername(),todo.getTargetDate(), todo.getIsDone());
        return "redirect:/List-todos"; // Redirect after successful submission
    }
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        //  id = (int) model.get("id");
        todoservice.deleteTodo(id);
        return "redirect:/List-todos";
    }
    @GetMapping("update-todo")
    public String Updatetodo(@RequestParam int id,ModelMap model) {
        Todo todo = todoservice.FindById(id);
        model.addAttribute("todo",todo);
        return "add-todo";
    }
    @PostMapping("update-todo")
    public String Updating(@Valid Todo todo, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            System.out.println("Validation Errors: " + result.getAllErrors());
            return "add-todo";
        }
        String username = (String) model.get("name");
        todoservice.updateTodo(todo);
        return "redirect:/List-todos"; // Redirect after successful submission
    }
    private String getLoggedInUsername(ModelMap model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
