/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.repository;

import br.com.sementesdoamanha.filter.ServidorFilter;
import br.com.sementesdoamanha.model.Servidor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.MatchMode;

/**
 *
 * @author João Lucas
 */
public class Servidores implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Servidor adicionar(Servidor servidor) {
        return manager.merge(servidor);
    }

    public List<Servidor> filtrados(ServidorFilter filtro) {
        //select, from, where, like... --> select(), from(), where()
        //JPQL: from Servidor

        //JPQL: select s from Servidor s where c.nome like = 'João%' and c.cpf = like '046.244.901-77'
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Servidor> criteriaQuery = builder.createQuery(Servidor.class);
        Root<Servidor> s = criteriaQuery.from(Servidor.class);
        criteriaQuery.select(s);

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotBlank(filtro.getCpf())) {
            predicates.add(builder.equal(s.<String>get("cpf"), filtro.getCpf()));
        }
        if (StringUtils.isNotBlank(filtro.getNome())) {
            predicates.add(builder.like(builder.upper(s.<String>get("nome")), filtro.getNome().toUpperCase() + "%"));

        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Servidor> query = manager.createQuery(criteriaQuery);
        return query.getResultList();

    }

    public List<Servidor> porNome(String nome) {
        System.out.println("" + nome.toUpperCase());
        return manager.createQuery("select s from Servidor s where upper(s.nome) like :nome", Servidor.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();

    }

    public Servidor porId(Integer id) {
        return manager.find(Servidor.class, id);
    }

}
