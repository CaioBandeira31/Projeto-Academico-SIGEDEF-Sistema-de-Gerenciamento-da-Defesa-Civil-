package edu.sistema.sigedef;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
public class TelefoneSmsController {
  
  @Autowired 
  private TelefoneRepository telefoneRepository;

  int[] valorSms = new int[5];
  TelefoneSms telefone_cidadao = new TelefoneSms();
  int smsValido;


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
  TelefoneSms sms = new TelefoneSms();
  valorSms = sms.gerarCodigo();
  for (int i = 0; i < valorSms.length; i++) {
    System.out.println(valorSms[i]);
  }
  smsValido = 0;
  container.addAttribute("smsValido", smsValido);
    return "/desenvolvimento/pagina-confirmar-numero-telefone.html";
}

@PostMapping("conftel")
public String postMethodName(@RequestParam String codigo1, @RequestParam String codigo2, @RequestParam String codigo3, @RequestParam String codigo4, @RequestParam String codigo5, Model container) {
  int[] codigo = new int[5];
  codigo[0] = Integer.parseInt(codigo1);
  codigo[1] = Integer.parseInt(codigo2);
  codigo[2] = Integer.parseInt(codigo3);
  codigo[3] = Integer.parseInt(codigo4);
  codigo[4] = Integer.parseInt(codigo5);
  
  if ((codigo[0] == valorSms[0]) && (codigo[1] == valorSms[1]) && (codigo[2] == valorSms[2]) && (codigo[3] == valorSms[3]) && (codigo[4] == valorSms[4])) {
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

}
