/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.model;

/**
 *
 * @author Lucas
 */
public enum Situacao {
    ATIVO("Ativo"), DESATIVADO("Desativado"), REMOVIDO("Removido");

    private Situacao(String descricao) {
        this.descricao = descricao;
    }

    private final String descricao;

    public String getDescricao() {
        return descricao;
    }

}
