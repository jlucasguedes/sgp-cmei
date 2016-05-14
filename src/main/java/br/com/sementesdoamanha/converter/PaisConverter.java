/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.converter;

import br.com.sementesdoamanha.model.Pais;
import br.com.sementesdoamanha.repository.Paises;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author João Lucas
 */
@FacesConverter(forClass = Pais.class)
public class PaisConverter implements Converter {

    @Inject
    private Paises paises;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Pais retorno = null;

        if (value != null) {
            Integer id = new Integer(value);

            retorno = paises.porId(id);

        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Pais pais = (Pais) value;
            return pais.getId() == null ? null : pais.getId().toString();
        }

        return "";
    }

}
