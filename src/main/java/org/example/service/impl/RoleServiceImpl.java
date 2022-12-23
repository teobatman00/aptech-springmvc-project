package org.example.service.impl;

import org.example.entity.RoleEntity;
import org.example.repository.RoleRepository;
import org.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public List<RoleEntity> getRoles() {
        return roleRepository.getList();
    }

    @Override
    @Transactional
    public RoleEntity getById(long id) {
        return roleRepository.getById(id);
    }
}
