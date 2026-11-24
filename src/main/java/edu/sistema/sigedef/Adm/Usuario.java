package edu.sistema.sigedef.Adm;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// O SpringSecurity exige que a classe de usuario seja implementada da UserDetails
// Consequentemente haverá métodos obrigatórios
@Entity
@Table(name="usuario")
public class Usuario implements  UserDetails {

    @Id 
    private String matricula;

    @Column(name = "nome")
    private  String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(unique = true, name = "cpf")
    private String cpf;

    @Column(name = "adm")
    private  boolean adm;

    @Column(name = "senha")
    private String senha;


    protected Usuario (){

    }

    public Usuario (String matricula, String nome, LocalDate dataNascimento, String cpf, boolean adm, String senha){
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.adm = adm;
        this.senha = senha;
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

    public void setAdm(boolean adm) {
        this.adm = adm;
    }
    public boolean getAdm() {
        return adm;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    // MÉTODOS DA IMPLEMENTAÇÃO

    @Override 
    public Collection< ? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }
    
    @Override
    public String getUsername() {
        return matricula;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override 
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override 
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override 
    public boolean isEnabled() {
        return true;
    }


}
