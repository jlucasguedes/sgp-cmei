/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "pais")
@SequenceGenerator(name = "pais_id_seq", sequenceName = "pais_id_seq", allocationSize = 1)
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String siglaDois;
    private String siglaTres;
    private String codigoIso;

    @Id
    @GeneratedValue(generator = "pais_id_seq", strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "sigla_dois")
    public String getSiglaDois() {
        return siglaDois;
    }

    public void setSiglaDois(String siglaDois) {
        this.siglaDois = siglaDois;
    }

    @Column(name = "sigla_tres")
    public String getSiglaTres() {
        return siglaTres;
    }

    public void setSiglaTres(String siglaTres) {
        this.siglaTres = siglaTres;
    }

    @Column(name = "codigo_iso")
    public String getCodigoIso() {
        return codigoIso;
    }

    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Pais other = (Pais) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
