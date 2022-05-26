package com.khoapham.controller;

import com.khoapham.dto.EmployeeDto;
import com.khoapham.models.employee.AcademicLevel;
import com.khoapham.models.employee.Department;
import com.khoapham.models.employee.Employee;
import com.khoapham.models.employee.Position;
import com.khoapham.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IAppUserService iAppUserService;
    @Autowired
    private IUserRoleService iUserRoleService;
    @Autowired
    private IAppRoleService iAppRoleService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IAcademicLevelService iAcademicLevelService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IDepartmentService iDepartmentService;

    @ModelAttribute("departments")
    public List<Department> findAllDepartment() {
        return this.iDepartmentService.findAll();
    }

    @ModelAttribute("positions")
    public List<Position> findAllPosition() {
        return this.iPositionService.findAll();
    }

    @ModelAttribute("academicLevels")
    public List<AcademicLevel> findAllAcademic() {
        return this.iAcademicLevelService.findAll();
    }

    @GetMapping("")
    public String goListEmployees(Model model,
                                  @RequestParam Optional<String> name,
                                  @RequestParam Optional<String> phone,
                                  @RequestParam Optional<Integer> department,
                                  @PageableDefault(value = 5) Pageable pageable) {
        String nameVal = name.orElse("");
        String phoneVal = phone.orElse("");
        Integer departmentVal = department.orElse(-1);
        Page<Employee> employees = this.iEmployeeService.findAll(nameVal, phoneVal, departmentVal, pageable);
        model.addAttribute("employees", employees);
        model.addAttribute("nameVal", nameVal);
        model.addAttribute("phoneVal", phoneVal);
        model.addAttribute("departmentVal", departmentVal);
        return "/employees/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "/employees/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated EmployeeDto employeeDto,
                       BindingResult bindingResult,
                       Model model) {

        new EmployeeDto().validate(employeeDto, bindingResult);
        this.iEmployeeService.checkExists(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("employeeDto", employeeDto);
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            iEmployeeService.save(employee);
            model.addAttribute("employeeDto", new EmployeeDto());

            model.addAttribute("success", "Create employee successfully!");
        }
        return "/employees/create";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {

        Employee employee = this.iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();

        BeanUtils.copyProperties(employee, employeeDto);
        employeeDto.setSalary(String.format("%.1f", employee.getSalary()));
        model.addAttribute("employeeDto", employeeDto);
        return "/employees/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated EmployeeDto employeeDto,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirect) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        this.iEmployeeService.checkExists(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            return "/employees/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employee.setSalary(Double.valueOf(employeeDto.getSalary()));
            iEmployeeService.save(employee);
            redirect.addFlashAttribute("success", "Update employee successfully!");
            return "redirect:/employees/";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirect) {
        Employee employee = this.iEmployeeService.findById(id);
        this.iEmployeeService.remove(employee);
        redirect.addFlashAttribute("success", "Removed employee successfully!");
        return "redirect:/employees/";
    }

}
