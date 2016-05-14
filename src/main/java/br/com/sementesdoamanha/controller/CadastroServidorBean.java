/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.controller;

import br.com.sementesdoamanha.model.Cargo;
import br.com.sementesdoamanha.model.Cidade;
import br.com.sementesdoamanha.model.Dependente;
import br.com.sementesdoamanha.model.Estado;
import br.com.sementesdoamanha.model.EstadoCivil;
import br.com.sementesdoamanha.model.Nacionalidade;
import br.com.sementesdoamanha.model.OrgaoExpedidor;
import br.com.sementesdoamanha.model.Pais;
import br.com.sementesdoamanha.model.Servidor;
import br.com.sementesdoamanha.model.Sexo;
import br.com.sementesdoamanha.model.Telefone;
import br.com.sementesdoamanha.model.TipoSanguineo;
import br.com.sementesdoamanha.model.TipoTelefone;
import br.com.sementesdoamanha.model.Vinculo;
import br.com.sementesdoamanha.repository.Cargos;
import br.com.sementesdoamanha.repository.Cidades;
import br.com.sementesdoamanha.repository.Estados;
import br.com.sementesdoamanha.repository.Nacionalidades;
import br.com.sementesdoamanha.repository.OrgaosExpedidores;
import br.com.sementesdoamanha.repository.Paises;
import br.com.sementesdoamanha.service.GestaoServidores;
import br.com.sementesdoamanha.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import javax.faces.render.RendererWrapper;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import org.primefaces.component.selectonebutton.SelectOneButton;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.wizard.Wizard;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Lucas
 */
