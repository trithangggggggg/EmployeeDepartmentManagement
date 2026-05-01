package org.example.employeedepartmentmanagement.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.employeedepartmentmanagement.dto.EmployeeDTO;
import org.example.employeedepartmentmanagement.service.IDepartmentService;
import org.example.employeedepartmentmanagement.service.IEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeController {

    private final IEmployeeService employeeService;
    private final IDepartmentService departmentService;

    @GetMapping
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employee-list";
    }

    @GetMapping("/add")
    public String viewAddEmployee(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        model.addAttribute("departments", departmentService.findAll());
        return "employee-add";
    }

    @GetMapping("/edit/{id}")
    public String viewEditEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("departments", departmentService.findAll());
        return "employee-add";
    }

    @PostMapping("/save")
    public String saveEmployee(
            @Valid @ModelAttribute("employee") EmployeeDTO employeeDTO,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("departments", departmentService.findAll());
            return "employee-add";
        }

        employeeService.save(employeeDTO);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }
}