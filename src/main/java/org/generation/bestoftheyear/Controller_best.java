package org.generation.bestoftheyear;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class Controller_best {
    @GetMapping("/home")
    public String home(Model model) {
        int anno = 2023;
        String nome = "Matteo";

        model.addAttribute("anno", anno);
        model.addAttribute("nome", nome);

        return "home";
    }
}
