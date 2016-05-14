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
public enum TipoSanguineo {
    Op("O+", "O Positivo"),
    On("O-", "O Negativo"),
    Ap("A+", "A Positivo"),
    An("A-", "A Negativo"),
    Bp("B+", "B Positivo"),
    Bn("B-", "B Negativo"),
    ABp("AB+", "AB Positivo"),
    ABn("AB-", "AB Negativo");

    private TipoSanguineo(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    private String sigla;
    private String descricao;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
