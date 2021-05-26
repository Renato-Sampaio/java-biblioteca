package model;

public class Locacao {
	
	//Método construtor
	public Locacao() {
		
	}
	// declarando os atributos
			private int codigo;
			private Data dataLocacao;
			private Data dataDevolucao;
			private Livro livros[];
			private Usuario Usuario;
	
	

			//setters and getters
			public int getCodigo() {
				return codigo;
			}

			public void setCodigo(int codigo) {
				this.codigo = codigo;
			}

			public Data getDataLocacao() {
				return dataLocacao;
			}

			public void setDataLocacao(Data dataLocacao) {
				this.dataLocacao = dataLocacao;
			}

			public Data getDataDevolucao() {
				return dataDevolucao;
			}

			public void setDataDevolucao(Data dataDevolucao) {
				this.dataDevolucao = dataDevolucao;
			}

			public Livro[] getLivros() {
				return livros;
			}

			public void setLivros(Livro[] livros) {
				this.livros = livros;
			}

			public Usuario getUsuario() {
				return Usuario;
			}

			public void setUsuario(Usuario usuario) {
				Usuario = usuario;
			}
			
			
			

}
