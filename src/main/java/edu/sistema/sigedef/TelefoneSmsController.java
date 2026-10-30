package edu.sistema.sigedef;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
public class TelefoneSmsController {
  
  @Autowired 
  private TelefoneRepository telefoneRepository;

  String valorSms;
  TelefoneSms telefone_cidadao = new TelefoneSms();
  int smsValido;

  private final SmsSender smsSender;

  public TelefoneSmsController(@Qualifier("smsbarato") SmsSender smsSender){
    this.smsSender = smsSender;
  }


  @GetMapping("tel")
public String telefone(Model container) {
  container.addAttribute("telCadastrado", false);

    return "/desenvolvimento/formulario-telefone-receber-alertas.html";
}

@PostMapping("formtel")
public String formTelefone(@RequestParam String num_telefone, Model container) {
    telefone_cidadao.setNum_Telefone(num_telefone);
    boolean teste = telefoneRepository.verificar(telefone_cidadao);

    if(teste == true) {
      container.addAttribute("telCadastrado", teste);
        return "/desenvolvimento/formulario-telefone-receber-alertas.html";
    } else {
    return "redirect:/smstel";
    }
}


@GetMapping("smstel")
public String confTelefone(Model container) {
  valorSms = telefone_cidadao.gerarCodigo();
  System.out.println(valorSms);
  smsSender.envioSms(telefone_cidadao);
  smsValido = 0;
  container.addAttribute("smsValido", smsValido);
    return "/desenvolvimento/pagina-confirmar-numero-telefone.html";
}

@PostMapping("conftel")
public String postMethodName(@RequestParam String codigo1, @RequestParam String codigo2, @RequestParam String codigo3, @RequestParam String codigo4, @RequestParam String codigo5, Model container) {
  
  String codigo = codigo1 + codigo2 + codigo3 + codigo4 + codigo5;
  System.out.println(codigo);
  
  if (codigo.equals(valorSms)) {
    telefoneRepository.salvar(telefone_cidadao);
    smsValido = 1;
    container.addAttribute("smsValido", smsValido);
    
    return "/desenvolvimento/pagina-confirmar-numero-telefone.html";
  
  } else {
    smsValido = 2;
    container.addAttribute("smsValido", smsValido);
    return "/desenvolvimento/pagina-confirmar-numero-telefone.html";
  }
 
}

// Rota aaixo usada somente para teste, se for preciso altera-la ou apaga-la, ficar a vontade
@GetMapping("popup")
public String popUp() {
    return "/desenvolvimento/teste-pop-up.html";
}

}
