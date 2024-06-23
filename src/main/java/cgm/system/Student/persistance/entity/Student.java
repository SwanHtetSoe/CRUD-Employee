package cgm.system.Student.persistance.entity;

import cgm.system.Student.web.form.StudentForm;
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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name="student_name")
    private String studentName;

    @Column(name="student_email")
    private String studentEmail;

    public Student(StudentForm studentForm){
        this.studentId = studentForm.getStudentId();
        this.studentName = studentForm.getStudentName();
        this.studentEmail = studentForm.getStudentEmail();
    }
}
