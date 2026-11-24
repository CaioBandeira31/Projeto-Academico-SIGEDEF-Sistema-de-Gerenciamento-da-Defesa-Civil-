package edu.sistema.sigedef.Default;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
public class LoginController {
  @GetMapping("login")
  public String login(/*Model model*/) {
    // model.addAttribute("paginaAtual", "login");

    return "/auth/pagina-login.html";
  }

  @GetMapping("logout")
  public String logout() {
      return "/auth/pagina-logout.html";
  }
  
  
}
