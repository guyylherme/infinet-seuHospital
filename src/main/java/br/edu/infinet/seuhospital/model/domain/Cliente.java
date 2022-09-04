package br.edu.infinet.seuhospital.model.domain;

import br.edu.infinet.seuhospital.interfaces.IPrinter;

public class Cliente implements IPrinter {
	
	private Integer id; 
	private String nome; 
	private String email;
	private String senha; 
	  
	
	public void impressao() {
		System.out.println("#Cliente");
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	 
	 
}
