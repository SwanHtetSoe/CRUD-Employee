package cgm.system.Student.web.form;

import cgm.system.Student.persistance.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentForm {

    private long studentId;

    private String studentName;

    private String studentEmail;

    public StudentForm(Student student){
        this.studentId = student.getStudentId();
        this.studentName = student.getStudentName();
        this.studentEmail = student.getStudentEmail();
    }
}
