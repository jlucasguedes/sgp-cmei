/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "naturalidade")
@SequenceGenerator(name = "naturalidade_id_seq", sequenceName = "naturalidade_id_seq", allocationSize = 1)
public class Naturalidade implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Cidade cidade;
    private Pais pais;

    public Naturalidade() {
        this.cidade = new Cidade();
        this.pais = new Pais();
    }

    @Id
    @GeneratedValue(generator = "naturalidade_id_seq", strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pais_id")
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Naturalidade other = (Naturalidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
