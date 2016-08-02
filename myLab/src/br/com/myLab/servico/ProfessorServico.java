package br.com.myLab.servico;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.com.myLab.entidade.Professor;

@Named
@RequestScoped
public class ProfessorServico extends Servico {

	private EntityManager em = getEm();
	
	public List<Professor> buscarProfessores() throws Exception {
		
		List<Professor> lista = null;
		
		try {
			lista = (List<Professor>) em.createNativeQuery("select * from professor", Professor.class).getResultList();
		} catch (NoResultException nre) {
			
		}
		
		return lista;
	}
	
	public EntityManager getEm(){
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("puMyLab");
		return fabrica.createEntityManager();
	}

}
