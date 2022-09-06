package br.edu.infinet.seuhospital.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infinet.seuhospital.model.domain.Cliente;
import br.edu.infinet.seuhospital.model.test.AppImpressao;

@Service
public class ClienteService {

	private static Map<String, Cliente> mapaCliente = new HashMap<String, Cliente>();

	public Cliente validar(String email, String senha) {

		Cliente cliente = mapaCliente.get(email);

		if (cliente != null && senha.equals(cliente.getSenha())) {
			return cliente;
		}

		return null;
	}

	public void incluir(Cliente cliente) {
		mapaCliente.put(cliente.getEmail(), cliente);

		AppImpressao.relatorio("Inclusão do cliente " + cliente.getNome(), cliente);
	}

	public Collection<Cliente> obterLista() {
		return mapaCliente.values();
	}

	public void excluir(String email) {
		mapaCliente.remove(email);
	}

}
