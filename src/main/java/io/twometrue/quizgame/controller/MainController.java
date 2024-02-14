package io.twometrue.quizgame.controller;

import io.twometrue.quizgame.entity.Word;
import io.twometrue.quizgame.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    private final WordService wordService;

    public MainController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/")
    public String getMain(Model model){
        model.addAttribute("word", wordService.getRandom());
        return "home";
    }

}
