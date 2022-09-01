package br.edu.infinet.seuhospital.model.test;

import br.edu.infinet.seuhospital.interfaces.IPrinter;

public class AppImpressao {
	  	
	public static void relatorio(String mensagem, IPrinter printer) {
		System.out.println(mensagem);
		printer.impressao();
	}
	 
}
