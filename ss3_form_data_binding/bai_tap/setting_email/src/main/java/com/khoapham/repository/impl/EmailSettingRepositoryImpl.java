package com.khoapham.repository.impl;

import com.khoapham.model.Setting;
import com.khoapham.repository.IEmailSettingRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmailSettingRepositoryImpl implements IEmailSettingRepository {

    private Setting setting = new Setting();
    @Override
    public Setting getSetting() {
        return setting;
    }

    @Override
    public void save(Setting setting) {
        this.setting = setting;
    }
}
