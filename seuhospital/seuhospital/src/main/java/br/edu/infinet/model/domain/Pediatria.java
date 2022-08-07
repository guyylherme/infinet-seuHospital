package br.edu.infinet.model.domain;

public class Pediatria  extends Especialidade{
	
	public boolean neonatologia;
	public boolean cardiologia;
	public boolean apenasBebes;
	
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
	
	

}
