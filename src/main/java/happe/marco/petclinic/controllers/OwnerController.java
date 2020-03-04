package happe.marco.petclinic.controllers;

import happe.marco.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/ownerIndex.html"})
    public String listOfOwners(Model model){

        model.addAttribute("owners", ownerService.findAll());
        return "owners/ownerIndex";
    }

    @RequestMapping("/find")
    public String findOwners(){
        return "notImplemented";
    }
}
