package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.model.EmployeeType;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        double calculatedSalary = calculateSalary(employee.getType());
        employee.setSalary(calculatedSalary);
        employeeRepository.save(employee);
    }

    private double calculateSalary(EmployeeType type) {
        switch (type) {
            case PERMANENT:
                return 3000.0;
            case CONTRACTUAL:
                return 2000.0;
            case COMMISSION:
                return 1500.0 + (Math.random() * 500);
            default:
                throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public void deleteEmployeeByMatricule(String matricule) {
        employeeRepository.deleteById(matricule);
    }

    public Employee getEmployeeByMatricule(String matricule) {
        return employeeRepository.findById(matricule)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
