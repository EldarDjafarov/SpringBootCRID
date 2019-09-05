package trainingProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import trainingProject.model.Department;
import trainingProject.model.Employer;


import trainingProject.services.depServices.IDepService;
import trainingProject.services.emplServices.IEmplService;

import javax.validation.Valid;
import java.util.List;



@Controller()
public class MainController {


    @Autowired
    private IDepService depService;

    @Autowired
    private IEmplService emplService;



    @GetMapping("/")
    public String listOfAllDepartments(ModelMap modelMap) {
        List<Department> departments = depService.getAllDepartments();
        modelMap.addAttribute("departments", departments);
        modelMap.addAttribute("employer", new Employer());
        modelMap.addAttribute("department", new Department());
        return "main";
    }

    @PostMapping("/add")
    public String addEmployer(@Valid Employer employer, String dpName) {
       if (depService.getDeparmentByName(dpName) == null) {
           Department department = new Department(dpName);
           depService.addDepartment(department);
           employer.setDptId(depService.getDeparmentByName(dpName).getDpId());
           emplService.addEmployer(employer);
           return "redirect:/";
       } else {
           employer.setDptId(depService.getDeparmentByName(dpName).getDpId());
        emplService.addEmployer(employer);
           return "redirect:/";
    }

}

   @GetMapping("/edit/{id}")
    public String getEmployer(@PathVariable("id") int id,
                              ModelMap model) {
        Employer employer= emplService.getEmployerById(id);
        model.addAttribute("employer",employer);
        model.addAttribute("department",depService.getDeparmentById(employer.getDptId()));
        return "update";

    }


    @PostMapping("/update/{id}")
    public String editEmployer(@PathVariable("id") long id, @Valid  Employer employer,String dpName
            , ModelMap model) {
        if (depService.getDeparmentByName(dpName) == null) {
            Department department = new Department(dpName);
            depService.addDepartment(department);
            employer.setDptId(depService.getDeparmentByName(dpName).getDpId());
            emplService.updateEmployer(employer, id);
            return "redirect:/";
        } else {
            employer.setDptId(depService.getDeparmentByName(dpName).getDpId());
            emplService.updateEmployer(employer, id);
            return "redirect:/";


        }
    }



    @GetMapping("/delete/{id}")
    public String deleteEmployer(@PathVariable("id") long id) {
        emplService.deleteEmployer(id);
         return "redirect:/";

}
    }



