package com.example.service.impl;

import com.example.model.Smartphone;
import com.example.repository.ISmartphoneRepository;
import com.example.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository smartPhoneRepository;

    @Override
    public Page<Smartphone> findAll(Pageable pageable) {
        return this.smartPhoneRepository.findAll(pageable);
    }

    @Override
    public Smartphone findById(Long id) {
        return this.smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return this.smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        this.smartPhoneRepository.deleteById(id);
    }
}
