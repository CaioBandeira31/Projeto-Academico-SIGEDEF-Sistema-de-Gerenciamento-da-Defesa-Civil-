package edu.sistema.sigedef;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenericController {

@GetMapping("/")
public String desenvolvimento(){

    return "/desenvolvimento/teste.html";
}

@GetMapping("/faq")
public String TelaFaq(){
    return"/desenvolvimento/faq.html";
} 

}
