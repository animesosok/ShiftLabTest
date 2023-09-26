package ru.animesosok.shift_test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.animesosok.shift_test.dto.IntervalDto;
import ru.animesosok.shift_test.parser.IntervalParser;
import ru.animesosok.shift_test.service.DigitService;
import ru.animesosok.shift_test.service.LetterService;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/intervals/")
public class IntervalController {

    DigitService digitService;
    LetterService letterService;
    ObjectMapper objectMapper;

    @GetMapping("/min")
    protected Object getInterval(@RequestParam String kind) {
        if ("digits".equals(kind)) {
            var dto = digitService.getMin();
            if(null != dto) {
                return ResponseEntity.ok(new int[]{dto.getStart(), dto.getEnd()});
            }
            else {
                return ResponseEntity.badRequest().body("NoDataInDB");
            }
        } else if ("letters".equals(kind)) {
            var dto = letterService.getMin();
            if(null != dto) {
                return ResponseEntity.ok(new Character[]{dto.getStart(), dto.getEnd()});
            }
            else {
                return ResponseEntity.badRequest().body("NoDataInDB");
            }
        }
        return ResponseEntity.badRequest().body("BadFormat");
    }

    @PostMapping("/merge")
    protected Object  postInterval(@RequestParam String kind, @RequestBody String intervalJsonString) {
        if ("digits".equals(kind)) {
            IntervalParser<Integer> parser = new IntervalParser<Integer>();
            try {
                Integer[][] intervals = objectMapper.readValue(intervalJsonString, Integer[][].class);
                List<IntervalDto<Integer>> dtos = parser.parseDto(intervals);
                digitService.saveAll(dtos);
                return ResponseEntity.ok("OK");
            } catch (JsonProcessingException e) {
                System.err.println( "bad json for digits " + e.getMessage());
                return ResponseEntity.badRequest().body("BadDigitFormat");
            }
        } else if ("letters".equals(kind)) {
            IntervalParser<Character> parser = new IntervalParser<Character>();
            try {
                Character[][] intervals = objectMapper.readValue(intervalJsonString, Character[][].class);
                List<IntervalDto<Character>> dtos = parser.parseDto(intervals);
                letterService.saveAll(dtos);
                return ResponseEntity.ok("OK");
            } catch (JsonProcessingException e) {
                System.err.println( "bad json for letters " + e.getMessage());
                return ResponseEntity.badRequest().body("BadLetterFormat");
            }
        }
        return ResponseEntity.badRequest().body("BadType");
    }

}
