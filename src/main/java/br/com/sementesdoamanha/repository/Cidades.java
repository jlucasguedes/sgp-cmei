/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.repository;

import br.com.sementesdoamanha.model.Cidade;
import br.com.sementesdoamanha.model.Estado;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author João Lucas
 */
public class Cidades implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public List<Cidade> porEstado(Estado estado) {
        return manager.createQuery("select c from Cidade c where c.estado = :estado", Cidade.class)
                .setParameter("estado", estado)
                .getResultList();
    }

    public Cidade porId(Integer id) {
        return manager.find(Cidade.class, id);
    }
}
