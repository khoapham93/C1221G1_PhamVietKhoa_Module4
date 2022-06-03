package com.khoapham.service.impl;

import com.khoapham.dto.CustomerHaveBooking;
import com.khoapham.dto.ServiceAttachInContract;
import com.khoapham.exception.ObjectNotFound;
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
    public Contract findById(Integer id) throws ObjectNotFound {
        Contract contract = this.iContractRepository.findById(id).orElse(null);
        if (contract == null) {
            throw new ObjectNotFound();
        } else {
            return contract;
        }
    }

    @Override
    public Page<CustomerHaveBooking> findAllContractAndDetail(LocalDate fromDate, LocalDate toDate, Pageable pageable) {
        String startBegin = "";
        String startEnd = "";
        String endBegin = "";
        String end = "";
        if (fromDate == null && toDate == null) {
            startEnd = LocalDate.now().plusYears(1).toString();
            end = LocalDate.now().plusYears(1).toString();
        } else if (fromDate != null && toDate != null) {
            startBegin = fromDate.toString();
            startEnd = toDate.toString();
            end = toDate.toString();
        } else if (fromDate != null) {
            startBegin = fromDate.toString();
            startEnd = LocalDate.now().plusYears(1).toString();
            end = LocalDate.now().plusYears(1).toString();
        } else {
            startEnd = toDate.toString();
            end = toDate.toString();
        }

        return this.iContractRepository.findAllContractAndDetail(startBegin, startEnd, endBegin, end, pageable);
    }

    @Override
    public List<ServiceAttachInContract> findDetailByContractId(Integer id) {
        return this.iContractRepository.findDetailByContract(id);
    }

    @Override
    public List<Contract> findAll() {
        return this.iContractRepository.findAllByStatus(true);
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
