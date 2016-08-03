package br.com.myLab.view;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean(name = "cadastroHorarioConverterBean") 
@FacesConverter(forClass = CadastroHorarioView.class)
public class CadastroHorarioViewConverter implements Converter {

	 @PersistenceContext(unitName = "puMyLab")
	 private transient EntityManager em;  
	 
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
