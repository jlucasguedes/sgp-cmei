/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.controller;

import br.com.sementesdoamanha.model.Servidor;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Lucas
 */
@Named
@ViewScoped
public class FichaServidorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Servidor servidor;

    public FichaServidorBean() {
        servidor = new Servidor();
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

}
