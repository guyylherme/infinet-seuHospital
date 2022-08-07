package br.edu.infinet.model.domain;

public class Endereco {
	
	public String rua;
	public int numero;
	public String estado;
	public String pais;
	public String cep;
	
	
	
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
