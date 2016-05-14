/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.converter;

import br.com.sementesdoamanha.model.OrgaoExpedidor;
import br.com.sementesdoamanha.repository.OrgaosExpedidores;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author João Lucas
 */
@FacesConverter(forClass = OrgaoExpedidor.class)
public class OrgaoExpedidorConverter implements Converter {

    @Inject
    private OrgaosExpedidores orgaosExpedidores;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        OrgaoExpedidor retorno = null;

        if (value != null) {
            Integer id = new Integer(value);

            retorno = orgaosExpedidores.porId(id);

        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            OrgaoExpedidor orgaoExpedidor = (OrgaoExpedidor) value;
            return orgaoExpedidor.getId() == null ? null : orgaoExpedidor.getId().toString();
        }

        return "";
    }

}
