package edu.sistema.sigedef;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class GenericController {


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
public String getMethodName() {
    return "/desenvolvimento/faq.html";
}

@GetMapping("/dashboard")
public String testeDash(){
    return "desenvolvimento/pagina-dashboard.html";
}


}
