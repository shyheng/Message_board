package com.shy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.shy.mapper.PersonalMapper;
import com.shy.model.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass =PersonalService.class,version = "1.0.0",timeout = 15000)
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    private PersonalMapper personalMapper;

    @Override
    public Personal selectPhone(String phone) {
        return personalMapper.selectByPrimaryKey(phone);
    }

    @Override
    public int insertPersonal(Personal personal) {
        return personalMapper.insert(personal);
    }

    @Override
    public int deletePersonal(String phone) {
        return personalMapper.deleteByPrimaryKey(phone);
    }
}
