package edu.sistema.sigedef.denuncias;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository 
public class DenunciaRepository {
    @PersistenceContext
    private EntityManager em;

    // Salvando a denuncia
    @Transactional 
    public void novaDenuncia(Denuncia denuncia){
        Query query = em.createNativeQuery("insert into denuncias (protocolo, bairro, cidade, cep, endereco, ponto_referencia, tipo_ocorrencia,descricao_denuncia, anonimo, nome, telefone, data_hora, situacao, nivel_risco, agente_matricula) values (:protocolo, :bairro, :cidade, :cep,:endereco ,:ponto_referencia, :tipo_ocorrencia, :descricao_denuncia, :anonimo, :nome, :telefone, :data_hora, :situacao, :nivel_risco, :agente_matricula)");

        query.setParameter("protocolo", denuncia.getProtocolo());
        query.setParameter("bairro", denuncia.getBairro());
        query.setParameter("cidade", denuncia.getCidade());
        query.setParameter("cep", denuncia.getCep());
        query.setParameter("ponto_referencia", denuncia.getPonto_referencia());
        query.setParameter("tipo_ocorrencia", denuncia.getTipo_ocorrencia());
        query.setParameter("descricao_denuncia", denuncia.getDescricao_denuncia());
        query.setParameter("anonimo", denuncia.getAnonimo());
        query.setParameter("nome", denuncia.getNome());
        query.setParameter("telefone", denuncia.getTelefone());
        query.setParameter("data_hora", denuncia.getData_hora());
        query.setParameter("situacao", denuncia.getSituacao());
        query.setParameter("nivel_risco", denuncia.getNivel_risco());
        query.setParameter("endereco", denuncia.getEndereco());
        query.setParameter("agente_matricula", null);
        query.executeUpdate();
    }

    // listando
    public List<Denuncia> listarDenuncias(){
        Query query = em.createNativeQuery("select * from denuncias", Denuncia.class);
        List<Denuncia> denuncias = query.getResultList();

        return denuncias;
    }

    // deletando
    @Transactional 
    public void deletarDenuncia(int protocolo){
        Query query = em.createNativeQuery("delete from denuncias where protocolo = :protocolo");

        query.setParameter("protocolo", protocolo);
        query.executeUpdate();

    }

    // aletrando situação
    @Transactional 
    public void alterarSituacao(String situacao, String protocolo){
        Query query = em.createNativeQuery("update denuncias set situacao = :situacao where protocolo = :protocolo");

        query.setParameter("situacao", situacao);
        query.setParameter("protocolo", protocolo);
        query.executeUpdate();
    }

    public int countAnalise(){
        
        Query query = em.createNativeQuery("select count(*) from denuncias where situacao = 'Em Ánalise'", int.class);
        int resultado = (int) query.getSingleResult();

        return resultado;
    }

    public int countAndamento(){
        
        Query query = em.createNativeQuery("select count(*) from denuncias where situacao = 'Em Andamento'", int.class);
        int resultado = (int) query.getSingleResult();

        return resultado;
    }

    public int Count(){
        
        Query query = em.createNativeQuery("select count(*) from denuncias", int.class);
        int resultado = (int) query.getSingleResult();

        return resultado;
    }

    public int countResolvidas(){
        
        Query query = em.createNativeQuery("select count(*) from denuncias where situacao = 'Resolvida'", int.class);
        int resultado = (int) query.getSingleResult();

        return resultado;
    }

    public Denuncia buscarUma(int id){
        Query query = em.createNativeQuery("select * from denuncias where id = :id", Denuncia.class);
        query.setParameter("id", id);
        Denuncia denuncia = (Denuncia) query.getSingleResult();

        return denuncia;
    }


    @Transactional
    public void editandoDenuncia(int id, String nivel_risco, String situacao){
        Query query = em.createNativeQuery("update denuncias set nivel_risco = :nivel_risco, situacao = :situacao where id = :id");
        query.setParameter("id", id);
        query.setParameter("nivel_risco", nivel_risco);
        query.setParameter("situacao", situacao);
        query.executeUpdate();
    }

}
