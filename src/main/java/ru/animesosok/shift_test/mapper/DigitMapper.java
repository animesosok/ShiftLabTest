package ru.animesosok.shift_test.mapper;

import org.springframework.stereotype.Component;
import ru.animesosok.shift_test.dto.IntervalDto;
import ru.animesosok.shift_test.entity.DigitEntity;

@Component
public class DigitMapper {
    public DigitEntity toEntity(IntervalDto<Integer> dto){
        return new DigitEntity(dto.getStart(), dto.getEnd());
    }
    public IntervalDto<Integer> toDto(DigitEntity entity){
        return new IntervalDto<Integer>(entity.getStart(), entity.getEnd());
    }
}
