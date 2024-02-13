package io.twometrue.quizgame.config;

import io.twometrue.quizgame.entity.Word;
import io.twometrue.quizgame.repository.WordRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class WordsInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final WordRepository wordRepository;

    public WordsInitializer(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        String[] italians = {"fare", "dire", "leggere"};
        String[] italiansPast = {"fatto", "detto", "letto"};
        String[] russians = {"делать", "говорить", "читать"};

        for (int i = 0; i < italians.length; i++){
            assureWord(italians[i], italiansPast[i], russians[i]);
        }
    }
    private void assureWord(String italian, String italianPast, String russian){
        if (wordRepository.findByItalian(italian) == null) {
            Word word = new Word(italian, italianPast, russian);
            wordRepository.save(word);
        }
    }
}
