package happe.marco.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "ownerIndex.html"})
    public String indexController(){
        return "index";
    }
}
