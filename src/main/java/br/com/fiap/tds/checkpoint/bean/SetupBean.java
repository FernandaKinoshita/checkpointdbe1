package br.com.fiap.tds.checkpoint.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.tds.checkpoint.dao.SetupDao;
import br.com.fiap.tds.checkpoint.model.Setup;

@ManagedBean
public class SetupBean {
	
	private Setup setup = new Setup();
	
	public void save() {
		
		
		new SetupDao().save(setup);		
		
		FacesMessage mensagem = new FacesMessage("Setup cadastrado!" + setup);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		
			
	}
	
	public List<Setup> getSetups(){
		return new SetupDao().getAll();
		

	}
	
	
	public void deletar() {
		System.out.println("Teste deletando...");
	}
	
	//Gets e Sets

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}

	
	
}
