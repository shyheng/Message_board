package com.shy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.shy.mapper.UsersMapper;
import com.shy.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UsersService.class,version = "1.0.0",timeout = 15000)
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users selectUsername(String username) {
        return usersMapper.selectByPrimaryKey(username);
    }

    @Override
    public int insertUser(Users users) {
        return usersMapper.insert(users);
    }

    @Override
    public int deleteUser(String users) {
        return usersMapper.deleteByPrimaryKey(users);
    }

    @Override
    public int upData(Users users) {
        return usersMapper.updateByPrimaryKey(users);
    }
}
