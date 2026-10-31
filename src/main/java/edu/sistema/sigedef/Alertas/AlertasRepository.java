package edu.sistema.sigedef.Alertas;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository 
public class AlertasRepository {

    @PersistenceContext
    private EntityManager em;

    // salvando a denuncia
    @Transactional
    public void novoAlerta(Alerta alerta ){
        Query query = em.createNativeQuery("insert into alerta (titulo, mensagem, data_hora, matricula_agente) values (:titulo, :mensagem, :data_hora, :matricula_agente)");
        query.setParameter("titulo", alerta.getTitulo());
        query.setParameter("mensagem", alerta.getMensagem());
        query.setParameter("matricula_agente", alerta.getAgente().getMatricula());
        query.setParameter("data_hora", LocalDateTime.now());
        query.executeUpdate();
    }

    // listando as que já foram salvas
    public List<Alerta> listarAlertas(){
        Query query = em.createNativeQuery("Select * from alerta;", Alerta.class);
        List<Alerta> alertas = query.getResultList();

        return alertas;
    }

    @Transactional
    public void excluirHistorico(){
        Query query = em.createNativeQuery("delete from alerta;");
        query.executeUpdate();
    }

}
