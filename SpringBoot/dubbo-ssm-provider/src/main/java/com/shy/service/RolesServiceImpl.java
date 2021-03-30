package com.shy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.shy.mapper.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
@Service(interfaceClass =RolesService.class,version = "1.0.0",timeout = 15000)
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesMapper rolesMapper;

    @Override
    public Set<String> selectRoleName(String username) {
        return rolesMapper.selectByPrimaryKey(username);
    }
}
