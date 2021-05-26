package model;

public class Autor {
	// Declarando os atributos
		private int codigo;
		private String nome;
		private String nacionalidade;
		
		// Construtor da classe Autor.
		public Autor() {
			
		}
		// Métodos getter e setter para acesso ao atributos.

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getNacionalidade() {
			return nacionalidade;
		}

		public void setNacionalidade(String nacionalidade) {
			this.nacionalidade = nacionalidade;
		}
	
}
