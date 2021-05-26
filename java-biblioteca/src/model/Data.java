package model;

public class Data {
	// Declarando os atributos
	private int dia;
	private int mes;
	private int ano;
	 
	// Método contrutor da classe data.
	public Data() {
		
	}
	
	// Métodos getter e setter para acesso ao atributos.
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	//to String para apresentação da data.
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}

}