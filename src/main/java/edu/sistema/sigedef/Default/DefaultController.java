package edu.sistema.sigedef.Default;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class DefaultController {

// pagina de faq
@GetMapping("faq")
public String paginaFaq() {
    return "default/faq.html";
}

// pagina de login
@GetMapping("login")
public String paginaLogin(Model model) {
    model.addAttribute("paginaAtual", "login");
    return "default/pagina-login.html";
}

}
