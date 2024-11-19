package com.imran.springboot.myFirstWebApp.TODO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todocount=0;
    private static int datecount=0;
    static {
        todos.add(new Todo(++todocount,"Imran","Learnaws",LocalDate.now().plusYears(++datecount),false));
        todos.add(new Todo(++todocount,"Imran","Learn Devops",LocalDate.now().plusYears(++datecount),false));
        todos.add(new Todo(++todocount,"Imran","Learn FullStackDevelopment",LocalDate.now().plusYears(++datecount),false));
    }
    public List<Todo> findByUsername(String username){
        return todos;
    }
    public void addTodo(String description,String username,boolean date) {
        todos.add(new Todo(++todocount,username,description,LocalDate.now().plusYears(++datecount),date));
    }
    public void deleteTodo(int id) {
        todos.removeIf(todo -> todo.getId()==id);
    }
}
