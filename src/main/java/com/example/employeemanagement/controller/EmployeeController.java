package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{matricule}")
    public String deleteEmployee(@PathVariable String matricule) {
        employeeService.deleteEmployeeByMatricule(matricule);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{matricule}")
    public String editEmployeeForm(@PathVariable String matricule, Model model) {
        Employee employee = employeeService.getEmployeeByMatricule(matricule);
        model.addAttribute("employee", employee);
        return "edit_employee";
    }

    @PostMapping("/edit")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }
}
