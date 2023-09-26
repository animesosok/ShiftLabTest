package ru.animesosok.shift_test.parser;

import ru.animesosok.shift_test.dto.IntervalDto;
import java.util.*;

public class IntervalParser<T extends Comparable<T>> {
    public List<IntervalDto<T>> parseDto(T[][] array) {
        List<T[]>  checkedArray = checkArray(array);
        List<IntervalDto<T>> dtoList = new ArrayList<>();
        for (T[] i : checkedArray) {
            T start = i[0];
            T end = i[1];
            IntervalDto<T> digitDto = new IntervalDto<T>(start, end);
            dtoList.add(digitDto);
        }
        return dtoList;
    }

    private  List<T[]>  checkArray(T[][] array) {
        List<T[]> listT = new ArrayList<>();
        for (var el : array) {
            if (el.length == 2 && el[0].compareTo(el[1]) < 0) {
                listT.add(el);
            }
        }
        listT.sort(Comparator.comparing(a -> a[0]));
        Stack<T[]> stack = new Stack<>();
        for (var curr: listT) {
            if (stack.empty() || curr[0].compareTo(stack.peek()[1]) > 0 ) {
                stack.push(curr);
            }
            if (stack.peek()[1].compareTo( curr[1]) < 0) {
                stack.peek()[1]= curr[1];
            }
        }
        List<T[]> resList = new ArrayList<>();
        while (!stack.empty()) {
            resList.add(stack.pop());
        }
        return resList;
    }
}
