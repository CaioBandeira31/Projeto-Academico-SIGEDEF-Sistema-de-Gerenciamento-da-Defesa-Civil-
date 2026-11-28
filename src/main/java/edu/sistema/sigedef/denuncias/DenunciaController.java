package edu.sistema.sigedef.denuncias;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller 
public class DenunciaController {
    @Autowired
    DenunciaRepository repoDenuncia;


    @GetMapping("gestao-denuncias")
    public String gestaoDenuncias(Model container) {

        List <Denuncia> denuncias = new ArrayList<>();
        denuncias = repoDenuncia.listarDenuncias();

        container.addAttribute("total", repoDenuncia.Count());
        container.addAttribute("analise", repoDenuncia.countAnalise());
        container.addAttribute("andamento", repoDenuncia.countAndamento());
        container.addAttribute("resolvida", repoDenuncia.countResolvidas());
        container.addAttribute("denuncias", denuncias);
        container.addAttribute("paginaAtual", "denuncias");

        
        return "desenvolvimento/pagina-gestao-denuncias.html";
    }

// salvando a denuncia
    @PostMapping("salvar-denuncia")
    public String salvarDenuncia(@RequestParam String endereco,@RequestParam String bairro,@RequestParam String cidade,@RequestParam String cep, @RequestParam String ponto_referencia,@RequestParam int anonimo, @RequestParam  String tipo_ocorrencia, @RequestParam String descricao_denuncia,@RequestParam String nome, @RequestParam String telefone, Model model ) {
        
        LocalDateTime data_hora = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        Denuncia novaDenuncia = new Denuncia();

        String protocolo= "#"+data_hora.getYear()+(repoDenuncia.Count()+1);
        protocolo.trim();

        novaDenuncia.setProtocolo(protocolo);
        novaDenuncia.setBairro(bairro);
        novaDenuncia.setCidade(cidade);
        novaDenuncia.setCep(cep);
        novaDenuncia.setPonto_referencia(ponto_referencia);
        novaDenuncia.setTipo_ocorrencia(tipo_ocorrencia);
        novaDenuncia.setDescricao_denuncia(descricao_denuncia);
        novaDenuncia.setAnonimo(anonimo);
        novaDenuncia.setNome(nome);
        novaDenuncia.setTelefone(telefone);
        novaDenuncia.setData_hora(data_hora);
        novaDenuncia.setEndereco(endereco);
        novaDenuncia.setSituacao("Em Análise");
        novaDenuncia.setNivel_risco("A Definir");
        novaDenuncia.setAgente(null);

        repoDenuncia.novaDenuncia(novaDenuncia);

        model.addAttribute("protocolo", protocolo);

        return "desenvolvimento/tela-protocolo.html";
    }


    @GetMapping("desenvolvimento")
    public String getMethodName() {
        return "desenvolvimento/tela-protocolo.html";
    }
    

    @GetMapping("denuncia/editar/{id}")
    public String detalhesDenuncia(@PathVariable("id") int id, Model container) {

        Denuncia denuncia = repoDenuncia.buscarUma(id);

        container.addAttribute("denuncia", denuncia);

        return "desenvolvimento/detalhes-denuncia.html";
    }


    @PostMapping("denuncia/salvar")
    public String postMethodName(@RequestParam int id, @RequestParam(required = false) String nivel_risco, @RequestParam(required = false) String situacao) {
        
        Denuncia denuncia = repoDenuncia.buscarUma(id);

        if (situacao == null) {
            situacao = denuncia.getSituacao();
        }
        if(nivel_risco == null){
            nivel_risco = denuncia.getNivel_risco();
        }

        repoDenuncia.editandoDenuncia(id, nivel_risco, situacao);

        return "redirect:/gestao-denuncias";
    }
    
    @PostMapping("pesquisar-denuncia")
    public String postMethodName(@RequestParam String pesquisa, RedirectAttributes visao) {
        Denuncia denuncia = new Denuncia();

        System.out.println(denuncia.getAnonimo());

        denuncia = repoDenuncia.buscarUmaProtocolo(pesquisa);

        if (denuncia.getAnonimo() == 0) {
            denuncia.setDescricao_denuncia("Denuncia Anônima");
        }else{
            denuncia.setDescricao_denuncia(denuncia.getNome());
        }

        System.out.println(denuncia.getData_hora());

        visao.addFlashAttribute("denuncia",denuncia);

        return "redirect:/informacao-denuncia";
    }
    


    @PostMapping("pesquisa-filtro")
    public String pesquisaFiltro(@RequestParam(required = false) String protocolo, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate dataInicio,@RequestParam(required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate dataFim,@RequestParam(required = false) String situacao,@RequestParam(required = false) String nivelRisco,@RequestParam(required = false) String tipoOcorrencia,RedirectAttributes visao) {

        List<Denuncia> denuncias;

        if (protocolo != null && !protocolo.isBlank()) {

            denuncias = repoDenuncia.buscarListaProtocolo(protocolo);

        } else {

            LocalDateTime inicio = dataInicio != null
                    ? dataInicio.atStartOfDay()
                    : null;

            LocalDateTime fim = dataFim != null
                    ? dataFim.plusDays(1).atStartOfDay()
                    : null;

            denuncias = repoDenuncia.buscarPorFiltros(
                    inicio,
                    fim,
                    situacao,
                    nivelRisco,
                    tipoOcorrencia
            );
        }

        visao.addFlashAttribute("denuncias", denuncias);

    return "redirect:/denuncias/filtrado";
    }
    

    @GetMapping("denuncias/filtrado")
    public String denunciasFiltrado(Model container) {

        container.addAttribute("total", repoDenuncia.Count());
        container.addAttribute("analise", repoDenuncia.countAnalise());
        container.addAttribute("andamento", repoDenuncia.countAndamento());
        container.addAttribute("resolvida", repoDenuncia.countResolvidas());
        container.addAttribute("paginaAtual", "denuncias");

    return "desenvolvimento/pagina-gestao-denuncias.html";
    }
    


}
