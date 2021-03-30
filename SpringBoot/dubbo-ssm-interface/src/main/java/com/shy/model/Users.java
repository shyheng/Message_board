package com.shy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Users implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String passwordSalt;
}