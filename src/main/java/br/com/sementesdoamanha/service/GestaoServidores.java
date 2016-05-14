/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.service;

import br.com.sementesdoamanha.model.Servidor;
import br.com.sementesdoamanha.model.Situacao;
import br.com.sementesdoamanha.repository.Servidores;
import br.com.sementesdoamanha.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author João Lucas
 */
public class GestaoServidores implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Servidores servidores;

    @Transactional
    public Servidor salvar(Servidor servidor) {
        if (servidor.getId() == null) {
            servidor.getAdmissao().setSituacao(Situacao.ATIVO);
        }

        return servidores.adicionar(servidor);
    }
}
