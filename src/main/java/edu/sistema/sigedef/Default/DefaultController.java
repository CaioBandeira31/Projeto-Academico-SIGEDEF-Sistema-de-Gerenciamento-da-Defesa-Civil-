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

// pagina inicial
@GetMapping("/")
public String paginaInicial(Model model) {

    model.addAttribute("paginaAtual", "/");
    return "default/pagina-inicio.html";
}

@GetMapping("termos")
public String getMethodName() {

    return "default/termos.html";
}

@GetMapping("nova-denuncia")
public String novaDenuncia(Model container) {
    container.addAttribute("paginaAtual", "novaDenuncia");
    return "default/formulario-denuncia.html";
}

@GetMapping("informacao-denuncia")
public String informacoesDenuncia(Model container){
    return"desenvolvimento/pagina-pesquisa-denuncia.html";
}
}
