/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "servidor")
@SequenceGenerator(name = "servidor_id_seq", sequenceName = "servidor_id_seq", allocationSize = 1)
public class Servidor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private Sexo sexo;
    private EstadoCivil estadoCivil;
    private TipoSanguineo tipoSanguineo;
    private String pisPasep;
    private String certificadoMilitar;
    private String nomeMae;
    private String nomePai;
    private String email;

    //Relacionamentos
    private ContaBancaria contaBancaria;
    private Nacionalidade nacionalidade;
    private Naturalidade naturalidade;
    private RegistroGeral registroGeral;
    private TituloEleitoral tituloEleitoral;
    private Endereco endereco;
    private Admissao admissao;
    private List<Telefone> telefones;
    private List<Dependente> dependentes;
    private List<Lotacao> lotacoes;

    public Servidor() {
        this.nacionalidade = new Nacionalidade();
        this.naturalidade = new Naturalidade();
        this.registroGeral = new RegistroGeral();
        this.tituloEleitoral = new TituloEleitoral();
        this.endereco = new Endereco();
        this.admissao = new Admissao();
        this.contaBancaria = new ContaBancaria();
        this.telefones = new ArrayList<>();
        this.dependentes = new ArrayList<>();
        this.lotacoes = new ArrayList<>();
    }

    @Id
    @GeneratedValue(generator = "servidor_id_seq", strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank
    @Column(name = "nome", length = 150, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @CPF
    @Column(name = "cpf", nullable = false, length = 14)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento", nullable = false)
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_civil")
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_sanguineo")
    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    @NotNull
    @Column(name = "pis_pasep")
    public String getPisPasep() {
        return pisPasep;
    }

    public void setPisPasep(String pisPasep) {
        this.pisPasep = pisPasep;
    }

    @Column(name = "certificado_militar", nullable = true, length = 50)
    public String getCertificadoMilitar() {
        return certificadoMilitar;
    }

    public void setCertificadoMilitar(String certificadoMilitar) {
        this.certificadoMilitar = certificadoMilitar;
    }

    @NotBlank
    @Column(name = "nome_mae", length = 150, nullable = false)
    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    @Column(name = "nome_pai", length = 150, nullable = true)
    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    @Email
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_bancaria_id")
    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    @NotNull
    @OneToOne
    @JoinColumn(name = "nacionalidade_id")
    public Nacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Nacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "naturalidade_id")
    public Naturalidade getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(Naturalidade naturalidade) {
        this.naturalidade = naturalidade;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registro_geral_id")
    public RegistroGeral getRegistroGeral() {
        return registroGeral;
    }

    public void setRegistroGeral(RegistroGeral registroGeral) {
        this.registroGeral = registroGeral;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "titulo_eleitoral_id")
    public TituloEleitoral getTituloEleitoral() {
        return tituloEleitoral;
    }

    public void setTituloEleitoral(TituloEleitoral tituloEleitoral) {
        this.tituloEleitoral = tituloEleitoral;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admissao_id")
    public Admissao getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Admissao admissao) {
        this.admissao = admissao;
    }

    @OneToMany(mappedBy = "servidor", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @OneToMany(mappedBy = "servidor", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    @OneToMany(mappedBy = "servidor", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Lotacao> getLotacoes() {
        return lotacoes;
    }

    public void setLotacoes(List<Lotacao> lotacoes) {
        this.lotacoes = lotacoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Servidor other = (Servidor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
