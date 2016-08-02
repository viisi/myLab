package br.com.myLab.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import br.com.myLab.entidade.Professor;
import br.com.myLab.entidade.Turma;
import br.com.myLab.seguranca.Authentication;
import br.com.myLab.servico.ProfessorServico;

@Named
@RequestScoped
public class CadastroHorarioView {
	
	@Inject
	private FacesContext facesContext;
	
	private static final Logger log = Logger.getLogger(Authentication.class);
	
	private String diaSemana;
	private String turno;
	private Professor professor;
	private Turma turma;
	 
	List<String> listaDiasSemana = new ArrayList<String>();
	List<String> listaTurnosSemana = new ArrayList<String>();
	
	List<Professor> listaProfessores = new ArrayList<Professor>();
	List<String> nomesProfessores = new ArrayList<String>();
	
	@PostConstruct
	public void init() {

		listaDiasSemana.add("Segunda-feira");
		listaDiasSemana.add("Terça-feira");
		listaDiasSemana.add("Quarta-feira");
		listaDiasSemana.add("Quinta-feira");
		listaDiasSemana.add("Sexta-feira");
	    
		listaTurnosSemana.add("Matutino");
		listaTurnosSemana.add("Vespertino");
		listaTurnosSemana.add("Noturno");
		
		try{
			ProfessorServico servico = new ProfessorServico();
			listaProfessores = servico.buscarProfessores();
			
			for (Professor prof : listaProfessores) {
				nomesProfessores.add(prof.getNome() + " (" + prof.getDisciplina() + ")");
			}
			
		} catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public void cadastrar() throws Exception {

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste!", "");
		facesContext.addMessage(null, msg);
		
	}
	
	
	
	public List<String> getNomesProfessores() {
		return nomesProfessores;
	}

	public void setNomesProfessores(List<String> nomesProfessores) {
		this.nomesProfessores = nomesProfessores;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public List<String> getListaDiasSemana() {
		return listaDiasSemana;
	}

	public void setListaDiasSemana(List<String> listaDiasSemana) {
		this.listaDiasSemana = listaDiasSemana;
	}

	public List<String> getListaTurnosSemana() {
		return listaTurnosSemana;
	}

	public void setListaTurnosSemana(List<String> listaTurnosSemana) {
		this.listaTurnosSemana = listaTurnosSemana;
	}

	public List<Professor> getListaProfessores() {
		return listaProfessores;
	}

	public void setListaProfessores(List<Professor> listaProfessores) {
		this.listaProfessores = listaProfessores;
	}

	public static Logger getLog() {
		return log;
	}
	
}
