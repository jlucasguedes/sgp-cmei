/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.repository;

import br.com.sementesdoamanha.model.Cargo;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author João Lucas
 */
public class Cargos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public List<Cargo> todos() {
        return manager.createQuery("select c from Cargo c", Cargo.class)
                .getResultList();
    }

    public Cargo porId(Integer id) {
        return manager.find(Cargo.class, id);
    }
}
