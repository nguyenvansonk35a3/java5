package edu.nguyenvanson.controllers;

import edu.nguyenvanson.services.StaffService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.nguyenvanson.domain.Staff;
import edu.nguyenvanson.models.Department;
import edu.nguyenvanson.services.DepartmentService;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/staffs")
public class StaffController {

    @RequestMapping
    @ResponseBody
    public String helloStaff(){
        return "hello staff";
    }
    
    @Autowired
    private  StaffService staffService;
    
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(ModelMap model) {
        List<Staff> list = new ArrayList<>();
        List<edu.nguyenvanson.models.Staff> staffs = staffService.findAll();
        for (edu.nguyenvanson.models.Staff staff : staffs) {
            Staff sfr = new Staff();
            sfr.setIdStaff(staff.getIdStaff());
            sfr.setNameStaff(staff.getNameStaff());
            sfr.setGender(staff.getGender());
            sfr.setBirthday(staff.getBirthday());
            sfr.setPhone(staff.getPhone());
            sfr.setEmail(staff.getEmail());
            sfr.setSalary(staff.getSalary());
            sfr.setNote(staff.getNote());
            sfr.setDepartment(new edu.nguyenvanson.domain.Department(staff.getDepartment().getIdDepartment(), staff.getDepartment().getNameDeprtment()));
            
            list.add(sfr);
        }
        model.addAttribute("staffs", list);
        return "staffs/view";
    }
    
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap model) {
        model.addAttribute("staff", new Staff());
        model.addAttribute("department",departmentService.findAll());
        return "staffs/add";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid Staff staff, BindingResult bindingResult, ModelMap model, @RequestParam String idDepartment) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("staff", staff);
            return "staffs/add";
        }
        model.addAttribute("message", "New staff has been inserted!");
        System.out.println(staff.getIdStaff());
        model.addAttribute("staff", new Staff());

        edu.nguyenvanson.models.Staff sfr = new edu.nguyenvanson.models.Staff();
        sfr.setIdStaff(staff.getIdStaff());
        sfr.setNameStaff(staff.getNameStaff());
        sfr.setGender(staff.getGender());
        sfr.setBirthday(staff.getBirthday());
        sfr.setPhone(staff.getPhone());
        sfr.setEmail(staff.getEmail());
        sfr.setSalary(staff.getSalary());
        sfr.setNote(staff.getNote());
        sfr.setDepartment(new Department(idDepartment, null));

        staffService.save(sfr);
        
        return "staffs/add";
    }
    
    @RequestMapping(value = "/edit/{idStaff}", method = RequestMethod.GET)
    public String edit(@PathVariable(name = "idStaff") String idStaff, ModelMap model) {
        List<Staff> list = new ArrayList<>();
        Optional<edu.nguyenvanson.models.Staff> staff = staffService.findById(idStaff);
        Staff stf = new Staff();
        if (staff.isPresent()) {
            stf.setIdStaff(staff.get().getIdStaff());
            stf.setNameStaff(staff.get().getNameStaff());
            stf.setGender(staff.get().getGender());
            stf.setBirthday(staff.get().getBirthday());
            stf.setPhone(staff.get().getPhone());
            stf.setEmail(staff.get().getEmail());
            stf.setSalary(staff.get().getSalary());
            stf.setNote(staff.get().getNote());
            stf.setDepartment(new edu.nguyenvanson.domain.Department(staff.get().getDepartment().getIdDepartment(), staff.get().getDepartment().getNameDeprtment()));
        }
        model.addAttribute("department",departmentService.findAll());
        model.addAttribute("staff", stf);
        return "staffs/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(ModelMap model, Staff staff, @RequestParam String idDepartment) {
        edu.nguyenvanson.models.Staff stf = new edu.nguyenvanson.models.Staff();
        stf.setIdStaff(staff.getIdStaff());
        stf.setNameStaff(staff.getNameStaff());
        stf.setGender(staff.getGender());
        stf.setBirthday(staff.getBirthday());
        stf.setPhone(staff.getPhone());
        stf.setEmail(staff.getEmail());
        stf.setSalary(staff.getSalary());
        stf.setNote(staff.getNote());
//        stf.setDepartment(new Department(staff.getDepartment().getIdDepartment(), staff.getDepartment().getNameDepartment()));
        stf.setDepartment(new Department(idDepartment, null));

        staffService.save(stf);
        return "redirect:/staffs/view";
    }
    
    
    @RequestMapping(value = "/delete/{idStaff}", method = RequestMethod.GET)
    public String delete(@PathVariable(name="idStaff") String idStaff){
        staffService.deleteById(idStaff);
        return "redirect:/staffs/view";
    }
}
