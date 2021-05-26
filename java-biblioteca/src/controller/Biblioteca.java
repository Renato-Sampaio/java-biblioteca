package controller;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import model.Autor;
import model.Data;
import model.Editora;
import model.Livro;
import model.Locacao;
import model.Usuario;

/**
 * Classe controller para gerir biblioteca
 * @author Renato Duarte Sampaio
 * @since 18 de fev. de 2021
 */
public class Biblioteca {
	// Vari�veis globais para incrementar o c�digo de usu�rio e c�digo de livro
	int contadorUsuarios = 1;
	int contadorLivros = 1;
	int contadorAutores = 1;
	int contadorLocacoes = 1;

	// Declarando os atributos / vetores
	private Livro livros[];
	private Usuario usuarios[];
	private Locacao locacoes[];

	// Declarando vari�veis para atribuir ao tamanho dos respectivos vetores
	int tamanhoLivro;
	int tamanhoUsuarios;
	int tamanhoLocacoes;

	// Construtor
	public Biblioteca() {
		processar();
	}

	// Gerando m�todos
	public void processar() {
		// Capturando do usu�rio o tamanho do estoque
		// Do while nos tr�s inputs para verificar se os valores fornecidos s�o maiores
		// que ZERO
		do {
			tamanhoLivro = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do estoque de livros: "));
			if (tamanhoLivro <= 0) {
				JOptionPane.showMessageDialog(null, "Voc� digitou 0 ou valor negativo! :(", "Erro!!!", 0);
			}
		} while (tamanhoLivro <= 0);
		// Capturando do usu�rio o tamanho do vetor de usu�rios para armazernar clientes
		do {
			tamanhoUsuarios = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de usu�rios: "));
			if (tamanhoUsuarios <= 0) {
				JOptionPane.showMessageDialog(null, "Voc� digitou 0 ou valor negativo! :(", "Erro!!!", 0);
			}
		} while (tamanhoUsuarios <= 0);
		// Capturando do usu�rio o limite de loca��es
		do {
			tamanhoLocacoes = Integer
					.parseInt(JOptionPane.showInputDialog("Informe a quantidade m�xima de loca��es: "));
			if (tamanhoLocacoes <= 0) {
				JOptionPane.showMessageDialog(null, "Voc� digitou 0 ou valor negativo! :(", "Erro!!!", 0);
			}
		} while (tamanhoLocacoes <= 0);

		// Atribuindo valor de tamanho aos vetores de acordo com o que o usu�rio passou
		livros = new Livro[tamanhoLivro];
		usuarios = new Usuario[tamanhoUsuarios];
		locacoes = new Locacao[tamanhoLocacoes];

		// Fun��o para popular nossa aplica��o com alguns cadastros e registros
		//cadastroAutomatico();

		// Loop para apresentar menu principal
		while (true) {
			escolhaUsuario();
		}
	}

	// Gerando menu para escolha do usu�rio
	public void escolhaUsuario() {
		// Criando String de apresenta��o do menu
		String menu = "========== M E N U ==========\n\n" + "OP��O 1: Cadastrar livro\n"
				+ "OP��O 2: Cadastrar usu�rio\n" + "OP��O 3: Efetuar loca��o\n" + "OP��O 4: Efetuar devolu��o\n"
				+ "OP��O 5: Listar livros\n" + "OP��O 6: Listar usu�rios\n" + "OP��O 7: Pesquisar livro por editora\n"
				+ "OP��O 8: Pesquisar livro por autor\n" + "OP��O 9: Pesquisar loca��es por data\n"
				+ "OP��O 10: Sair do Sistema\n \nInforme a op��o desejada:";

		// Capturando a escolha do usu�rio
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));

		// Chamando m�todo de processamento da op��o escolhida
		escolhaProcessamento(escolha);
	}

	// M�todo para popular alguns registros da aplica��o
