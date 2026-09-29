package edu.sistema.sigedef;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GenericController {

@GetMapping("/")
public String desenvolvimento(){

    return "/desenvolvimento/teste.html";
}


@GetMapping("ea")
public String envioAlerta(){
    return "/desenvolvimento/pagina-envio-alertas.html";
}

@GetMapping("pa")
public String popupAlerta() {
    return "/desenvolvimento/formulario-popup-envio-alertas.html";
}

@GetMapping("faq")
public String getMethodName() {
    return "/desenvolvimento/faq.html";
}

 
}
