package com.khoapham.service.impl;

import com.khoapham.dto.ContractDetailDto;
import com.khoapham.models.contract.Contract;
import com.khoapham.models.contract.ContractDetail;
import com.khoapham.models.contract.ServiceInclude;
import com.khoapham.repository.IContractDetailRepository;
import com.khoapham.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return this.iContractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {

            contractDetail.setStatus(true);

        this.iContractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(ContractDetail contractDetail) {
        contractDetail.setStatus(false);
        this.iContractDetailRepository.save(contractDetail);
    }

    @Override
    public void checkExists(ContractDetailDto contractDetailDto, BindingResult bindingResult) {
        Contract contract = contractDetailDto.getContract();
        ServiceInclude serviceInclude = contractDetailDto.getServiceInclude();
        if (contract != null && serviceInclude != null) {
            ContractDetail contractDetail =
                    this.iContractDetailRepository.findFirstByContract_IdAndServiceInclude_Id(
                            contract.getId(), serviceInclude.getId());
            if (contractDetailDto.getId() == null) {
                //add new
                if (contractDetail != null) {
                    bindingResult.rejectValue("contract", "contract_service.exists");
                    bindingResult.rejectValue("serviceInclude", "contract_service.exists");
                }
            } else {
                //update
                if (!contractDetailDto.getId().equals(contractDetail.getId())) {
                    bindingResult.rejectValue("contract", "contract_service.exists");
                    bindingResult.rejectValue("serviceInclude", "contract_service.exists");
                }
            }

        }
    }
}
