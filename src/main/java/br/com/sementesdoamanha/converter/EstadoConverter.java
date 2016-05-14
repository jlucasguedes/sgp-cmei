/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.converter;

import br.com.sementesdoamanha.model.Estado;
import br.com.sementesdoamanha.repository.Estados;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author João Lucas
 */
@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter {

    @Inject
    private Estados estados;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Estado retorno = null;

        if (value != null) {
            Integer id = new Integer(value);

            retorno = estados.porId(id);

        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Estado estado = (Estado) value;
            return estado.getId() == null ? null : estado.getId().toString();
        }

        return "";
    }

}
