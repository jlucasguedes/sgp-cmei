/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.converter;

import br.com.sementesdoamanha.model.Nacionalidade;
import br.com.sementesdoamanha.repository.Nacionalidades;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author João Lucas
 */
@FacesConverter(forClass = Nacionalidade.class)
public class NacionalidadeConverter implements Converter {

    @Inject
    private Nacionalidades nacionalidades;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Nacionalidade retorno = null;

        if (value != null) {
            Integer id = new Integer(value);

            retorno = nacionalidades.porId(id);

        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Nacionalidade nacionalidade = (Nacionalidade) value;
            return nacionalidade.getId() == null ? null : nacionalidade.getId().toString();
        }

        return "";
    }

}
