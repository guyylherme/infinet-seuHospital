package br.edu.infinet.model.test;

import br.edu.infinet.model.domain.Especialidade;

public class SeuHospital {
	 
	public String mensagem;
	
	public SeuHospital(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public void relatorio(Especialidade especialidade) {
		System.out.println(mensagem);
		especialidade.impressao();
	}

}
