package ru.animesosok.shift_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.animesosok.shift_test.entity.DigitEntity;

import java.util.List;

@Repository
public interface DigitRepository extends JpaRepository<DigitEntity, Long> {
    @Query("SELECT d FROM DigitEntity d WHERE d.start = (SELECT MIN(d2.start) FROM DigitEntity d2)  " +
            "AND d.end = (SELECT MAX(d3.end) FROM DigitEntity d3 WHERE d3.start = (SELECT MIN(d4.start) FROM DigitEntity d4))")
    DigitEntity minInterval();
}
