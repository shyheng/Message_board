package com.shy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.shy.mapper.PermissionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
@Service(interfaceClass =PermissionsService.class,version = "1.0.0",timeout = 15000)
public class PermissionsServiceImpl implements PermissionsService {

    @Autowired
    private PermissionsMapper permissionsMapper;


    @Override
    public Set<String> selectPermissions(String username) {
        return permissionsMapper.selectByPrimaryKey(username);
    }
}
