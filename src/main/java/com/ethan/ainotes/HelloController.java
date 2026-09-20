package com.ethan.ainotes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "AI Notes server is running";
    }
    @GetMapping("/note")
    public Note note() {
       Note note = new  Note(1, "CS Exam", "Study recursion, linked lists, and Big O");
       return note;
    }
}
