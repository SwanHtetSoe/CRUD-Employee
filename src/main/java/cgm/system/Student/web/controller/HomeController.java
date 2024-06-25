package cgm.system.Student.web.controller;

import cgm.system.Student.bl.service.EmployeeService;
import cgm.system.Student.persistance.dao.EmployeeDAO;
import cgm.system.Student.persistance.entity.Employee;
import cgm.system.Student.web.form.EmployeeForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    public EmployeeDAO employeeDAO;
    
    @RequestMapping(value="/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeDAO.findAll());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") EmployeeForm employeeForm) {
        employeeService.doSaveEmployee(employeeForm);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

}
