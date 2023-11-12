package tdtu.edu.vn.lab8.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdtu.edu.vn.lab8.Models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
