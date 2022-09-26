package br.edu.infinet.seuhospital.model.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infinet.seuhospital.model.domain.ClinicoGeral;
import br.edu.infinet.seuhospital.model.domain.Dentista;
import br.edu.infinet.seuhospital.model.domain.Endereco;
import br.edu.infinet.seuhospital.model.domain.Especialidade;
import br.edu.infinet.seuhospital.model.domain.Hospital;
import br.edu.infinet.seuhospital.model.domain.Pediatria;
import br.edu.infinet.seuhospital.model.domain.Usuario;
import br.edu.infinet.seuhospital.model.exceptions.PeriodoInvalidoException;
import br.edu.infinet.seuhospital.model.exceptions.ValorHoraZeradoException;
import br.edu.infinet.seuhospital.model.service.EnderecoService;
import br.edu.infinet.seuhospital.model.service.EspecialidadeService;
import br.edu.infinet.seuhospital.model.service.HospitalService;
import br.edu.infinet.seuhospital.model.service.UsuarioService;

@Order(3)
@Component
public class HospitalTeste implements ApplicationRunner {

	@Autowired
	HospitalService hospitalService;
	
	@Autowired
	EspecialidadeService especialidadeService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	EnderecoService enderecoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println();
		System.out.println("#HospitalTeste");
 
		
		Usuario usuario = usuarioService.findById(1).get();
		Endereco endereco = enderecoService.findById(1).get();
		
		String dir = "C:\\Users\\Guylherme\\OneDrive\\Documentos\\Projetos\\Tecnologia Java - Infinet\\seuhospital\\seuhospital\\src\\main\\db_text\\";
		String arq = "especialidades.txt";

		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				Set<Especialidade> especialidades = new HashSet<Especialidade>(); 

				String linha = leitura.readLine();
				while (linha != null) {

					String[] campos = linha.split(";"); 	

					switch (campos[0].toUpperCase()) {	 
					
					case "H":
						try { 
							Hospital hospital = new Hospital(campos[1], campos[2], campos[3], endereco, especialidades, usuario);							
							hospitalService.incluir(hospital);

						} catch (Exception e) {
							System.out.println("[ ERROR - HOSPITAL TESTE ] " + e.getMessage());
						}
						break;
						
					case "D":
						try { 
							Dentista dentista = new Dentista();
							dentista.setCodigo(campos[1]);
							dentista.setNome(campos[2]);
							dentista.setStatus(Boolean.valueOf(campos[3]));

							dentista.setAtendeCrianca(Boolean.valueOf(campos[4]));
							dentista.setCirurgia(Boolean.valueOf(campos[5]));
							dentista.setTurno(campos[7]);

							dentista.setValorHora(Float.valueOf(campos[6]));
							dentista.calcularValorHora();  
							
							dentista.setUsuario(usuario);

							especialidades.add(dentista);
							especialidadeService.incluir(dentista);
							
						} catch (ValorHoraZeradoException e) {
							System.out.println("[ ERROR - DENTISTA ] " + e.getMessage());
						}						
						
						break;

					case "C":
						try {  
							ClinicoGeral clinico = new ClinicoGeral();
							clinico.setCodigo(campos[1]);
							clinico.setNome(campos[2]);
							clinico.setStatus(Boolean.valueOf(campos[3]));
							
							clinico.setDescricao(campos[4]);
							clinico.setDiarista(Boolean.valueOf(campos[5]));						
							clinico.setTurno(campos[7]);  
							
							clinico.setValorHora(Float.valueOf(campos[6]));
							clinico.calcularValorHora();
							
							clinico.setUsuario(usuario);
							
							especialidades.add(clinico);
							especialidadeService.incluir(clinico);
							
						} catch (PeriodoInvalidoException e) {
							System.out.println("[ERROR - CLINICO GERAL] " + e.getMessage());
						} 
						
						break;
					case "P":
						try { 
							 
							Pediatria pediatria = new Pediatria();
							pediatria.setCodigo(campos[1]);
							pediatria.setNome(campos[2]);
							pediatria.setStatus(Boolean.valueOf(campos[3]));
							
							pediatria.setApenasBebes(Boolean.valueOf(campos[4]));
							pediatria.setCardiologia(Boolean.valueOf(campos[5]));						
							pediatria.setNeonatologia(Boolean.valueOf(campos[6]));  
							
							pediatria.setValorHora(Float.valueOf(campos[7]));
							pediatria.calcularValorHora();
							
							pediatria.setUsuario(usuario);
							 
							especialidades.add(pediatria);
							especialidadeService.incluir(pediatria);
							
						} catch (ValorHoraZeradoException e) {
							System.out.println("[ERROR - PEDIATRIA] " + e.getMessage());
						} 
						
						break;
						 
					default:
						break;
					}
  

					linha = leitura.readLine();
				}

				leitura.close();
				fileReader.close();

			} catch (FileNotFoundException e) {
				System.out.println("[ERROR] O arquivo não existe!");
			} catch (IOException e) {
				System.out.println("[ERROR] Problemas no fechamaneto do arquivo!");
			}

		} finally {
			System.out.println("Processo finalizado!");
		}

	}

}
