package com.shy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permissions implements Serializable {
    private Integer permissionId;
    private String permissionCode;
    private String permissionName;
}