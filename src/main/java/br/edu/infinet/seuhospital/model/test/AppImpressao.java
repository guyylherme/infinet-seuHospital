package br.edu.infinet.seuhospital.model.test;

import br.edu.infinet.seuhospital.model.domain.Especialidade;

public class AppImpressao {
	  	
	public static void relatorio(String mensagem, Especialidade especialidade) {
		System.out.println(mensagem);
		especialidade.impressao();
	}

}
