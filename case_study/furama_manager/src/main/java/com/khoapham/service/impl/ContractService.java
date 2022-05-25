package com.khoapham.service.impl;

import com.khoapham.models.contract.Contract;
import com.khoapham.repository.IContractRepository;
import com.khoapham.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAll(LocalDate fromDate, LocalDate toDate, Pageable pageable) {
        if (fromDate == null && toDate == null) {
            return this.iContractRepository.findAll(pageable);
        } else if (fromDate != null && toDate != null) {
            return this.iContractRepository.findAllByStartDateGreaterThanEqualAndEndDateIsLessThanEqualAndStatus(fromDate, toDate, true, pageable);
        } else if (fromDate != null) {
            return this.iContractRepository.findAllByStartDateGreaterThanEqualAndStatus(fromDate, true, pageable);
        } else {
            return this.iContractRepository.findAllByEndDateIsLessThanEqualAndStatus(toDate, true, pageable);
        }
    }

    @Override
    public Contract findById(Integer id) {
        return this.iContractRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contract> findAll() {
        return this.iContractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {

            contract.setStatus(true);

        this.iContractRepository.save(contract);
    }

    @Override
    public void remove(Contract contract) {
        contract.setStatus(false);
        this.iContractRepository.save(contract);
    }
}
