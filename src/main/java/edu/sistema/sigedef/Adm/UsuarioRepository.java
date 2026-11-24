package edu.sistema.sigedef.Adm;



import java.util.Optional;


import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository 
public class UsuarioRepository {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public void novoUsuario(Usuario usuario){
        Query query = em.createNativeQuery("insert into alerta (nome, data_nascimento, CPF, adm, senha) values (:nome, :data_nascimento, :cpf, :adm, :senha)");
        query.setParameter("nome", usuario.getNome());
        query.setParameter("data_nascimento", usuario.getDataNascimento());
        query.setParameter("matricula_agente", usuario.getCpf());
        query.setParameter("adm", usuario.getAdm());
        query.setParameter("senha", usuario.getSenha());

        query.executeUpdate();
    }

    public Usuario buscarUm(String matricula){
        Usuario usuario = new Usuario();
        Query query = em.createNativeQuery("Select * from usuario where matricula = :matricula", Usuario.class);
        query.setParameter("matricula", matricula);
        usuario = (Usuario) query.getSingleResult();
        return usuario;
    }

    // O MÉTODO ABAIXO FAZ O MESMO QUE O MÉTODO ACIMA, PORÉM RETORNA UMA LISTA DE USUÁRIOS COM APENAS UM USUÁRIO OU RETORNA UMA LISTA VAZIA

    public Optional<Usuario> buscarListaUm(String matricula){
        Query query = em.createNativeQuery("Select * from usuario where matricula = :matricula", Usuario.class);
        query.setParameter("matricula", matricula);
        
        try {
            Usuario usuario = (Usuario) query.getSingleResult();
            return Optional.of(usuario);    
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
