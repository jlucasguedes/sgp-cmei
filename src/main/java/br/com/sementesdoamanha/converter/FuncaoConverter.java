/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.converter;

import br.com.sementesdoamanha.model.Funcao;
import br.com.sementesdoamanha.repository.Funcoes;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author João Lucas
 */
@FacesConverter(forClass = Funcao.class)
public class FuncaoConverter implements Converter {

    @Inject
    private Funcoes funcaos;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Funcao retorno = null;

        if (value != null) {
            Integer id = new Integer(value);

            retorno = funcaos.porId(id);

        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Funcao funcao = (Funcao) value;
            return funcao.getId() == null ? null : funcao.getId().toString();
        }

        return "";
    }

}
