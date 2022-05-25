package com.khoapham.service.impl;

import com.khoapham.models.contract.ServiceInclude;
import com.khoapham.repository.IServiceIncludeRepository;
import com.khoapham.service.IServiceIncludeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceIncludeService implements IServiceIncludeService {
    @Autowired
    private IServiceIncludeRepository iServiceIncludeRepository;

    @Override
    public List<ServiceInclude> findAll() {
        return this.iServiceIncludeRepository.findAll();
    }
}
