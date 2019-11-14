package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/echo")
public class WarmingExercise {

    @GetMapping(value = "/{word}")
    public PostBody get(@PathVariable("word") String variable) {
        return new PostBody(variable);
    }

    @GetMapping
    public String getParameter(@RequestParam(value = "word") String word) {
        return word;
    }

    @PostMapping
    public String post(@RequestBody PostBody body) {
        return body.getWord();
    }
}
