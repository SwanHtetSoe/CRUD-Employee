package cgm.system.Student.bl.service;

import cgm.system.Student.persistance.entity.Student;
import cgm.system.Student.web.form.StudentForm;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    public void doSaveStudent(StudentForm studentForm);
    public void doUpdateStudent(StudentForm studentForm);
    public boolean doDeleteStudent(StudentForm studentForm);
}
