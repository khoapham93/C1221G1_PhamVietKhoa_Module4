package com.khoapham.repository;

import com.khoapham.dto.CustomerHaveBooking;
import com.khoapham.models.contract.Contract;
import com.khoapham.models.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    List<Contract> findAllByStatus(Boolean status);

    Page<Contract> findAllByStartDateGreaterThanEqualAndEndDateIsLessThanEqualAndStatus(LocalDate startDate, LocalDate endDate, Boolean status, Pageable pageable);

    Page<Contract> findAllByStartDateGreaterThanEqualAndStatus(LocalDate startDate, Boolean status, Pageable pageable);

    Page<Contract> findAllByEndDateIsLessThanEqualAndStatus(LocalDate endDate, Boolean status, Pageable pageable);

    @Query(value = "SELECT c2.id contractId,\n" +
            "       c.name nameCustomer,\n" +
            "       f.name nameFacility,\n" +
            "       c2.start_date startDate,\n" +
            "       c2.end_date endDate,\n" +
            "       c2.deposit deposit,\n" +
            "       sum(coalesce(cd.quantity * si.price, 0)) + f.rental_fee  total,\n" +
            "       GROUP_CONCAT(si.name) nameServiceInclude\n" +
            "FROM customer c\n" +
            "         INNER JOIN contract c2 ON c.id = c2.customer_id\n" +
            "         INNER JOIN facility f ON c2.facility_id = f.id\n" +
            "         LEFT JOIN contract_detail cd ON c2.id = cd.contract_id\n" +
            "         LEFT JOIN service_include si ON cd.service_include_id = si.id\n" +
            "WHERE c2.start_date BETWEEN :startBegin AND :startEnd AND c2.end_date BETWEEN :endBegin AND :end\n" +
            "GROUP BY c2.id",
            countQuery = "SELECT c2.id contractId,\n" +
                    "       c.name nameCustomer,\n" +
                    "       f.name nameFacility,\n" +
                    "       c2.start_date startDate,\n" +
                    "       c2.end_date endDate,\n" +
                    "       c2.deposit deposit,\n" +
                    "       sum(coalesce(cd.quantity * si.price, 0)) + f.rental_fee  total,\n" +
                    "       GROUP_CONCAT(si.name) nameServiceInclude\n" +
                    "FROM customer c\n" +
                    "         INNER JOIN contract c2 ON c.id = c2.customer_id\n" +
                    "         INNER JOIN facility f ON c2.facility_id = f.id\n" +
                    "         LEFT JOIN contract_detail cd ON c2.id = cd.contract_id\n" +
                    "         LEFT JOIN service_include si ON cd.service_include_id = si.id\n" +
                    "WHERE c2.start_date BETWEEN :startBegin AND :startEnd AND c2.end_date BETWEEN :endBegin AND :end\n" +
                    "GROUP BY c2.id"
            , nativeQuery = true)
    Page<CustomerHaveBooking> findAllContractAndDetail(@Param("startBegin") String startBegin,
                                                       @Param("startEnd") String startEnd,
                                                       @Param("endBegin") String endBegin,
                                                       @Param("end") String end,
                                                       Pageable pageable);
}
