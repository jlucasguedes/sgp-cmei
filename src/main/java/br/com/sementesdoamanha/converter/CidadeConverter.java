/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.converter;

import br.com.sementesdoamanha.model.Cidade;
import br.com.sementesdoamanha.model.Estado;
import br.com.sementesdoamanha.repository.Cidades;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author João Lucas
 */
@FacesConverter(forClass = Cidade.class)
public class CidadeConverter implements Converter {

    @Inject
    private Cidades cidades;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cidade retorno = null;

        if (value != null) {
            Integer id = new Integer(value);

            retorno = cidades.porId(id);

        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Cidade cidade = (Cidade) value;
            return cidade.getId() == null ? null : cidade.getId().toString();
        }

        return "";
    }

}
