/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sementesdoamanha.converter;

import br.com.sementesdoamanha.model.Cargo;
import br.com.sementesdoamanha.model.Cidade;
import br.com.sementesdoamanha.repository.Cargos;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author João Lucas
 */
@FacesConverter(forClass = Cargo.class)
public class CargoConverter implements Converter {

    @Inject
    private Cargos cargos;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cargo retorno = null;

        if (value != null) {
            Integer id = new Integer(value);

            retorno = cargos.porId(id);

        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Cargo cargo = (Cargo) value;
            return cargo.getId() == null ? null : cargo.getId().toString();
        }

        return "";
    }

}
