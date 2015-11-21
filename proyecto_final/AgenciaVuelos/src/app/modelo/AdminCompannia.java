package app.modelo;

import java.io.Serializable;
import java.util.Date;

public class AdminCompannia extends Usuario implements Serializable{
	
	private long numRegistro;	
	private Compannia compannia;
	
	public AdminCompannia() {
		
	}
	
	
	public long getNumRegistro() {
		return numRegistro;
	}
	public void setNumRegistro(long numRegistro) {
		this.numRegistro = numRegistro;
	}
	public Compannia getCompannia() {
		return compannia;
	}
	public void setCompannia(Compannia compannia) {
		this.compannia = compannia;
	}

	@Override
	public String toString() {
		return "AdminCompannia [numRegistro=" + numRegistro + ", compannia="
				+ compannia + "]";
	}	
	
}
