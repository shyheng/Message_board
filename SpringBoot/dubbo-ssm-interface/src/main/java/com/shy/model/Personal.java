package com.shy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Personal implements Serializable {
    private Integer id;
    private String sex;
    private String birthday;
    private Integer age;
    private String phone;
}