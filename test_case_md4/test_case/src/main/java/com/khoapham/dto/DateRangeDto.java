package com.khoapham.dto;

import com.khoapham.util.Validation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class DateRangeDto implements Validator {
    private LocalDate fromDate;
    private LocalDate toDate;

    public DateRangeDto() {
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        DateRangeDto dateRangeDto = (DateRangeDto) target;
        LocalDate fromDate = dateRangeDto.getFromDate();
        LocalDate toDate = dateRangeDto.getToDate();

        if (fromDate != null && toDate != null) {
            Validation.checkEndDate("toDate", fromDate, toDate, errors);
        }
    }
}
