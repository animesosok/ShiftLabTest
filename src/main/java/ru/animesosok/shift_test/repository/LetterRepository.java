package ru.animesosok.shift_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.animesosok.shift_test.entity.LetterEntity;

@Repository
public interface LetterRepository extends JpaRepository <LetterEntity, Long> {
    @Query("SELECT l FROM LetterEntity l WHERE l.start = (SELECT MIN(l2.start) FROM LetterEntity l2)  " +
            "AND l.end = (SELECT MAX(l3.end) FROM LetterEntity l3 WHERE l3.start = (SELECT MIN(l4.start) FROM LetterEntity l4))")
    LetterEntity minInterval();
}
