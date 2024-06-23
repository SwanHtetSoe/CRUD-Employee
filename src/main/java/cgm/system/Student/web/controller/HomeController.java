package cgm.system.Student.web.controller;

import cgm.system.Student.bl.service.StudentService;
import cgm.system.Student.persistance.dao.StudentDAO;
import cgm.system.Student.persistance.entity.Student;
import cgm.system.Student.web.form.StudentForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private StudentService studentService;

    @Autowired
    public StudentDAO studentDAO;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String goTOHomePage(){
        return "home";
    }

    @RequestMapping(value="/register",method = RequestMethod.GET)
    public ModelAndView goToRegisterPage(){
        StudentForm studentForm = new StudentForm();
        ModelAndView model = new ModelAndView("register");
        model.addObject("studentForm",studentForm);
        return model;
    }

    @PostMapping(value="/success")
    public ModelAndView saveUserList(@ModelAttribute("studentForm") StudentForm studentForm){
        ModelAndView model = new ModelAndView("insert");
        this.studentService.doSaveStudent(studentForm);
        return model;
    }

    @RequestMapping(value="/userList",method = RequestMethod.GET)
    public ModelAndView showUserList(){
        ModelAndView model = new ModelAndView("success");
        List<Student> studentList = studentDAO.findAll();
        model.addObject ("students",studentList);
        return model;
    }


    @RequestMapping(value="/update",method = RequestMethod.GET)
    public ModelAndView goToUpdatePage(@ModelAttribute StudentForm updateForm){
        ModelAndView model = new ModelAndView("update");
        model.addObject("updateForm",updateForm);
        return model;
    }

    @PostMapping(value="/update-success")
    public ModelAndView updateUserList(@ModelAttribute("updateForm") StudentForm updateForm){
        ModelAndView model = new ModelAndView("update-success");
        this.studentService.doUpdateStudent(updateForm);
        return model;
    }

    @RequestMapping(value="/delete",method = RequestMethod.GET)
    public ModelAndView goToDeletePage(@ModelAttribute StudentForm deleteForm){
        ModelAndView model = new ModelAndView("delete");
        model.addObject("deleteForm",deleteForm);
        return model;
    }

    @PostMapping(value="/delete-success-ornot")
    public String deleteUserList(@ModelAttribute("deleteForm") StudentForm deleteForm){
        if (this.studentService.doDeleteStudent(deleteForm)) {
            return "/delete-Success";
        } else {
            return "/delete-Error";
        }
    }


}
