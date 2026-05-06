package MavenPractice.employeeApp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class EmployeeService { 
	private final EmployeeRepository repo;   // Dependency

    // Constructor Injection (preferred)
    @Autowired
    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public void addEmployee(int id, String name, String dept) {
        repo.save(new Employee(id, name, dept));
    }

    public Employee getEmployee(int id) {
        return repo.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public boolean removeEmployee(int id) {
        return repo.deleteById(id);
    }

}
