package edu.sistema.sigedef;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenericController {

@GetMapping("/")
public String desenvolvimento(){

    return "/desenvolvimento/pagina-previsao-do-tempo.html";
}


@GetMapping("/ea")
public String envioAlerta(){
    return "/desenvolvimento/pagina-envio-alertas.html";
}
 
}
