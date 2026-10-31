package edu.sistema.sigedef.Alertas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sistema.sigedef.Adm.Usuario;
import edu.sistema.sigedef.Adm.UsuarioRepository;
import edu.sistema.sigedef.Validacoes.GeradorSenha;

import org.springframework.web.bind.annotation.PostMapping;



@Controller 
public class ControllerAlertas {

    @Autowired
    AlertasRepository repoAlerta;

    @Autowired
    UsuarioRepository repoUsuario;

    // CARREGANDO A PÁGINA DE ALERTAS
    @GetMapping("alertas")
    public String paginaDeAlertas(Model model) {
        model.addAttribute("alerta", new Alerta());

        List<Alerta> alertas = new ArrayList<>();

        alertas = repoAlerta.listarAlertas();

        model.addAttribute("alertas", alertas);

        model.addAttribute("paginaAtual", "alertas");

        return "/agente/pagina-envio-alertas.html";
    }

    // ENVIANDO PARA OS TELEFONE CADASTRADOS E SALVANDO OS ALERTAS NO HISTORICO
    @PostMapping("novo-alerta")
    public String postMethodName(@RequestParam String titulo, @RequestParam String mensagem) {
        
        Usuario agente = repoUsuario.buscarUm("3044408");

        Alerta alerta = new Alerta(titulo, mensagem, agente);

        repoAlerta.novoAlerta(alerta);

        return "redirect:alertas";
    }

    @GetMapping("excluir-alertas")
    public String getMethodName() {

        repoAlerta.excluirHistorico();

        return "redirect:alertas";
    }
    

}
