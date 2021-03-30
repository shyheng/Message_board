package com.shy.service;

import java.util.Set;

public interface PermissionsService {
    Set<String> selectPermissions(String username);
}
