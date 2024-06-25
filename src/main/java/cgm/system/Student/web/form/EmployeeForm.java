package cgm.system.Student.web.form;

import cgm.system.Student.persistance.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeForm {

    private Long id;
    private String name;
    private int age;
    private String skills;
    private String address;
    private String designation;

    public EmployeeForm(Employee employee){
        this.id = employee.getId();
        this.name = employee.getName();
        this.age = employee.getAge();
        this.skills = employee.getSkills();
        this.address = employee.getAddress();
        this.designation = employee.getDesignation();
    }
}
