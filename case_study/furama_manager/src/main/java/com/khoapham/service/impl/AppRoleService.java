package com.khoapham.service.impl;


import com.khoapham.models.user.AppRole;
import com.khoapham.repository.IAppRoleRepository;
import com.khoapham.service.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppRoleService implements IAppRoleService {
    @Autowired
    private IAppRoleRepository iAppRoleRepository;

    @Override
    public AppRole findById(Integer id) {
    return this.iAppRoleRepository.findById(id).orElse(null);
    }
}
