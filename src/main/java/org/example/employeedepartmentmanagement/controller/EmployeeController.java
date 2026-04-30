package org.example.employeedepartmentmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.employeedepartmentmanagement.dto.EmployeeDTO;
import org.example.employeedepartmentmanagement.service.IDepartmentService;
import org.example.employeedepartmentmanagement.service.IEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeController {
    private final IEmployeeService employeeService;

    @GetMapping
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employee-list";
    }

//
//    @GetMapping("/add")
//    public String viewAddEmployee(Model model){
//        model.addAttribute("employee", new EmployeeDTO());
//        return "employee-add";
//    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }


}
