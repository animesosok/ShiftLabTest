package ru.animesosok.shift_test.mapper;

import org.springframework.stereotype.Component;
import ru.animesosok.shift_test.dto.IntervalDto;
import ru.animesosok.shift_test.entity.LetterEntity;
@Component
public class LetterMapper {
    public LetterEntity toEntity(IntervalDto<Character> dto){
        return new LetterEntity(dto.getStart(), dto.getEnd());
    }
    public IntervalDto<Character> toDto(LetterEntity entity){
        return new IntervalDto<Character>(entity.getStart(), entity.getEnd());
    }
}
