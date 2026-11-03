package edu.sistema.sigedef.PrevisaoDoTempo;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import edu.sistema.sigedef.Adm.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository 
public class CidadeRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void attCidade(int cidade){
        Query query = em.createNativeQuery("UPDATE configuracao_previsao SET codigo_cidade = :cidade WHERE id = 1;");
        query.setParameter("cidade", cidade);
        
        query.executeUpdate();
    }

    public int buscarCidade(){
        Query query = em.createNativeQuery("Select codigo_cidade from configuracao_previsao where id = 1;");
        int codigoCidade = (int) query.getSingleResult();
        return codigoCidade;
    }

}
