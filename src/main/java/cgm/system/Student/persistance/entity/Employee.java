package cgm.system.Student.persistance.entity;

import cgm.system.Student.web.form.EmployeeForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name="employee_name")
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="skills")
    private String skills;

    @Column(name="address")
    private String address;

    @Column(name="designation")
    private String designation;

    public Employee(EmployeeForm employeeForm){
        this.id = employeeForm.getId();
        this.name = employeeForm.getName();
        this.age = employeeForm.getAge();
        this.skills = employeeForm.getSkills();
        this.address = employeeForm.getAddress();
        this.designation = employeeForm.getDesignation();

    }
}
