package com.khoapham.service;

import dto.ContractDTO;
import models.Contract;

import java.util.List;

public interface IContractService extends ICRUDService<Contract>{
    List<ContractDTO> getList();

    Contract findById(Integer id);

    List<ContractDTO> search(String fieldSearch1, String fieldSearch2, String fieldSearch3, String searchKey1, String searchKey2, String searchKey3);

}
