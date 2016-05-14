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
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "registro_geral")
@SequenceGenerator(name = "rg_id_seq", sequenceName = "rg_id_seq", allocationSize = 1)
public class RegistroGeral implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String numero;
    private OrgaoExpedidor orgaoExpedidor;
    private Date dataExpedicao;
    private Estado estadoExpedicao;

    @Id
    @GeneratedValue(generator = "rg_id_seq", strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank
    @Column(name = "numero", length = 50, nullable = false)
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "orgao_expedior_id")
    public OrgaoExpedidor getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(OrgaoExpedidor orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_expedicao")
    public Date getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(Date dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "estado_id")
    public Estado getEstadoExpedicao() {
        return estadoExpedicao;
    }

    public void setEstadoExpedicao(Estado estadoExpedicao) {
        this.estadoExpedicao = estadoExpedicao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final RegistroGeral other = (RegistroGeral) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
