/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "admissao")
@SequenceGenerator(name = "admissao_id_seq", sequenceName = "admissao_id_seq", allocationSize = 1)
public class Admissao implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String matricula;
    private Vinculo vinculo;
    private Date dataAdmissao;
    private Cargo cargo;
    private Situacao situacao;

    @Id
    @GeneratedValue(generator = "admissao_id_seq", strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "matricula", length = 50, nullable = true)
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    public Vinculo getVinculo() {
        return vinculo;
    }

    public void setVinculo(Vinculo vinculo) {
        this.vinculo = vinculo;
    }

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_admissao")
    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cargo_id")
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Admissao other = (Admissao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
