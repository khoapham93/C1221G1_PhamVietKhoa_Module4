package com.khoapham.repository;

import com.khoapham.models.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    ContractDetail findFirstByContract_IdAndServiceInclude_Id(Integer contractId, Integer serviceIncludeId);
}
