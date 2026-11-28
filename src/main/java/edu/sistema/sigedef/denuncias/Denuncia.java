package edu.sistema.sigedef.denuncias;

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

@Entity
@Table(name="")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String protocolo;
    
    @Column(name="bairro")
    private String bairro = " ";

    @Column(name="cidade")
    private String cidade = " ";

    @Column(name="cep")
    private String cep = " ";

    @Column(name="endereco")
    private String endereco;

    @Column(name="ponto_referencia")
    private String ponto_referencia = " ";

    @Column(name="tipo_ocorrencia")
    private String tipo_ocorrencia = " ";

    @Column(name="descricao_denuncia")
    private String descricao_denuncia = " "; 

    @Column(name="anonimo", columnDefinition = "TINYINT(1)")
    private int anonimo;

    @Column(name="nome")
    private String nome = " ";

    @Column(name="telefone")
    private String telefone = " ";

    @Column(name="data_hora")
    private LocalDateTime data_hora;
    
    @Column(name="situacao")
    private String situacao = " ";

    @Column(name="nivel_risco")
    private String nivel_risco = " ";

    @ManyToOne
    @JoinColumn(name = "agente_matricula", nullable = true)
    private Usuario agente;

    protected Denuncia(){

    }

    public Denuncia(String protocolo, String bairro, String cidade, String cep, String ponto_referencia, String tipo_ocorrencia, int anonimo, String nome, String telefone, LocalDateTime data_hora, String situacao, String nivel_risco, Usuario agente_matricula, String descricao_denuncia, String endereco){

        this.protocolo = protocolo;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.ponto_referencia = ponto_referencia;
        this.tipo_ocorrencia = tipo_ocorrencia;
        this.anonimo = anonimo;
        this.nome = nome;
        this.telefone = telefone;
        this.data_hora = data_hora;
        this.situacao = situacao;
        this.nivel_risco = nivel_risco;
        this.agente = agente_matricula;
        this.descricao_denuncia = descricao_denuncia;
        this.endereco = endereco;

    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }
    public String getProtocolo() {
        return protocolo;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPonto_referencia() {
        return ponto_referencia;
    }

    public void setPonto_referencia(String ponto_referencia) {
        this.ponto_referencia = ponto_referencia;
    }

    public String getTipo_ocorrencia() {
        return tipo_ocorrencia;
    }
    public void setTipo_ocorrencia(String tipo_ocorrencia) {
        this.tipo_ocorrencia = tipo_ocorrencia;
    }

    public void setAnonimo(int anonimo) {
        this.anonimo = anonimo;
    }
    public int getAnonimo() {
        return anonimo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }
    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public String getSituacao() {
        return situacao;
    }

    public void setNivel_risco(String nivel_risco) {
        this.nivel_risco = nivel_risco;
    }
    public String getNivel_risco() {
        return nivel_risco;
    }

    public void setAgente(Usuario agente) {
        this.agente = agente;
    }
    public Usuario getAgente() {
        return agente;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setDescricao_denuncia(String descricao_denuncia) {
        this.descricao_denuncia = descricao_denuncia;
    }
    public String getDescricao_denuncia() {
        return descricao_denuncia;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEndereco() {
        return endereco;
    }
}
