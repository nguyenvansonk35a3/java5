package edu.nguyenvanson.controllers;

import edu.nguyenvanson.models.Record;
import edu.nguyenvanson.models.Staff;
import edu.nguyenvanson.services.RecordService;
import edu.nguyenvanson.services.StaffService;
import java.util.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/records")
public class RecordController {

    @RequestMapping()
    @ResponseBody
    public String hello() {
        return "this is records";
    }

    @Autowired
    private RecordService recordService;
    
    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    private String view(ModelMap model) {
        List<Record> list = recordService.findAll();
//        List<edu.nguyenvanson.models.Record> records = recordService.findAll();
//        for (edu.nguyenvanson.models.Record record : records) {
//
//            Record rc = new Record();
//            rc.setIdRecord(record.getIdRecord());
//            rc.setType(record.getType());
//            rc.setReason(record.getReason());
//            rc.setDate(record.getDate());
////            rc.setIdStaff(record.getIdStaff());
////            rc.setStaff(new edu.nguyenvanson.domain.Staff(record.getStaff().getIdStaff(), record.getStaff().getNameStaff(), record.getStaff().getGender(), record.getStaff().getBirthday(), record.getStaff().getPhone(), record.getStaff().getEmail(), record.getStaff().getSalary(), record.getStaff().getNote()));
//            rc.setStaff(new edu.nguyenvanson.domain.Staff(record.getStaff().get)
//                
//            
//            list.add(rc);
//        }
        model.addAttribute("records", list);

        return "records/view";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap model) {
        model.addAttribute("record", new Record());
        model.addAttribute("staff", staffService.findAll());
        return "records/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid Record record, BindingResult bindingResult,@RequestParam String idStaff, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("record", record);
            return "records/add";
        }
        model.addAttribute("message", "New record has been inserted!");
        System.out.println(record.getIdRecord());
        model.addAttribute("record", new Record());

        edu.nguyenvanson.models.Record rc = new edu.nguyenvanson.models.Record();
        rc.setIdRecord(record.getIdRecord());
        rc.setType(record.getType());
        rc.setReason(record.getReason());
        rc.setDate(record.getDate());
//        rc.setIdStaff(record.getIdStaff());
        rc.setStaff(new Staff(idStaff));

        recordService.save(rc);
        return "records/add";
    }

    @RequestMapping(value = "/edit/{idRecord}", method = RequestMethod.GET)
    public String edit(@PathVariable(name = "idRecord") String idRecord, ModelMap model) {
        List<Record> list = new ArrayList<>();
        Optional<edu.nguyenvanson.models.Record> record = recordService.findById(idRecord);
        Record rd = new Record();
        if (record.isPresent()) {
            rd.setIdRecord(record.get().getIdRecord());
            rd.setType(record.get().getType());
            rd.setReason(record.get().getReason());
            rd.setDate(record.get().getDate());
//            rd.setIdStaff(record.get().getIdStaff());
            rd.setStaff(new Staff(record.get().getStaff().getIdStaff()));

        }
        model.addAttribute("staff", staffService.findAll()); //new
        model.addAttribute("record", rd);
        
        return "records/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(ModelMap model, Record record, @RequestParam String idStaff) {
        edu.nguyenvanson.models.Record rd = new edu.nguyenvanson.models.Record();
        rd.setIdRecord(record.getIdRecord());
        rd.setType(record.getType());
        rd.setReason(record.getReason());
        rd.setDate(record.getDate());
//        rd.setIdStaff(record.getIdStaff());
//        rd.setStaff(new Staff(record.getStaff().getIdStaff()));
        rd.setStaff(new Staff(idStaff));

        recordService.save(rd);
        return "redirect:/records/view";
    }

    @RequestMapping(value = "/delete/{idRecord}", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "idRecord") String idRecord) {
        recordService.deleteById(idRecord);
        return "redirect:/records/view";
    }

}
