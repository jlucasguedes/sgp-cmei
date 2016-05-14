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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "lotacao")
@SequenceGenerator(name = "lotacao_id_seq", sequenceName = "lotacao_id_seq", allocationSize = 1)
public class Lotacao implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Servidor servidor;
    private Funcao funcao;
    private Date dataLotacao;
    private String cargaHoraria;
    private boolean desvioFuncao = false;

    @Id
    @GeneratedValue(generator = "lotacao_id_seq", strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "servidor_id")
    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    @ManyToOne
    @JoinColumn(name = "funcao_id")
    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "data_lotacao")
    public Date getDataLotacao() {
        return dataLotacao;
    }

    public void setDataLotacao(Date dataLotacao) {
        this.dataLotacao = dataLotacao;
    }

    @Column(name = "carga_horaria")
    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Column(name = "desvio_funcao")
    public boolean isDesvioFuncao() {
        return desvioFuncao;
    }

    public void setDesvioFuncao(boolean desvioFuncao) {
        this.desvioFuncao = desvioFuncao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Lotacao other = (Lotacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
