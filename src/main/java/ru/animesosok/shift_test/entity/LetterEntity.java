package ru.animesosok.shift_test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "letters")
public class LetterEntity extends AbstractEntity {
    @Column(name = "start")
    private Character start;
    @Column(name = "end")
    private Character end;

    public LetterEntity() {

    }
}
