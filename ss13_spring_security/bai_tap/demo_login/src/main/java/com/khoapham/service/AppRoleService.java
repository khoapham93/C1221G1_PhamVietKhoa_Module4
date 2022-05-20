package com.khoapham.service;

import com.khoapham.model.AppRole;
import com.khoapham.repository.IAppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppRoleService implements IAppRoleService {
    @Autowired
    private IAppRoleRepository iAppRoleRepository;

    @Override
    public AppRole findById(Long id) {
    return this.iAppRoleRepository.findById(id).orElse(null);
    }
}
