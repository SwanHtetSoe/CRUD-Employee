package cgm.system.Student.bl.service;

import cgm.system.Student.persistance.dao.StudentDAO;
import cgm.system.Student.persistance.entity.Student;
import cgm.system.Student.web.form.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public void doSaveStudent(StudentForm studentForm){
        Student student = new Student(studentForm);
        this.studentDAO.save(student);
    }

    @Override
    public void doUpdateStudent(StudentForm studentForm) {
        Student student = new Student(studentForm);
        this.studentDAO.save(student);
    }

    @Override
    public boolean doDeleteStudent(StudentForm studentForm) {
        if (this.studentDAO.existsById(studentForm.getStudentId())) {
            this.studentDAO.deleteById(studentForm.getStudentId());
            return true;
        }
        return false;
    }

}
