package br.com.fiap.tds.checkpoint.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.tds.checkpoint.dao.UsuarioDao;
import br.com.fiap.tds.checkpoint.model.Usuario;

@ManagedBean
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	
	public void save() {
		
		
		new UsuarioDao().save(usuario);		
		
		FacesMessage mensagem = new FacesMessage("Usuário cadastrado com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		
			
	}
	
	public List<Usuario> getUsuarios(){
		return new UsuarioDao().getAll();
		

	}
	
	
	public void deletar() {
		System.out.println("Teste deletando...");
	}
	
	//Gets e Sets

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
}
