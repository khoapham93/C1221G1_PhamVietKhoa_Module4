package com.khoapham.models.contract;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail",
        uniqueConstraints = { //
                @UniqueConstraint(name = "CONTRACT_DETAIL_UK", columnNames = {"contract_Id", "service_include_Id"})})
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "contract_Id", nullable = false)
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "service_include_Id", nullable = false)
    private ServiceInclude serviceInclude;
    private Integer quantity;
    private Boolean status;

    public ContractDetail(Integer id, Contract contract, ServiceInclude serviceInclude, Integer quantity) {
        this.id = id;
        this.contract = contract;
        this.serviceInclude = serviceInclude;
        this.quantity = quantity;
    }

    public ContractDetail(Contract contract, ServiceInclude serviceInclude, Integer quantity) {

        this.contract = contract;
        this.serviceInclude = serviceInclude;
        this.quantity = quantity;
    }

    public ContractDetail() {

    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ServiceInclude getServiceInclude() {
        return serviceInclude;
    }

    public void setServiceInclude(ServiceInclude serviceInclude) {
        this.serviceInclude = serviceInclude;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
