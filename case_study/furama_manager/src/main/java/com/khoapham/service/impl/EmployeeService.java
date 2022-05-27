package com.khoapham.service.impl;

import com.khoapham.dto.EmployeeDto;
import com.khoapham.models.employee.Employee;
import com.khoapham.models.user.AppRole;
import com.khoapham.models.user.AppUser;
import com.khoapham.repository.IEmployeeRepository;
import com.khoapham.service.IAppRoleService;
import com.khoapham.service.IAppUserService;
import com.khoapham.service.IEmployeeService;
import com.khoapham.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IAppUserService iAppUserService;
    @Autowired
    private IUserRoleService iUserRoleService;
    @Autowired
    private IAppRoleService iAppRoleService;
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAll(String name, String phone, Integer department, Pageable pageable) {
        if (department == -1) {
            return this.iEmployeeRepository.findByNameContainingAndPhoneContainingAndStatus(name, phone, true, pageable);
        } else {
            return this.iEmployeeRepository.findAllByNameContainingAndPhoneContainingAndDepartment_IdAndStatus(name, phone, department, true, pageable);
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
    public List<Employee> findAll() {
        return this.iEmployeeRepository.findAllByStatus(true);
    }

    @Override
    public void save(Employee employee) {
        if (employee.getId() == null){
            AppUser appUser = new AppUser();
            AppRole roleUser = this.iAppRoleService.findById(2);
            AppRole roleAdmin = this.iAppRoleService.findById(1);

            //Create new acount and
            this.iAppUserService.registerNewUserAccount(employee, appUser);
            //create Role
            this.iUserRoleService.setUserRoleForNewUser(employee, roleUser, roleAdmin, appUser);
            employee.setAppUser(appUser);
        }

        employee.setStatus(true);
        this.iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(Employee employee) {
        employee.setStatus(false);
        this.iAppUserService.remove(employee.getAppUser());
        this.iEmployeeRepository.save(employee);
    }
}
