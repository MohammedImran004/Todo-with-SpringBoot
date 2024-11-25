package com.imran.springboot.myFirstWebApp.TODO;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodoRepositary extends JpaRepository<Todo, Integer> {
    public List<Todo> findByUsername(String username);
}
