package com.khoapham.dto;

import java.time.LocalDate;

public interface CustomerHaveBooking {
    String getContractId();
    String getNameCustomer();
    String getNameFacility();
    LocalDate getStartDate();
    LocalDate getEndDate();
    Double getDeposit();
    Double getTotal();
    String getNameServiceInclude();
}
