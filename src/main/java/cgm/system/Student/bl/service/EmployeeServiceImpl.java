package cgm.system.Student.bl.service;

import cgm.system.Student.persistance.dao.EmployeeDAO;
import cgm.system.Student.persistance.entity.Employee;
import cgm.system.Student.web.form.EmployeeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public void doSaveEmployee(EmployeeForm employeeForm){
        Employee employee = new Employee(employeeForm);
        this.employeeDAO.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeDAO.deleteById(id);
    }


}
