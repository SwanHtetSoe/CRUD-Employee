package cgm.system.Student.bl.service;

import cgm.system.Student.persistance.entity.Employee;
import cgm.system.Student.web.form.EmployeeForm;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    public void doSaveEmployee(EmployeeForm employeeForm);
    public Employee getEmployeeById(Long id);
    public void deleteEmployee(Long id);
}