@Named
@ViewScoped
public class CadastroServidorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private GestaoServidores gestaoServidores;

    @Inject
    private Nacionalidades nacionalidades;

    @Inject
    private Estados estados;

    @Inject
    private Cidades cidades;

    @Inject
    private Paises paises;

    @Inject
    private OrgaosExpedidores orgaosExpedidores;

    @Inject
    private Cargos cargos;

    private List<Nacionalidade> todasNacionalidade;
    private List<Estado> todosEstados;
    private List<Cidade> cidadesNaturalidade;
    private List<Cidade> cidadesEndereco;
    private List<Pais> todosPaises;
    private List<OrgaoExpedidor> todosOrgaosExpedidores;
    private List<Cargo> todosCargos;

    private Servidor servidor;
    private Estado estadoNaturalidade;
    private Estado estadoEndereco;
    private Telefone telefone;
    private Dependente dependente;
    private Telefone telefoneSelecionado;

    private SelectOneMenu selectPais;
    private SelectOneMenu selectUfNascimento;
    private SelectOneMenu selectCidadeNascimento;

    public CadastroServidorBean() {
        limparTela();
    }

    public void verificaNacionalidade() {

        if (this.servidor.getNacionalidade().getId() != null && this.servidor.getNacionalidade().getId() == 1) {

            selectPais.setValue(paises.porId(31));
            selectPais.setDisabled(true);
            
            selectUfNascimento.setValue(null);
            selectUfNascimento.setDisabled(false);
            
            selectCidadeNascimento.setValue(null);
            selectCidadeNascimento.setDisabled(false);
        } else {
            selectPais.setValue(null);
            selectPais.setDisabled(false);
            
            selectUfNascimento.setValue(null);
            selectUfNascimento.setDisabled(true);
            
            selectCidadeNascimento.setValue(null);
            selectCidadeNascimento.setDisabled(true);
        }
    }

    private void limparTela() {
        this.servidor = new Servidor();
        this.todasNacionalidade = new ArrayList<>();
        this.todosEstados = new ArrayList<>();
        this.todosPaises = new ArrayList<>();
        this.cidadesNaturalidade = new ArrayList<>();
        this.cidadesEndereco = new ArrayList<>();
        this.todosOrgaosExpedidores = new ArrayList<>();
        this.todosCargos = new ArrayList<>();
        this.telefone = new Telefone();
        this.dependente = new Dependente();
        this.telefoneSelecionado = new Telefone();
        this.selectPais = new SelectOneMenu();
        this.selectUfNascimento = new SelectOneMenu();
        this.selectCidadeNascimento = new SelectOneMenu();
    }

    public void inicializar() {
        if (FacesUtil.isNotPostback()) {
            todasNacionalidade = nacionalidades.todas();
            todosEstados = estados.todos();
            todosPaises = paises.todos();
            todosOrgaosExpedidores = orgaosExpedidores.todos();
            todosCargos = cargos.todos();
            selectPais = new SelectOneMenu();
            selectUfNascimento = new SelectOneMenu();
            selectCidadeNascimento = new SelectOneMenu();

            if (estadoNaturalidade != null) {
                carregarCidadesNarutalidade();
            }

            if (estadoEndereco != null) {
                carregarCidadesEndereco();
            }
        }
    }

    public void carregarCidadesNarutalidade() {
        cidadesNaturalidade = cidades.porEstado(estadoNaturalidade);
    }

    public void carregarCidadesEndereco() {
        cidadesEndereco = cidades.porEstado(estadoEndereco);
    }

    public void novoTelefone() {
        this.telefone = new Telefone();
    }

    public void adicionarTelefone() {
        servidor.getTelefones().add(telefone);
        telefone.setServidor(servidor);
    }

    public void novoDependente() {
        this.dependente = new Dependente();
    }

    public void adicionarDependente() {
        servidor.getDependentes().add(dependente);
        dependente.setServidor(servidor);
    }

    public void salvar() {

        gestaoServidores.salvar(servidor);

        servidor = new Servidor();
        FacesUtil.addInfoMessage("Servidor cadastrado com sucesso!");
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    @NotNull
    public Estado getEstadoNaturalidade() {
        return estadoNaturalidade;
    }

    public void setEstadoNaturalidade(Estado estadoNaturalidade) {
        this.estadoNaturalidade = estadoNaturalidade;
    }

    public Estado getEstadoEndereco() {
        return estadoEndereco;
    }

    public void setEstadoEndereco(Estado estadoEndereco) {
        this.estadoEndereco = estadoEndereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public List<Nacionalidade> getTodasNacionalidade() {
        return todasNacionalidade;
    }

    public List<Estado> getTodosEstados() {
        return todosEstados;
    }

    public List<Cidade> getCidadesNaturalidade() {
        return cidadesNaturalidade;
    }

    public List<Cidade> getCidadesEndereco() {
        return cidadesEndereco;
    }

    public List<Pais> getTodosPaises() {
        return todosPaises;
    }

    public List<OrgaoExpedidor> getTodosOrgaosExpedidores() {
        return todosOrgaosExpedidores;
    }

    public List<Cargo> getTodosCargos() {
        return todosCargos;
    }

    public Sexo[] getSexos() {
        return Sexo.values();
    }

    public EstadoCivil[] getEstadosCivis() {
        return EstadoCivil.values();
    }

    public TipoSanguineo[] getTiposSanguineo() {
        return TipoSanguineo.values();
    }

    public TipoTelefone[] getTiposTelefone() {
        return TipoTelefone.values();
    }

    public Vinculo[] getVinculos() {
        return Vinculo.values();
    }

    public Telefone getTelefoneSelecionado() {
        return telefoneSelecionado;
    }

    public void setTelefoneSelecionado(Telefone telefoneSelecionado) {
        this.telefoneSelecionado = telefoneSelecionado;
    }

    public SelectOneMenu getSelectPais() {
        return selectPais;
    }

    public void setSelectPais(SelectOneMenu selectPais) {
        this.selectPais = selectPais;
    }

    public SelectOneMenu getSelectUfNascimento() {
        return selectUfNascimento;
    }

    public void setSelectUfNascimento(SelectOneMenu selectUfNascimento) {
        this.selectUfNascimento = selectUfNascimento;
    }

    public SelectOneMenu getSelectCidadeNascimento() {
        return selectCidadeNascimento;
    }

    public void setSelectCidadeNascimento(SelectOneMenu selectCidadeNascimento) {
        this.selectCidadeNascimento = selectCidadeNascimento;
    }

}
