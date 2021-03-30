package com.shy.service;

import java.util.Set;

public interface RolesService {
    Set<String> selectRoleName(String username);
}
