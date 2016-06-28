package br.com.myLab.seguranca;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.picketlink.annotations.PicketLink;
import org.picketlink.authentication.BaseAuthenticator;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.idm.model.basic.User;

import br.com.myLab.entidade.Usuario;
import br.com.myLab.servico.UsuarioServico;

@PicketLink
public class Authentication extends BaseAuthenticator {

	@Inject 
    private DefaultLoginCredentials credentials;
	
	@Inject 
    private UsuarioServico usuarioServico;
	
	@Inject
	private FacesContext facesContext;
	
	@Override
	public void authenticate() {
		
		try {
			Usuario usu = usuarioServico.login(credentials.getUserId(), credentials.getPassword());
			if(usu != null) {
				setStatus(AuthenticationStatus.SUCCESS);
				setAccount(new User(usu.getLogin()));
			} else {
				setStatus(AuthenticationStatus.FAILURE);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário e/ou senha invalidos!", "");
				facesContext.addMessage(null, msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}