package ru.animesosok.shift_test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "digits")
public class DigitEntity  extends AbstractEntity{
    @Column(name = "start")
    private Integer start;
    @Column(name = "end")
    private Integer end;

    public DigitEntity() {

    }
}
