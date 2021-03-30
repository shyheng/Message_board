package com.shy.service;

import com.shy.model.Personal;

public interface PersonalService {
    Personal selectPhone(String phone);
    int insertPersonal(Personal personal);
    int deletePersonal(String phone);
}
