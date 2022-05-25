package com.khoapham.repository;

import com.khoapham.dto.CustomerHaveBooking;
import com.khoapham.models.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findByNameContainingAndPhoneContainingAndStatus(String name, String phone, Boolean status, Pageable pageable);

    Page<Customer> findAllByNameContainingAndPhoneContainingAndCustomerType_IdAndStatus(String name, String phone, Integer customerType, Boolean status, Pageable pageable);

    Customer findFirstByEmail(String email);

    Customer findFirstByPhone(String phone);

    Customer findFirstByIdCard(String idCard);

    Customer findFirstByCustomerCode(String customerCode);

    @Query(value = "SELECT c.name nameCustomer,\n" +
            "       f.name nameFacility,\n" +
            "       c2.start_date startDate,\n" +
            "       c2.end_date endDate,\n" +
            "       GROUP_CONCAT(si.name) nameServiceInclude,\n" +
            "       sum(f.rental_fee + coalesce(cd.quantity * si.price, 0)) total\n" +
            "FROM customer c\n" +
            "         INNER JOIN contract c2 ON c.id = c2.customer_id\n" +
            "         INNER JOIN facility f ON c2.facility_id = f.id\n" +
            "         LEFT JOIN contract_detail cd ON c2.id = cd.contract_id\n" +
            "         LEFT JOIN service_include si ON cd.service_include_id = si.id\n" +
            "GROUP BY c2.id",
            countQuery = "SELECT c.name nameCustomer,\n" +
                    "       f.name nameFacility,\n" +
                    "       c2.start_date startDate,\n" +
                    "       c2.end_date endDate,\n" +
                    "       GROUP_CONCAT(si.name) nameServiceInclude,\n" +
                    "       sum(f.rental_fee + coalesce(cd.quantity * si.price, 0)) total\n" +
                    "FROM customer c\n" +
                    "         INNER JOIN contract c2 ON c.id = c2.customer_id\n" +
                    "         INNER JOIN facility f ON c2.facility_id = f.id\n" +
                    "         LEFT JOIN contract_detail cd ON c2.id = cd.contract_id\n" +
                    "         LEFT JOIN service_include si ON cd.service_include_id = si.id\n" +
                    "GROUP BY c2.id"
            , nativeQuery = true)
    Page<CustomerHaveBooking> findAllCustomerHaveBooking(Pageable pageable);
}
