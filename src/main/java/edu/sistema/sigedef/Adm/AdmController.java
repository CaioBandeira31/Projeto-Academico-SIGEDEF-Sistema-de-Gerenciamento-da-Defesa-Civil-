package edu.sistema.sigedef.Adm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller 
public class AdmController {

@GetMapping("dashboard")
public String paginaDashboard(Model model) {
    model.addAttribute("paginaAtual", "dashboard");
    return "adm/pagina-dashboard.html";
}



}
