package edu.sistema.sigedef;


import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository 
public class TelefoneRepository {
  
  @PersistenceContext 
  private EntityManager em;

  @Transactional 
  public void salvar(TelefoneSms Telefone) {
    Query query = em.createNativeQuery("INSERT INTO telefone_sms (num_telefone) VALUES ( :num_telefone )");

    query.setParameter("num_telefone", Telefone.getNum_Telefone());

    query.executeUpdate();
  }

  public boolean verificar(TelefoneSms Telefone) {
    Query query = em.createNativeQuery("SELECT EXISTS (SELECT 1 FROM telefone_sms WHERE (num_telefone) = (:telefone_cidadao)) AS existe;");
    
    query.setParameter("telefone_cidadao", Telefone.getNum_Telefone());
    
    if (query.getSingleResult().toString().equals("1")) {
      return true;
    } else {
      return false; 
    }
  }

}
