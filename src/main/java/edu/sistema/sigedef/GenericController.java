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

@GetMapping("previsao")
public String previsao() {
    return "/desenvolvimento/pagina-previsao-do-tempo.html";
}

@GetMapping("faq")
public String faq() {
    return "/desenvolvimento/faq.html";
}

@GetMapping("tel")
public String formTelefone() {
    return "/desenvolvimento/formulario-telefone-receber-alertas.html";
}

@GetMapping("conftel")
public String confTelefone() {
    return "/desenvolvimento/pagina-confirmar-numero-telefone.html";
}

 
}
