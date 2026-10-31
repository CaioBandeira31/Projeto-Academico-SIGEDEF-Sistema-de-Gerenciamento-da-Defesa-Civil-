package edu.sistema.sigedef.Adm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller 
public class AdmController {

@GetMapping("dashboard")
public String paginaDashboard() {
    return "adm/pagina-dashboard.html";
}


// @PostMapping("path")
// public String postMethodName(@RequestBody String entity) {
//     //TODO: process POST request
    
//     return entity;
// }



}
