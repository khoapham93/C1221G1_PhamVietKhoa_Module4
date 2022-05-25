package com.khoapham.dto;

import java.time.LocalDate;

public interface CustomerHaveBooking {
    String getNameCustomer();
    String getNameFacility();
    LocalDate getStartDate();
    LocalDate getEndDate();
    String getNameServiceInclude();
    Double getTotal();
}
