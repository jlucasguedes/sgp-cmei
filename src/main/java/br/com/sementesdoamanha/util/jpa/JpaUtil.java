/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.util.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author João Lucas
 */
public class JpaUtil {

    public static EntityManager createEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sgpPu");
        EntityManager manager = factory.createEntityManager();

        return manager;
    }
}
