package com.khoapham.service.impl;

import com.khoapham.dto.EmployeeDto;
import com.khoapham.models.Employee;
import com.khoapham.repository.IEmployeeRepository;
import com.khoapham.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAll(String name, String phone, Integer department, Pageable pageable) {
        if (department == -1) {
            return this.iEmployeeRepository.findByNameContainingAndPhoneContaining(name, phone, pageable);
        } else {
            return this.iEmployeeRepository.findAllByNameContainingAndPhoneContainingAndDepartment_Id(name, phone, department, pageable);
        }
    }

    @Override
    public Employee findById(Integer id) {
        return this.iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void checkExists(EmployeeDto employeeDto, BindingResult bindingResult) {
        //email
        Employee existsEmail = this.iEmployeeRepository.findFirstByEmail(employeeDto.getEmail());
        //idCard
        Employee existsPhone = this.iEmployeeRepository.findFirstByPhone(employeeDto.getPhone());
        //phone
        Employee existsIdCard = this.iEmployeeRepository.findFirstByIdCard(employeeDto.getIdCard());

        if (employeeDto.getId() == null) {
            //Add new
            if (!"".equals(employeeDto.getEmail())) {
                if (existsEmail != null) {
                    bindingResult.rejectValue("email", "email.exists");
                }
            }
            if (!"".equals(employeeDto.getPhone())) {
                if (existsPhone != null) {
                    bindingResult.rejectValue("phone", "phone.exists");
                }
            }
            if (!"".equals(employeeDto.getIdCard())) {
                if (existsIdCard != null) {
                    bindingResult.rejectValue("idCard", "idCard.exists");
                }
            }
        } else {
            //update
            if (existsEmail != null) {
                if (!existsEmail.getId().equals(employeeDto.getId())) {
                    bindingResult.rejectValue("email", "email.exists");
                }
            }
            if (existsPhone != null) {
                if (!existsPhone.getId().equals(employeeDto.getId())) {
                    bindingResult.rejectValue("phone", "phone.exists");
                }
            }
            if (existsIdCard != null) {
                if (!existsIdCard.getId().equals(employeeDto.getId())) {
                    bindingResult.rejectValue("idCard", "idCard.exists");
                }
            }

        }
    }

    @Override
    public void save(Employee employee) {
        this.iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {
        this.iEmployeeRepository.deleteById(id);
    }
}
