/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.controller;

import br.com.sementesdoamanha.model.Funcao;
import br.com.sementesdoamanha.model.Lotacao;
import br.com.sementesdoamanha.model.Servidor;
import br.com.sementesdoamanha.repository.Funcoes;
import br.com.sementesdoamanha.repository.Servidores;
import br.com.sementesdoamanha.service.GestaoServidores;
import br.com.sementesdoamanha.util.jsf.FacesUtil;
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
public class LotacaoServidorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Servidores servidores;

    @Inject
    private GestaoServidores gestaoServidores;

    @Inject
    private Funcoes funcoes;

    private Lotacao lotacao;
    private Servidor servidorSelecionado;
    private List<Servidor> servidoresFiltrados;
    private List<Funcao> todasFuncoes;

    public LotacaoServidorBean() {
        limpar();
    }

    private void limpar() {
        this.lotacao = new Lotacao();
        this.servidoresFiltrados = new ArrayList<>();
        this.todasFuncoes = new ArrayList<>();
        this.servidorSelecionado = new Servidor();
    }

    public void inicializar() {
        todasFuncoes = funcoes.todos();
    }

    public void lotar() {

        lotacao.setServidor(servidorSelecionado);
        servidorSelecionado.getLotacoes().add(lotacao);

        gestaoServidores.salvar(servidorSelecionado);

        limpar();

        FacesUtil.addInfoMessage("Servidor lotado com sucesso.");
    }

    public List<Servidor> completarServidor(String nome) {
        System.out.println("Nome: " + nome.toUpperCase());
        return this.servidores.porNome(nome);

    }

    public void carregaServidorSelecionado() {
        servidoresFiltrados.clear();
        servidoresFiltrados.add(servidorSelecionado);
    }

    public List<Servidor> getServidoresFiltrados() {
        return servidoresFiltrados;
    }

    public Lotacao getLotacao() {
        return lotacao;
    }

    public void setLotacao(Lotacao lotacao) {
        this.lotacao = lotacao;
    }

    public Servidor getServidorSelecionado() {
        return servidorSelecionado;
    }

    public void setServidorSelecionado(Servidor servidorSelecionado) {
        this.servidorSelecionado = servidorSelecionado;
    }

    public List<Funcao> getTodasFuncoes() {
        return todasFuncoes;
    }

}
