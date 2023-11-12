package tdtu.edu.vn.lab8.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tdtu.edu.vn.lab8.Models.Employee;
import tdtu.edu.vn.lab8.Repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Controller

public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/employees")
    private String listEmployee(Model model){
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employee",employees);
        return "index";
    }

    @GetMapping("/employees/add")
    public String pagesAddEmployee(){
        return "add";
    }
    @PostMapping("/employees/add")
    public String addEmployees(@RequestParam("name") String name,@RequestParam("address") String address,@RequestParam("phone") String phone){
        Employee employee = employeeRepository.save(new Employee(name,address,phone));
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String showEditForm(@PathVariable("id") int id,Model model){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            model.addAttribute("employee",employee);
        }else{
            return "index";
        }
        return "redirect:/employees";
    }
    @PostMapping("/employees/edit/{id}")
    public String handleEditForm(@PathVariable("id") int id,@RequestParam("name") String name,@RequestParam("address") String address,@RequestParam("phone") String phone){
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee!= null){
            employee.setName(name);
            employee.setPhone(phone);
            employee.setAddress(address);

            employeeRepository.save(employee);
        }
        return "redirect:/employee";
    }

    @PostMapping("/employees/delete/{id}")
    public String DeleteEmployee(@PathVariable("id") int id){
        employeeRepository.deleteById(id);
        return "redirect:/employee";
    }

}
