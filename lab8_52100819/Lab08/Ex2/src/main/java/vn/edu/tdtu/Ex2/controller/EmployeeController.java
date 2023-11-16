package vn.edu.tdtu.Ex2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.tdtu.Ex2.dto.EmployeeDTO;
import vn.edu.tdtu.Ex2.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String displayAllEmployee(Model model) {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

    // Add a new employee
    @GetMapping("/add")
    public String addEmployee() {
        return "add";
    }
    @PostMapping("/add")
    public String createEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
        EmployeeDTO createdEmployee = employeeService.createEmployee(employeeDTO);
        return "redirect:/employees";
    }

    // Update an employee by ID
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(id, employeeDTO);
        return "redirect:/employees";
    }

    // Delete an employee by ID
    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
