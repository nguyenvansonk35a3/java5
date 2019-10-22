package edu.nguyenvanson.controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.nguyenvanson.domain.Department;
import edu.nguyenvanson.services.DepartmentService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping(value = "/departments")
public class DepartmentController {

    @RequestMapping()
    @ResponseBody
    public String hello() {
        return " this is department";
    }

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(ModelMap model) {
        List<Department> list = new ArrayList<>();
        List<edu.nguyenvanson.models.Department> departments = departmentService.findAll();
        for (edu.nguyenvanson.models.Department department : departments) {
            Department dpt = new Department();
            dpt.setIdDepartment(department.getIdDepartment());
            dpt.setNameDepartment(department.getNameDeprtment());

            list.add(dpt);
        }
        model.addAttribute("departments", list);

        return "departments/view";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap model) {
        model.addAttribute("department", new Department());
        return "departments/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid Department department, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("department", department);
            return "departments/add";
        }
        model.addAttribute("message", "New user has been inserted!");
        System.out.println(department.getIdDepartment());
        model.addAttribute("department", new Department());

        edu.nguyenvanson.models.Department drt = new edu.nguyenvanson.models.Department();
        drt.setIdDepartment(department.getIdDepartment());
        drt.setNameDeprtment(department.getNameDepartment());

        departmentService.save(drt);

        return "departments/add";
    }

    @RequestMapping(value = "/edit/{idDepartment}", method = RequestMethod.GET)
    public String edit(@PathVariable(name = "idDepartment") String idDepartment, ModelMap model) {
        List<Department> list = new ArrayList<>();
        Optional<edu.nguyenvanson.models.Department> department = departmentService.findById(idDepartment);
        Department dpr = new Department();
        if (department.isPresent()) {
            dpr.setIdDepartment(department.get().getIdDepartment());
            dpr.setNameDepartment(department.get().getNameDeprtment());
        }
        model.addAttribute("department", dpr);
        return "departments/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(ModelMap model, Department department) {
        edu.nguyenvanson.models.Department dpr = new edu.nguyenvanson.models.Department();
        dpr.setIdDepartment(department.getIdDepartment());
        dpr.setNameDeprtment(department.getNameDepartment());

        departmentService.save(dpr);
        return "redirect:/departments/view";
    }

    @RequestMapping(value = "/delete/{idDepartment}", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "idDepartment") String idDepartment) {
        departmentService.deleteById(idDepartment);
        return "redirect:/departments/view";
    }
}
