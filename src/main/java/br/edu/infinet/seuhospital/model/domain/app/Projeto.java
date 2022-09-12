package br.edu.infinet.seuhospital.model.domain.app;

import java.util.List;

import br.edu.infinet.seuhospital.interfaces.IPrinter;

public class Projeto implements IPrinter{

	private String nome;
	private String descricao;
	private List<Classe> classes;
	
	
	
	public List<Classe> getClasses() {
		return classes;
	}
	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	} 
	
	@Override
	public void impressao() {
		System.out.println("- -" + nome + " | " + descricao);
		for(Classe c : classes) {
			c.impressao();
		}
	}
	
}
