package ru.animesosok.shift_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IntervalDto<T extends Comparable<T>>{
    private T start;
    private T end;
}
