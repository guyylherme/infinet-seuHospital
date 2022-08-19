package br.edu.infinet.seuhospital.model.domain;

import br.edu.infinet.seuhospital.interfaces.IPrinter;

public class Endereco implements IPrinter {
	
	private int numero;
	private String rua; 
	private String estado;
	private String pais;
	private String cep;
	
	public void impressao() {
		System.out.println("#Pedido");
		System.out.println(this);
	}
	
	public Endereco(String rua, int numero, String estado, String pais, String cep) { 
		this.rua = rua;
		this.numero = numero;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
	}



	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + ", estado=" + estado + ", pais=" + pais + ", cep=" + cep
				+ "]";
	}
	
	

}
