package br.edu.infinet.model.domain;

public class Pediatria  extends Especialidade{
	
	public boolean neonatologia;
	public boolean cardiologia;
	public boolean apenasBebes;
	
	@Override
	public float calcularValorHora() {
		
		float adicionalNeonatal = neonatologia ? valorHora * 0.6f : valorHora * 0.3f;
		float adicionalCardiologia = cardiologia ? valorHora * 0.9f : valorHora * 0.4f;
		float adicionalBebe = apenasBebes ? valorHora * 0.4f : valorHora * 0.2f;
		
		return super.calcularValorHora() + adicionalNeonatal + adicionalCardiologia + adicionalBebe;
	}
	
	@Override
	public String toString() {
		return "Pediatria [neonatologia=" + neonatologia + ", cardiologia=" + cardiologia + ", apenasBebes="
				+ apenasBebes + ", " + super.toString() + "]";
	}

	public boolean isNeonatologia() {
		return neonatologia;
	}

	public void setNeonatologia(boolean neonatologia) {
		this.neonatologia = neonatologia;
	}

	public boolean isCardiologia() {
		return cardiologia;
	}

	public void setCardiologia(boolean cardiologia) {
		this.cardiologia = cardiologia;
	}

	public boolean isApenasBebes() {
		return apenasBebes;
	}

	public void setApenasBebes(boolean apenasBebes) {
		this.apenasBebes = apenasBebes;
	}
	
	
	@Override
	public void impressao() {
		System.out.println("#ClinicoGeral");
		System.out.println(this); 
		
	}
}
