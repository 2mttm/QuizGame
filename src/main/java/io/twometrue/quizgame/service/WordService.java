package io.twometrue.quizgame.service;

import io.twometrue.quizgame.config.WordsInitializer;
import io.twometrue.quizgame.entity.Word;
import io.twometrue.quizgame.repository.WordRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class WordService {
    private final WordRepository wordRepository;
    public WordService(WordRepository wordRepository){
        this.wordRepository = wordRepository;
        System.out.println(findAll());
    }
    public List<Word> findAll(){
        return wordRepository.findAll();
    }
    public Word getRandom(){
        long qty = wordRepository.count();
        Optional<Word> word = wordRepository.findById((long) (Math.random() * qty));
        return word.get();
    }
}
