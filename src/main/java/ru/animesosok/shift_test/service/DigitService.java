package ru.animesosok.shift_test.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.animesosok.shift_test.dto.IntervalDto;
import ru.animesosok.shift_test.entity.DigitEntity;
import ru.animesosok.shift_test.mapper.DigitMapper;
import ru.animesosok.shift_test.repository.DigitRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class DigitService {
    DigitRepository digitRepository;
    DigitMapper digitMapper;

    public void saveAll(List<IntervalDto<Integer>> dtos){
        List<DigitEntity> digitEntities = dtos.stream().map(digitMapper::toEntity).toList();
        digitRepository.saveAll(digitEntities);
    }
    public IntervalDto<Integer> getMin(){
        DigitEntity entity = digitRepository.minInterval();
        return digitMapper.toDto(entity);
    }

}
