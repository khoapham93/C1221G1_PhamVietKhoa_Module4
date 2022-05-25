package com.khoapham.service;

import com.khoapham.dto.ContractDetailDto;
import com.khoapham.models.contract.ContractDetail;
import org.springframework.validation.BindingResult;

public interface IContractDetailService extends ICRUDService<ContractDetail>{
    void checkExists(ContractDetailDto contractDetailDto, BindingResult bindingResult);
}
