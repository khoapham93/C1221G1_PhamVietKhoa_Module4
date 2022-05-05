package com.khoapham.repository;

import com.khoapham.model.Setting;

public interface IEmailSettingRepository {
    Setting getSetting();

    void save(Setting setting);
}
