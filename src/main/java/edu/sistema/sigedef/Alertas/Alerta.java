package edu.sistema.sigedef.Alertas;

import java.time.LocalDateTime;

import edu.sistema.sigedef.Adm.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="alerta")
public class Alerta {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_alerta;

    @NotBlank(message = "Titulo é obrigatório")
    @Column(name="titulo")
    private String titulo;

    @NotBlank(message = "Mensagem Obrigatória")
    @Column(name="mensagem")
    private String mensagem;

    @Column(name = "data_hora")
    LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "matricula_agente")
    private Usuario agente;

    protected Alerta (){

    }

    public Alerta (String titulo, String mensagem, Usuario agente){
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.agente = agente;
    }

    public void setId_alerta(int id_alerta) {
        this.id_alerta = id_alerta;
    }
    public int getId_alerta() {
        return id_alerta;
    }


    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public String getMensagem() {
        return mensagem;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }


    public void setAgente(Usuario agente) {
        this.agente = agente;
    }
    public Usuario getAgente() {
        return agente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    

}
