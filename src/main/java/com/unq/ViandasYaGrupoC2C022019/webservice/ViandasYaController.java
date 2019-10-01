package com.unq.ViandasYaGrupoC2C022019.webservice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViandasYaController {

    @GetMapping("/")
    public String holaMundo(Model model) {
        return "index";
    }
}
