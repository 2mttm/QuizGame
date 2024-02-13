package io.twometrue.quizgame.repository;

import io.twometrue.quizgame.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
    Word findByItalian(String italian);
}