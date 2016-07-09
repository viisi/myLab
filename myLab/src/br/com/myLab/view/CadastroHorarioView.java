package br.com.myLab.view;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import br.com.myLab.seguranca.Authentication;

@Named
@RequestScoped
public class CadastroHorarioView {
	
	@Inject
	private FacesContext facesContext;
	
	private static final Logger log = Logger.getLogger(Authentication.class);
	
	private String campo1;

	
	public void cadastrar() throws Exception {

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste!", "");
		
		facesContext.addMessage(null, msg);
		
		System.out.println(campo1);
		
	}

	public String getCampo1() {
		return campo1;
	}

	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}
}
