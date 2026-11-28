package edu.sistema.sigedef.Adm;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    private String matricula;

    @Column(name = "nome")
    private  String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(unique = true, name = "cpf")
    private String cpf;

    @Column(name = "adm")
    private  String adm;

    @Column(name = "senha")
    private String senha;

    @Column(name="")
    private Byte foto;


    protected Usuario (){

    }

    public Usuario (String matricula, String nome, LocalDate dataNascimento, String cpf, String adm, String senha, Byte foto){
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.adm = adm;
        this.senha = senha;
        this.foto = foto;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMatricula() {
        return matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAdm(String adm) {
        this.adm = adm;
    }
    public String getAdm() {
        return adm;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setFoto(Byte foto) {
        this.foto = foto;
    }
    public Byte getFoto() {
        return foto;
    }

}
