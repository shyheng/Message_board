package com.shy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Diary implements Serializable {
    private Integer id;
    private String dateDay;
    private String name;
    private String text;
}