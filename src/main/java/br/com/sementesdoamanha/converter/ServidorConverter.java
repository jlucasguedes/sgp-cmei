/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.converter;

import br.com.sementesdoamanha.model.Estado;
import br.com.sementesdoamanha.model.Servidor;
import br.com.sementesdoamanha.repository.Servidores;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author João Lucas
 */
@FacesConverter(forClass = Servidor.class)
public class ServidorConverter implements Converter {

    @Inject
    private Servidores servidores;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Servidor retorno = null;

        if (value != null) {
            Integer id = new Integer(value);

            retorno = servidores.porId(id);

        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Servidor servidor = (Servidor) value;
            return servidor.getId() == null ? null : servidor.getId().toString();
        }

        return "";
    }

}
