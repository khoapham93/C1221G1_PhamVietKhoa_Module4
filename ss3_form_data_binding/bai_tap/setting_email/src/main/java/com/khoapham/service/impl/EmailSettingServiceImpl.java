package com.khoapham.service.impl;

import com.khoapham.model.Setting;
import com.khoapham.repository.IEmailSettingRepository;
import com.khoapham.service.IEmailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSettingServiceImpl implements IEmailSettingService {
    @Autowired
    private IEmailSettingRepository iEmailSettingRepository;

    @Override
    public Setting getSetting() {
        return this.iEmailSettingRepository.getSetting();
    }

    @Override
    public void save(Setting setting) {
        this.iEmailSettingRepository.save(setting);

    }
}
