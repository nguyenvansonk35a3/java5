/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nguyenvanson.controllers;

import edu.nguyenvanson.domain.SparePart;
import edu.nguyenvanson.services.SparePartService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/spareParts")
public class SparePartController {
    
    @Autowired
    private SparePartService sparePartService;
    
     @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(ModelMap model) {
        List<SparePart> list = new ArrayList<>();
        List<edu.nguyenvanson.models.SparePart> spareParts = sparePartService.findAll();
        for (edu.nguyenvanson.models.SparePart sparePart : spareParts) {
            SparePart sp = new SparePart();
            sp.setIdSparePart(sparePart.getIdSparePart());
            sp.setNameSparePart(sparePart.getNameSparePart());
            sp.setQuantity(sparePart.getQuantity());
            sp.setPrice(sparePart.getPrice());
            sp.setMenuDate(sparePart.getMenuDate());
            sp.setDescription(sparePart.getDescription());

            list.add(sp);
        }
        model.addAttribute("spareParts", list);
        
        return "spareParts/view";
    }
    
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap model) {
        model.addAttribute("sparePart", new SparePart());
        return "spareParts/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid SparePart sparePart, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("sparePart", sparePart);
            return "spareParts/add";
        }
        model.addAttribute("message", "New user has been inserted!");
        System.out.println(sparePart.getIdSparePart());
        model.addAttribute("sparePart", new SparePart());

        edu.nguyenvanson.models.SparePart sp = new edu.nguyenvanson.models.SparePart();
        sp.setIdSparePart(sparePart.getIdSparePart());
        sp.setNameSparePart(sparePart.getNameSparePart());
        sp.setQuantity(sparePart.getQuantity());
        sp.setPrice(sparePart.getPrice());
        sp.setMenuDate(sparePart.getMenuDate());
        sp.setDescription(sparePart.getDescription());

        sparePartService.save(sp);
        return "spareParts/add";
    }
    
    @RequestMapping(value = "/delete/{idSparePart}", method = RequestMethod.GET)
    public String delete(@PathVariable(name="idSparePart") String idSparePart){
        sparePartService.deleteById(idSparePart);
        return "redirect:/spareParts/view";
    }
}
