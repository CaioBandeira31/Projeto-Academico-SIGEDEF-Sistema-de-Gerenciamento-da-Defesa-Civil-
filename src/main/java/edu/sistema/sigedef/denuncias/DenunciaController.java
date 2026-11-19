package edu.sistema.sigedef.denuncias;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
public class DenunciaController {

    @GetMapping("gestao-denuncias")
public String gestaoDenuncias(Model container) {

    container.addAttribute("paginaAtual", "denuncias");

    
    return "desenvolvimento/pagina-gestao-denuncias.html";
}

@GetMapping("denuncia")
public String detalhesDenuncia() {

    return "desenvolvimento/detalhes-denuncia.html";
}


}