//	public void cadastroAutomatico() {
//		Usuario usuario1 = new Usuario();
//		Usuario usuario2 = new Usuario();
//		Usuario usuario3 = new Usuario();
//		Usuario usuario4 = new Usuario();
//		Usuario usuario5 = new Usuario();
//		Usuario usuario6 = new Usuario();
//		Usuario usuario7 = new Usuario();
//
//		Autor autor1 = new Autor();
//		Autor autor2 = new Autor();
//		Autor autor3 = new Autor();
//		Editora editora1 = new Editora();
//		Editora editora2 = new Editora();
//		Editora editora3 = new Editora();
//		Data data = new Data();
//
//		autor1.setCodigo(001);
//		autor1.setNacionalidade("BR");
//		autor1.setNome("Machado de Assis");
//
//		autor2.setCodigo(002);
//		autor2.setNacionalidade("USA");
//		autor2.setNome("Keith Sierra");
//
//		autor3.setCodigo(003);
//		autor3.setNacionalidade("USA");
//		autor3.setNome("Linus Torvalds");
//
//		editora1.setCodigo(001);
//		editora1.setNome("Abril");
//		editora1.setPais("BR");
//
//		editora2.setCodigo(002);
//		editora2.setNome("Maia");
//		editora2.setPais("Argentina");
//
//		editora3.setCodigo(003);
//		editora3.setNome("Alta Books");
//		editora3.setPais("BR");
//
//		Livro livro1 = new Livro();
//		Livro livro2 = new Livro();
//		Livro livro3 = new Livro();
//		Livro livro4 = new Livro();
//		Livro livro5 = new Livro();
//		Livro livro6 = new Livro();
//		Livro livro7 = new Livro();
//		Livro livro8 = new Livro();
//		Livro livro9 = new Livro();
//		Livro livro10 = new Livro();
//
//		Locacao locacao1 = new Locacao();
//		Locacao locacao2 = new Locacao();
//		Locacao locacao3 = new Locacao();
//
//		data.setDia(01);
//		data.setMes(03);
//		data.setAno(2000);
//
//		usuario1.setCodigo(001);
//		usuario1.setEmail("gustavo.com");
//		usuario1.setNome("Gustavo");
//		usuario1.setTelefone("99887766");
//		usuario1.setDataNascimento(data);
//
//		usuario2.setCodigo(002);
//		usuario2.setEmail("renato.com");
//		usuario2.setNome("Renato");
//		usuario2.setTelefone("99887766");
//		usuario2.setDataNascimento(data);
//
//		usuario3.setCodigo(003);
//		usuario3.setEmail("gustavo.com");
//		usuario3.setNome("Nathi");
//		usuario3.setTelefone("99887766");
//		usuario3.setDataNascimento(data);
//
//		usuario4.setCodigo(004);
//		usuario4.setEmail("gustavo.com");
//		usuario4.setNome("Matheus");
//		usuario4.setTelefone("99887766");
//		usuario4.setDataNascimento(data);
//
//		usuario5.setCodigo(005);
//		usuario5.setEmail("gustavo.com");
//		usuario5.setNome("Israel");
//		usuario5.setTelefone("99887766");
//		usuario5.setDataNascimento(data);
//
//		usuario6.setCodigo(006);
//		usuario6.setEmail("gustavo.com");
//		usuario6.setNome("Mayke");
//		usuario6.setTelefone("99887766");
//		usuario6.setDataNascimento(data);
//
//		usuario7.setCodigo(007);
//		usuario7.setEmail("gustavo.com");
//		usuario7.setNome("Eric");
//		usuario7.setTelefone("99887766");
//		usuario7.setDataNascimento(data);
//
//		livro1.setAnoPublicacao(2000);
//		livro1.setAutor(autor1);
//		livro1.setCodigo(1);
//		livro1.setDisponivel(true);
//		livro1.setEditora(editora1);
//		livro1.setTitulo("Dom casmurro");
//
//		livro2.setAnoPublicacao(2000);
//		livro2.setAutor(autor2);
//		livro2.setCodigo(2);
//		livro2.setDisponivel(true);
//		livro2.setEditora(editora2);
//		livro2.setTitulo("11 minutos");
//
//		livro3.setAnoPublicacao(2000);
//		livro3.setAutor(autor3);
//		livro3.setCodigo(3);
//		livro3.setDisponivel(true);
//		livro3.setEditora(editora3);
//		livro3.setTitulo("Codigo da vinci");
//
//		livro4.setAnoPublicacao(2000);
//		livro4.setAutor(autor3);
//		livro4.setCodigo(4);
//		livro4.setDisponivel(true);
//		livro4.setEditora(editora3);
//		livro4.setTitulo("Eloquent Javascript");
//
//		livro5.setAnoPublicacao(2000);
//		livro5.setAutor(autor2);
//		livro5.setCodigo(5);
//		livro5.setDisponivel(true);
//		livro5.setEditora(editora2);
//		livro5.setTitulo("Linux");
//
//		livro6.setAnoPublicacao(2000);
//		livro6.setAutor(autor1);
//		livro6.setCodigo(6);
//		livro6.setDisponivel(true);
//		livro6.setEditora(editora1);
//		livro6.setTitulo("Design Patterns");
//
//		livro7.setAnoPublicacao(2000);
//		livro7.setAutor(autor1);
//		livro7.setCodigo(7);
//		livro7.setDisponivel(true);
//		livro7.setEditora(editora2);
//		livro7.setTitulo("MySQL");
//
//		livro8.setAnoPublicacao(2000);
//		livro8.setAutor(autor2);
//		livro8.setCodigo(8);
//		livro8.setDisponivel(false);
//		livro8.setEditora(editora3);
//		livro8.setTitulo("Use a cabe�a - Java");
//
//		livro9.setAnoPublicacao(2000);
//		livro9.setAutor(autor3);
//		livro9.setCodigo(9);
//		livro9.setDisponivel(false);
//		livro9.setEditora(editora1);
//		livro9.setTitulo("Vidas secas");
//
//		livro10.setAnoPublicacao(2000);
//		livro10.setAutor(autor2);
//		livro10.setCodigo(10);
//		livro10.setDisponivel(false);
//		livro10.setEditora(editora1);
//		livro10.setTitulo("Capit�es de areia");
//
//		Livro livros1[] = new Livro[1];
//		Livro livros2[] = new Livro[1];
//		Livro livros3[] = new Livro[1];
//
//		livros1[0] = livro10;
//		livros2[0] = livro9;
//		livros3[0] = livro8;
//
//		locacao1.setCodigo(1);
//		locacao1.setDataDevolucao(data);
//		locacao1.setDataLocacao(data);
//		locacao1.setLivros(livros1);
//		locacao1.setUsuario(usuario7);
//
//		locacao2.setCodigo(2);
//		locacao2.setDataDevolucao(data);
//		locacao2.setDataLocacao(data);
//		locacao2.setLivros(livros2);
//		locacao2.setUsuario(usuario6);
//
//		locacao3.setCodigo(3);
//		locacao3.setDataDevolucao(data);
//		locacao3.setDataLocacao(data);
//		locacao3.setLivros(livros3);
//		locacao3.setUsuario(usuario5);
//
//		locacoes[0] = locacao1;
//		locacoes[1] = locacao2;
//		locacoes[2] = locacao3;
//
//		usuarios[0] = usuario1;
//		usuarios[1] = usuario2;
//		usuarios[2] = usuario3;
//		usuarios[3] = usuario4;
//		usuarios[4] = usuario5;
//		usuarios[5] = usuario6;
//		usuarios[6] = usuario7;
//
//		livros[0] = livro1;
//		livros[1] = livro2;
//		livros[2] = livro3;
//		livros[3] = livro4;
//		livros[4] = livro5;
//		livros[5] = livro6;
//		livros[6] = livro7;
//		livros[7] = livro8;
//		livros[8] = livro9;
//		livros[9] = livro10;
//
//	}

	// Switch para escolher a op��o do usu�rio e levar ao m�todo referente
	public void escolhaProcessamento(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarLivro();
			break;
		case 2:
			cadastrarUsuario();
			break;
		case 3:
			validaLocacao();
			break;
		case 4:
			efetuarDevolucao();
			break;
		case 5:
			listarLivros();
			break;
		case 6:
			listarUsuarios();
			break;
		case 7:
			pesquisarLivroPorEditora();
			break;
		case 8:
			pesquisarLivroPorAutor();
			break;
		case 9:
			pesquisarLocacoesPorData();
			break;
		case 10:
			sair();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Op��o inv�lida!", "MENU", 0); // erro
			break;
		}
	}

	// 1 - Cadastrando livros
	public void cadastrarLivro() {
		// Vari�vel auxiliar para verificar se livro foi cadastrado com sucesso
		boolean cadastrado = false;

		// Varrendo o vetor de livros para verificar se existe espa�o para cadastro
		// ainda dispon�vel e atribuir novo cadastro na primeira posi��o vazia
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] == null) {
				// Chamando m�todo para criar um novo livro na posi��o dispon�vel
				livros[i] = criarLivro();
				// Validando cadastro para apresentar mensagem de sucesso
				cadastrado = true;
				break;
			}
		}

		// Apresentando mensagem de sucesso ou n�o para usu�rio
		if (cadastrado) {
			JOptionPane.showInternalMessageDialog(null, "Livro cadastrado com sucesso!", "Cadastro de Livro", 1);
		} else {
			JOptionPane.showInternalMessageDialog(null, "Estoque cheio!", "Cadastro de Livro", 2);
		}
	}

	// M�todo para criar livro
	public Livro criarLivro() {
		// Instanciando objetos livro, autor e editora
		Livro livro = new Livro();
		Autor autor = new Autor();
		Editora editora = new Editora();

		// Cadastrando informa��es sobre o autor
		autor.setNome(JOptionPane.showInputDialog("Informe o nome do autor: "));
		autor.setNacionalidade(JOptionPane.showInputDialog("Informe a nacionalidade do autor: "));
		autor.setCodigo(contadorAutores);
		contadorAutores++;

		// Cadastrando informa��es sobre a editora
		editora.setNome(JOptionPane.showInputDialog("Informe o nome da editora: "));
		editora.setPais(JOptionPane.showInputDialog("Informe o pa�s da editora: "));
		editora.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o c�digo da editora: ")));

		// Cadastrando os dados do livro
		livro.setTitulo(JOptionPane.showInputDialog("Informe o t�tulo do livro: "));
		livro.setAnoPublicacao(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de publica��o: ")));
		livro.setCodigo(contadorLivros);
		contadorLivros++;
		livro.setDisponivel(true);
		livro.setAutor(autor);
		livro.setEditora(editora);

		// Retornando o livro cadastrado
		return livro;
	}

	// 2 - Cadastrando usu�rios
	public void cadastrarUsuario() {
		// Vari�vel auxiliar para verificar se cadastro foi efetuado com sucesso
		boolean cadastrado = false;

		// Varrendo o vetor de usu�rios para efetuar novo cadastro se o vetor n�o
		// estiver lotado
		for (int i = 0; i < usuarios.length; i++) {

			// checando primeira posi��o dispon�vel
			if (usuarios[i] == null) {

				// Criando usu�rio na posi��o livre
				usuarios[i] = criarUsuario();

				// Validando cadastro de usu�rio
				cadastrado = true;
				break;
			}
		}

		// Condicional para retornar mensagem de sucesso ou fracasso dependendo se o
		// cadastro foi efetuado ou n�o
		if (cadastrado) {
			JOptionPane.showInternalMessageDialog(null, "Usu�rio cadastrado com sucesso!", "Cadastro de Usu�rio", 1);
		} else {
			JOptionPane.showInternalMessageDialog(null, "Usu�rios lotados!", "Cadastro de Usu�rio", 2);
		}
	}

	// M�todo para criar usu�rio
	public Usuario criarUsuario() {
		// Instanciando novo usu�rio e data para cria��o
		Usuario usuario = new Usuario();
		Data data = new Data();

		// Recebendo data de nascimento do usu�rio
		data.setDia(Integer.parseInt(JOptionPane.showInputDialog("Informe o dia de seu nascimento: ")));
		data.setMes(Integer.parseInt(JOptionPane.showInputDialog("Informe o m�s de seu nascimento: ")));
		data.setAno(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de seu nascimento: ")));

		// Recebendo dados do usu�rio
		usuario.setNome(JOptionPane.showInputDialog("Informe seu nome: "));
		usuario.setEmail(JOptionPane.showInputDialog("Informe seu e-mail: "));
		usuario.setTelefone(JOptionPane.showInputDialog("Informe seu telefone: "));
		usuario.setCodigo(contadorUsuarios);
		contadorUsuarios++;
		usuario.setDataNascimento(data);

		// Retornando usu�rio
		return usuario;
	}

	// 3 - Efetuar loca��o
	public void efetuarLocacao() {
		// Declarando op��o
		int opcao;
		// Checando se usu�rio est� cadastrado
		// caso contr�rio o levar� para cadastro
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Usu�rio cadastrado?\n1 - Sim\n2 - N�o"));
		if (opcao == 1) {
			locar();
		} else if (opcao == 2) {
			cadastrarUsuario();
		}

	}
	
	// Validar loca��o por lota��o
	
	public void validaLocacao() {
		int contador = 0;
		int quantidadeLivros = 0;
		int quantidadeUsuarios = 0;
		for (int i = 0; i < locacoes.length; i++) {
			if (locacoes[i] != null) {
				contador++;
			}
		}
		
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null) {
				quantidadeLivros++;
			}
		}
		
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null)  {
				quantidadeUsuarios++;
			}
		}
		
		if ((quantidadeLivros == 0) || (quantidadeUsuarios == 0)) {
			JOptionPane.showMessageDialog(null, "Sem livros ou usu�rios cadastrados !\nAguarde pelo cadastramento de novos livros no acervo.", "Loca��o", 0);
		} else {
			if (contador == locacoes.length) {
				JOptionPane.showMessageDialog(null, "Loca��o indispon�vel!\nAguarde uma devolu��o", "Loca��o", 0);
			} else {
				efetuarLocacao();
			}
			
		}
		
		
		
		
		
	}

	// 3.1 M�todo - locar
	public void locar() {
		// String para concatenar mensagem com nomes de usu�rios e seus respectivos
		// c�digos
		String mensagem = "===== Lista de usu�rios cadastrados =====\n\n";
		// Percorrendo vetor de usu�rios
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				// Concatenando mensagem para apresenta��o
				mensagem += "c�d " + usuarios[i].getCodigo() + " - " + usuarios[i].getNome() + "\n";
			}
		}
		mensagem += "Informe o usu�rio";

		int codigoUsuario;
		// Recebendo c�digo do usu�rio
		codigoUsuario = Integer.parseInt(JOptionPane.showInputDialog(mensagem));

		// Condicional para verificar se usu�rio existe, caso sim, segue a execu��o caso
		// n�o, informa usu�rio inexistente
		if (usuarioExistente(codigoUsuario)) {
			// Chamando m�todo para cadastrar loca��o
			cadastroLocacao(codigoUsuario);
		} else {
			JOptionPane.showInternalMessageDialog(null, "Usu�rio inexistente", "Loca��o de livros", 2);
		}
	}

	// 3.2 M�todo - cadastro loca�ao
	public Locacao cadastroLocacao(int codigoUsuario) {
		// Instanciando nova loca��o
		Locacao locacao = new Locacao();

		// Varrendo vetor usu�rios buscando usu�rio correto pelo c�digo do usu�rio e
		// dando o set de seu usu�rio na classe loca��o

		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null && usuarios[i].getCodigo() == codigoUsuario) {
				locacao.setUsuario(usuarios[i]);
			}
		}

		// Recebendo quantidade de livros para atribuir ao vetor livros da classe
		// Loca��o
		int quantidadeLivros;
		quantidadeLivros = Integer
				.parseInt(JOptionPane.showInputDialog("Informe a quantidade de livros que deseja locar"));

		// Percorrendo vetor de livros e incrementndo em 1 cada livro que estiver
		// dispon�vel para saber quantos livros est�o dispon�veis
		int quantidadeLivrosDisponiveis = 0;
		for (int j = 0; j < livros.length; j++) {
			if (livros[j] != null && livros[j].isDisponivel()) {
				quantidadeLivrosDisponiveis++;
			}
		}

		// Verificar se quantidade de livros para loca��o fornecida pelo usu�rio � menor
		// que a de livros dispon�veis para loca��o
		if (quantidadeLivros > quantidadeLivrosDisponiveis) {
			JOptionPane.showMessageDialog(null, "Voc� informou uma quantidade de livros superior ao nosso estoque!!!",
					"Loca��o de livros", 0);
		} else {
			// Criando novo vetor de livros
			Livro livrosLocacao[] = new Livro[quantidadeLivros];

			// Varrendo livros para usu�rio escolher e fazer a loca��o
			for (int i = 0; i < quantidadeLivros; i++) {
				String livrosDisponiveis = "===== Lista de livros dispon�veis =====\n\n";
				for (int j = 0; j < livros.length; j++) {
					if (livros[j] != null && livros[j].isDisponivel()) {
						// Concatenando livros dispon�veis para a string
						livrosDisponiveis += "c�d " + livros[j].getCodigo() + " - " + livros[j].getTitulo() + "\n";
					}
				}
				livrosDisponiveis += "Informe o c�digo";

				int codigoLivro;
//				boolean livroEncontrado = false;

				// Recebendo o c�digo do livro do usu�rio
				codigoLivro = Integer.parseInt(JOptionPane.showInputDialog(livrosDisponiveis));

				// Efetuando loca��o de livro
				for (int j = 0; j < livros.length; j++) {
					// Condicional para comparar c�digo fornecido pelo usu�rio com o c�digo dos
					// livros dispon�veis no vetor
					if (livros[j] != null && livros[j].getCodigo() == codigoLivro && livros[j].isDisponivel()) {
						// Set disponibilidade do livro para false + inserir livro no vetor de
						// livrosLoca��o
						livros[j].setDisponivel(false);
						livrosLocacao[i] = livros[j];

					}
				}

			}

			// Inserindo vetor de livros locados na classe
			locacao.setLivros(livrosLocacao);

			// Chamando m�todo para criar a data de loca��o e devolu��o e inserir no
			// registro
			criarData(locacao);

			// inserindo c�digo de loca��o na classe
			locacao.setCodigo(contadorLocacoes);
			contadorLocacoes++;

			// Varrendo vetor de loca��es e caso haja espa�o cadastra a nova loca��o
			for (int i = 0; i < locacoes.length; i++) {
				if (locacoes[i] == null) {
					locacoes[i] = locacao;
					JOptionPane.showMessageDialog(null, "Loca��o efetuada com sucesso", "Loca��o", 1);
					break;
				}
			}
		}
		return locacao;
	}

	public void criarData(Locacao locacao) {
		Data dataLocacao = new Data();

		GregorianCalendar calendario = new GregorianCalendar();
		int dia = calendario.get(GregorianCalendar.DAY_OF_MONTH);
		int mes = calendario.get(GregorianCalendar.MONTH);
		int ano = calendario.get(GregorianCalendar.YEAR);

		// setando a data de locacao
		dataLocacao.setDia(dia);
		dataLocacao.setMes(mes + 1);
		dataLocacao.setAno(ano);

		locacao.setDataLocacao(dataLocacao);

		// Adicionando 7 dias a data atual
		calendario.add(GregorianCalendar.DAY_OF_MONTH, 7);

		// atribuindo novos valores
		int diaDevolucao = calendario.get(GregorianCalendar.DAY_OF_MONTH);
		int mesDevolucao = calendario.get(GregorianCalendar.MONTH);
		int anoDevolucao = calendario.get(GregorianCalendar.YEAR);

		// Instanciando nova data para armazenar a data de devolu��o
		Data dataDevolucao = new Data();
		dataDevolucao.setAno(anoDevolucao);
		dataDevolucao.setMes(mesDevolucao + 1);
		dataDevolucao.setDia(diaDevolucao);

		// Atribuindo data de devolu��o ao nosso objeto loca��o
		locacao.setDataDevolucao(dataDevolucao);
	}

	public boolean usuarioExistente(int codigoUsuario) {
		boolean usuarioExiste = false;
		// Checando se usu�rio � existente
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null && codigoUsuario == usuarios[i].getCodigo()) {
				usuarioExiste = true;
			}
		}

		return usuarioExiste;
	}

	// 4 - Efetuar devolucao
	public void efetuarDevolucao() {
		// Receber o c�digo do usu�rio atrav�s de input
		int codigoLocacao;
		boolean devolvido = false;
		codigoLocacao = Integer.parseInt(JOptionPane.showInputDialog(" Informe - C�digo de loca��o: "));

		for (int i = 0; i < locacoes.length; i++) {
			if (locacoes[i] != null && locacoes[i].getCodigo() == codigoLocacao) {
				Livro livros[] = new Livro[locacoes[i].getLivros().length];
				livros = locacoes[i].getLivros();

				for (int j = 0; j < locacoes[i].getLivros().length; j++) {
					livros[j].setDisponivel(true);
					devolvido = true;
				}
				locacoes[i] = null;
			}

		}
		if (devolvido) {
			JOptionPane.showMessageDialog(null, "Devolu��o efetuada com sucesso!!!", "Devolu��o de livros", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Devolu��o inexistente, por favor, checar seu c�digo de loca��o!",
					"Devolu��o de livros", 0);
		}

	}

	// 5 - Listar livros cadastrados
	public void listarLivros() {

		// Vari�vel auxiliar para contatenar os livros
		String mensagem = "\n";

		// La�o para percorrer o vetor de livros
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null) {
				mensagem += "Titulo : " + livros[i].getTitulo() + "\n";
				mensagem += "C�digo do livro : " + livros[i].getCodigo() + "\n\n";
			}
		}
		// Exibindo livros
		if (livros[0] != null) {
			JOptionPane.showMessageDialog(null, mensagem, "Listagem de livros", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Estoque vazio!", "Listagem de livros", 1);
		}

	}

	// 6 - listar usu�rios
	public void listarUsuarios() {
		// Vari�vel auxiliar para contatenar os usu�rios
		String mensagem = "\n";

		// La�o para percorrer o vetor de livros
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				mensagem += "C�digo do Usuario: " + usuarios[i].getCodigo() + "\n";
				mensagem += "Nome: " + usuarios[i].getNome() + "\n\n";
			}
		}
		// Exibindo usu�rios

		if (usuarios[0] != null) {
			JOptionPane.showMessageDialog(null, mensagem, "Listagem de usu�rios", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum usu�rio cadastrado!", "Listagem de usu�rios", 1);
		}
	}

	// 7 - pesquisar livros por editora
	public void pesquisarLivroPorEditora() {
		// Recebendo nome do editora a ser pesquisado
		String editora = JOptionPane.showInputDialog("Informe a editora que deseja pesquisar");

		// Criando vari�vel auxiliar para concatenar livros referentes � editora da
		// pesquisa
		String mensagem = "";

		// Criando boolean para atribuir valor de true, caso hajam livros para
		// apresentar mensagem no final
		boolean existe = false;

		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null && livros[i].getEditora().getNome().equals(editora)) {
				mensagem += "C�digo da editora: " + livros[i].getEditora().getCodigo() + "     |   ";
				mensagem += "Editora: " + livros[i].getEditora().getNome() + "\n";
				mensagem += "C�digo do livro: " + livros[i].getCodigo() + "     |   ";
				mensagem += "Titulo : " + livros[i].getTitulo() + "\n" + "\n";
				existe = true;
			}
		}

		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Listagem editora " + editora, 1);
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum livro encontrado :(", "Listagem editora " + editora, 2);
		}
	}

	// 8 - pesquisar livros por autor
	public void pesquisarLivroPorAutor() {

		// Recebendo nome do livro a ser pesquisado
		String autor = JOptionPane.showInputDialog("Informe o autor que deseja pesquisar");

		// Criando vari�vel auxiliar para concatenar livros referentes � editora da
		// pesquisa
		String mensagem = "";

		// Criando boolean para atribuir valor de true, caso hajam livros para
		// apresentar mensagem no final

		boolean existe = false;
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null && livros[i].getAutor().getNome().equals(autor)) {
				mensagem += " C�digo do livro : " + livros[i].getCodigo() + "  |   ";
				mensagem += "Titulo : " + livros[i].getTitulo() + "\n";
				mensagem += "Autor  : " + livros[i].getAutor().getNome() + "  |   ";
				mensagem += "C�digo do Autor  : " + livros[i].getAutor().getCodigo() + "\n" + "\n";
				existe = true;
			}
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Listagem de " + autor, 1);
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum livro encontrado :(", "Listagem de " + autor, 2);
		}
	}

	// 9 - pesquisar loca��es por data
	public void pesquisarLocacoesPorData() {
		Locacao locacao = new Locacao();

		String dataLocacao = JOptionPane.showInputDialog("Informe a data de loca��o para pesquisa.");

		String dataProcura[] = dataLocacao.split("/");

		int diaProcura = Integer.parseInt(dataProcura[0]);
		int mesProcura = Integer.parseInt(dataProcura[1]);
		int anoProcura = Integer.parseInt(dataProcura[2]);

		String mensagem = " Pesquisa por Data de Loca��o: " + dataLocacao + "\n \n";
		boolean existe = false;

		for (int i = 0; i < locacoes.length; i++) {
			if (locacoes[i] != null) {
				int diaLocacao = (locacoes[i].getDataLocacao().getDia());
				if (diaLocacao == diaProcura) {
					int mesLocacao = (locacoes[i].getDataLocacao().getMes());
					if (mesLocacao == mesProcura) {
						int anoLocacao = (locacoes[i].getDataLocacao().getAno());
						if (anoLocacao == anoProcura) {
							existe = true;
							locacao.setCodigo(locacoes[i].getCodigo());
							locacao.setUsuario(locacoes[i].getUsuario());
							mensagem += "C�d loca��o: " + locacao.getCodigo() + "\nLoca��o efetucada por "
									+ locacao.getUsuario().getNome() + "\n";
							for (int j = 0; j < locacoes[i].getLivros().length; j++) {
								mensagem += "C�d." + locacoes[i].getLivros()[j].getCodigo() + " - ";
								mensagem += locacoes[i].getLivros()[j].getTitulo() + "\n";
							}
							mensagem += "\n";
						}
					}
				}
			}
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Pesquisa por data de loca��o", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum livro locado na data " + dataLocacao,
					"Pesquisa por data de locacao", 2);
		}
	}

	// 10 - Sair do sistema
	public void sair() {
		System.exit(0);
	}
}