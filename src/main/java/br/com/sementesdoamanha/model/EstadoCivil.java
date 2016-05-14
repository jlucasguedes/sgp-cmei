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
public enum EstadoCivil {
    SOLTEIRO("Solteiro"), CASADO("Casado"), DIVORCIADO("Divorciado"), VIUVO("Viúvo");

    private EstadoCivil(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
