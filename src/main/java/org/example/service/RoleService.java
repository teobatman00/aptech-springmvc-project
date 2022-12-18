package org.example.service;

import org.example.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    List<RoleEntity> getRoles();

    RoleEntity getById(long id);
}
