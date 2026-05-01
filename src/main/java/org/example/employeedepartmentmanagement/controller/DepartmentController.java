package org.example.employeedepartmentmanagement.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.employeedepartmentmanagement.dto.DepartmentDTO;
import org.example.employeedepartmentmanagement.service.IDepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("departments")
public class DepartmentController {

    private final IDepartmentService departmentService;

    @GetMapping
    public String getAllDepartments(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        return "department-list";
    }

    @GetMapping("/add")
    public String viewAddDepartment(Model model) {
        model.addAttribute("department", new DepartmentDTO());
        return "department-add";
    }

    @GetMapping("/edit/{id}")
    public String viewEditDepartment(@PathVariable Long id, Model model) {
        model.addAttribute("department", departmentService.findById(id));
        return "department-add";
    }

    @PostMapping("/save")
    public String saveDepartment(
            @Valid @ModelAttribute("department") DepartmentDTO departmentDTO,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "department-add";
        }

        departmentService.save(departmentDTO);
        return "redirect:/departments";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteById(id);
        return "redirect:/departments";
    }
}