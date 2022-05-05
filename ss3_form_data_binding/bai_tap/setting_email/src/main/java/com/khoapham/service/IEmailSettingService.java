package com.khoapham.service;

import com.khoapham.model.Setting;

public interface IEmailSettingService {
    Setting getSetting();

    void save(Setting setting);
}
