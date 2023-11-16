package vn.edu.tdtu.Ex2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.edu.tdtu.Ex2.dto.EmployeeDTO;
import vn.edu.tdtu.Ex2.model.Employee;
import vn.edu.tdtu.Ex2.repository.EmployeeRepository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Create a new employee
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        employee.setName(employeeDTO.getName());
        employee.setAddress(employeeDTO.getAddress());
        employee.setPhone(employeeDTO.getPhone());
        employee.setEmail(employeeDTO.getEmail());

        Employee savedEmployee = employeeRepository.save(employee);
        return mapEmployeeToDTO(savedEmployee);
    }

    // Retrieve an employee by ID
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (employeeOptional.isPresent()) {
            return mapEmployeeToDTO(employeeOptional.get());
        }

        return null;
    }

    // Update an employee by ID
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            employee.setName(employeeDTO.getName());
            employee.setAddress(employeeDTO.getAddress());
            employee.setPhone(employeeDTO.getPhone());
            employee.setEmail(employeeDTO.getEmail());

            Employee updatedEmployee = employeeRepository.save(employee);
            return mapEmployeeToDTO(updatedEmployee);
        }

        return null;
    }

    // Delete an employee by ID
    public boolean deleteEmployee(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employeeRepository.delete(employee);
            return true;
        }

        return false;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDTO> employeeDTOs = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeeDTO employeeDTO = mapEmployeeToDTO(employee);
            employeeDTOs.add(employeeDTO);
        }

        return employeeDTOs;
    }

    private EmployeeDTO mapEmployeeToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setName(employee.getName());
        employeeDTO.setId(employee.getId());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setPhone(employee.getPhone());
        employeeDTO.setEmail(employee.getEmail());

        return employeeDTO;
    }
}
