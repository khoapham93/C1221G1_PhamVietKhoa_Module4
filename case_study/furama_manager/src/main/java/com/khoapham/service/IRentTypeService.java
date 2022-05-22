package com.khoapham.service;

import com.khoapham.models.RentType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
}
