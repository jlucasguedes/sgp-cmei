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
public enum Vinculo {
    EFETIVO("Efetivo"), CONTRATO("Contrato");

    private Vinculo(String descricao) {
        this.descricao = descricao;
    }

    private final String descricao;

    public String getDescricao() {
        return descricao;
    }

}
