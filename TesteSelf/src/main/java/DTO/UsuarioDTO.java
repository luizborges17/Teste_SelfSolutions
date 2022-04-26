package DTO;

public class UsuarioDTO {
	
	String nomeUsuario;
	String nomeTarefas;
	String status;


	public UsuarioDTO(String nomeUsuario, String nomeTarefas, String status) {
		this.nomeUsuario = nomeUsuario;
		this.nomeTarefas = nomeTarefas;
		this.status = "Cadastrado";
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getNomeTarefas() {
		return nomeTarefas;
	}
	public void setNomeTarefas(String nomeTarefas) {
		this.nomeTarefas = nomeTarefas;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = "Cadastrado";
	}
}
