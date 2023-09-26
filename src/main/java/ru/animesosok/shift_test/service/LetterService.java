package ru.animesosok.shift_test.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.animesosok.shift_test.dto.IntervalDto;
import ru.animesosok.shift_test.entity.LetterEntity;
import ru.animesosok.shift_test.mapper.LetterMapper;
import ru.animesosok.shift_test.repository.LetterRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LetterService {
    LetterRepository letterRepository;
    LetterMapper letterMapper;

    public void saveAll(List<IntervalDto<Character>> dtos){
        List<LetterEntity> digitEntities = dtos.stream().map(letterMapper::toEntity).toList();
        letterRepository.saveAll(digitEntities);
    }
    public IntervalDto<Character> getMin(){
        LetterEntity entity = letterRepository.minInterval();
        return letterMapper.toDto(entity);
    }
}
