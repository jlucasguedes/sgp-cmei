/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.repository;

import br.com.sementesdoamanha.model.OrgaoExpedidor;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author João Lucas
 */
public class OrgaosExpedidores implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public List<OrgaoExpedidor> todos() {
        return manager.createQuery("select oe from OrgaoExpedidor oe", OrgaoExpedidor.class).getResultList();
    }

    public OrgaoExpedidor porId(Integer id) {
        return manager.find(OrgaoExpedidor.class, id);
    }
}
