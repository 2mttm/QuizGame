package io.twometrue.quizgame.controller;

import io.twometrue.quizgame.entity.Word;
import io.twometrue.quizgame.service.WordService;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final WordService wordService;

    public RestController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/random")
    public Word getRandomWord(){
        return wordService.getRandom();
    }
}
