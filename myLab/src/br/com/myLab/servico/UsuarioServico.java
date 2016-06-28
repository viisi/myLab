package br.com.myLab.servico;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.myLab.entidade.Usuario;

@Named
@RequestScoped
public class UsuarioServico extends Servico {
	
	@Inject
	private EntityManager em;
	
	public Usuario login(String login, String senha) throws Exception {
		Usuario usu = null;
		
		try {
			
			usu	 = (Usuario) em.createNativeQuery("select * from usuario where login = :login and senha = :senha", Usuario.class)
				.setParameter("login", login)
				.setParameter("senha", senha).getSingleResult();	
			
		} catch (NoResultException nre) {
			
		}
		
		return usu;
	}
}
