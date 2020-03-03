package happe.marco.petclinic.controllers;

import happe.marco.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vets")
public class VetsController {

    private final VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "/index", "/ownerIndex.html"})
    public String vetList(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/vetIndex";
    }
}
