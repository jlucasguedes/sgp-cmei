/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.controller;

import br.com.sementesdoamanha.filter.ServidorFilter;
import br.com.sementesdoamanha.model.Servidor;
import br.com.sementesdoamanha.repository.Servidores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Lucas
 */
@Named
@ViewScoped
public class PesquisaServidorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Servidores servidores;

    private ServidorFilter filtro;

    private List<Servidor> servidoresFiltrados;
    private Servidor servidorSelecionado;

    public PesquisaServidorBean() {
        filtro = new ServidorFilter();
        servidoresFiltrados = new ArrayList<>();
        servidorSelecionado = new Servidor();
    }

    public void pesquisar() {
        servidoresFiltrados = servidores.filtrados(filtro);
        System.out.println("Nome: " + filtro.getNome());

        for (Servidor servidoresFiltrado : servidoresFiltrados) {
            System.out.println("Nome: " + servidoresFiltrado.getNome());
        }
    }

    public List<Servidor> getServidoresFiltrados() {
        return servidoresFiltrados;
    }

    public ServidorFilter getFiltro() {
        return filtro;
    }

    public void setFiltro(ServidorFilter filtro) {
        this.filtro = filtro;
    }

    public Servidor getServidorSelecionado() {
        return servidorSelecionado;
    }

    public void setServidorSelecionado(Servidor servidorSelecionado) {
        this.servidorSelecionado = servidorSelecionado;
    }

}
