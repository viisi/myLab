package br.com.myLab.servico;

import java.io.Serializable;

public class Servico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void getLogger() {
		
	}
	
	/*
	void getNamedObject() {
		BeanManager bm = CDI.current().getBeanManager();
		Bean<CrudService> bean = (Bean<CrudService>) bm.getBeans(CrudService.class).iterator().next();
		CreationalContext<CrudService> ctx = bm.createCreationalContext(bean);
		CrudService crudService = (CrudService) bm.getReference(bean, CrudService.class, ctx);
	}
	*/
}
