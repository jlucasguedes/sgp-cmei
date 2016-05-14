/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.repository;

import br.com.sementesdoamanha.model.Cidade;
import br.com.sementesdoamanha.model.Estado;
import br.com.sementesdoamanha.model.Pais;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author João Lucas
 */
public class Paises implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public List<Pais> todos() {
        return manager.createQuery("select p from Pais p", Pais.class).getResultList();
    }

    public Pais porId(Integer id) {
        return manager.find(Pais.class, id);
    }
}
