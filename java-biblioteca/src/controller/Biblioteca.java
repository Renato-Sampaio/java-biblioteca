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
	// Variáveis globais para incrementar o código de usuário e código de livro
	int contadorUsuarios = 1;
	int contadorLivros = 1;
	int contadorAutores = 1;
	int contadorLocacoes = 1;

	// Declarando os atributos / vetores
	private Livro livros[];
	private Usuario usuarios[];
	private Locacao locacoes[];

	// Declarando variáveis para atribuir ao tamanho dos respectivos vetores
	int tamanhoLivro;
	int tamanhoUsuarios;
	int tamanhoLocacoes;

	// Construtor
	public Biblioteca() {
		processar();
	}

	// Gerando métodos
	public void processar() {
		// Capturando do usuário o tamanho do estoque
		// Do while nos três inputs para verificar se os valores fornecidos são maiores
		// que ZERO
		do {
			tamanhoLivro = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do estoque de livros: "));
			if (tamanhoLivro <= 0) {
				JOptionPane.showMessageDialog(null, "Você digitou 0 ou valor negativo! :(", "Erro!!!", 0);
			}
		} while (tamanhoLivro <= 0);
		// Capturando do usuário o tamanho do vetor de usuários para armazernar clientes
		do {
			tamanhoUsuarios = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de usuários: "));
			if (tamanhoUsuarios <= 0) {
				JOptionPane.showMessageDialog(null, "Você digitou 0 ou valor negativo! :(", "Erro!!!", 0);
			}
		} while (tamanhoUsuarios <= 0);
		// Capturando do usuário o limite de locações
		do {
			tamanhoLocacoes = Integer
					.parseInt(JOptionPane.showInputDialog("Informe a quantidade máxima de locações: "));
			if (tamanhoLocacoes <= 0) {
				JOptionPane.showMessageDialog(null, "Você digitou 0 ou valor negativo! :(", "Erro!!!", 0);
			}
		} while (tamanhoLocacoes <= 0);

		// Atribuindo valor de tamanho aos vetores de acordo com o que o usuário passou
		livros = new Livro[tamanhoLivro];
		usuarios = new Usuario[tamanhoUsuarios];
		locacoes = new Locacao[tamanhoLocacoes];

		// Função para popular nossa aplicação com alguns cadastros e registros
		//cadastroAutomatico();

		// Loop para apresentar menu principal
		while (true) {
			escolhaUsuario();
		}
	}

	// Gerando menu para escolha do usuário
	public void escolhaUsuario() {
		// Criando String de apresentação do menu
		String menu = "========== M E N U ==========\n\n" + "OPÇÃO 1: Cadastrar livro\n"
				+ "OPÇÃO 2: Cadastrar usuário\n" + "OPÇÃO 3: Efetuar locação\n" + "OPÇÃO 4: Efetuar devolução\n"
				+ "OPÇÃO 5: Listar livros\n" + "OPÇÃO 6: Listar usuários\n" + "OPÇÃO 7: Pesquisar livro por editora\n"
				+ "OPÇÃO 8: Pesquisar livro por autor\n" + "OPÇÃO 9: Pesquisar locações por data\n"
				+ "OPÇÃO 10: Sair do Sistema\n \nInforme a opção desejada:";

		// Capturando a escolha do usuário
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));

		// Chamando método de processamento da opção escolhida
		escolhaProcessamento(escolha);
	}

	// Método para popular alguns registros da aplicação
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
//		livro8.setTitulo("Use a cabeça - Java");
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
//		livro10.setTitulo("Capitães de areia");
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

	// Switch para escolher a opção do usuário e levar ao método referente
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
			JOptionPane.showMessageDialog(null, "Opção inválida!", "MENU", 0); // erro
			break;
		}
	}

	// 1 - Cadastrando livros
	public void cadastrarLivro() {
		// Variável auxiliar para verificar se livro foi cadastrado com sucesso
		boolean cadastrado = false;

		// Varrendo o vetor de livros para verificar se existe espaço para cadastro
		// ainda disponível e atribuir novo cadastro na primeira posição vazia
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] == null) {
				// Chamando método para criar um novo livro na posição disponível
				livros[i] = criarLivro();
				// Validando cadastro para apresentar mensagem de sucesso
				cadastrado = true;
				break;
			}
		}

		// Apresentando mensagem de sucesso ou não para usuário
		if (cadastrado) {
			JOptionPane.showInternalMessageDialog(null, "Livro cadastrado com sucesso!", "Cadastro de Livro", 1);
		} else {
			JOptionPane.showInternalMessageDialog(null, "Estoque cheio!", "Cadastro de Livro", 2);
		}
	}

	// Método para criar livro
	public Livro criarLivro() {
		// Instanciando objetos livro, autor e editora
		Livro livro = new Livro();
		Autor autor = new Autor();
		Editora editora = new Editora();

		// Cadastrando informações sobre o autor
		autor.setNome(JOptionPane.showInputDialog("Informe o nome do autor: "));
		autor.setNacionalidade(JOptionPane.showInputDialog("Informe a nacionalidade do autor: "));
		autor.setCodigo(contadorAutores);
		contadorAutores++;

		// Cadastrando informações sobre a editora
		editora.setNome(JOptionPane.showInputDialog("Informe o nome da editora: "));
		editora.setPais(JOptionPane.showInputDialog("Informe o país da editora: "));
		editora.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o código da editora: ")));

		// Cadastrando os dados do livro
		livro.setTitulo(JOptionPane.showInputDialog("Informe o título do livro: "));
		livro.setAnoPublicacao(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de publicação: ")));
		livro.setCodigo(contadorLivros);
		contadorLivros++;
		livro.setDisponivel(true);
		livro.setAutor(autor);
		livro.setEditora(editora);

		// Retornando o livro cadastrado
		return livro;
	}

	// 2 - Cadastrando usuários
	public void cadastrarUsuario() {
		// Variável auxiliar para verificar se cadastro foi efetuado com sucesso
		boolean cadastrado = false;

		// Varrendo o vetor de usuários para efetuar novo cadastro se o vetor não
		// estiver lotado
		for (int i = 0; i < usuarios.length; i++) {

			// checando primeira posição disponível
			if (usuarios[i] == null) {

				// Criando usuário na posição livre
				usuarios[i] = criarUsuario();

				// Validando cadastro de usuário
				cadastrado = true;
				break;
			}
		}

		// Condicional para retornar mensagem de sucesso ou fracasso dependendo se o
		// cadastro foi efetuado ou não
		if (cadastrado) {
			JOptionPane.showInternalMessageDialog(null, "Usuário cadastrado com sucesso!", "Cadastro de Usuário", 1);
		} else {
			JOptionPane.showInternalMessageDialog(null, "Usuários lotados!", "Cadastro de Usuário", 2);
		}
	}

	// Método para criar usuário
	public Usuario criarUsuario() {
		// Instanciando novo usuário e data para criação
		Usuario usuario = new Usuario();
		Data data = new Data();

		// Recebendo data de nascimento do usuário
		data.setDia(Integer.parseInt(JOptionPane.showInputDialog("Informe o dia de seu nascimento: ")));
		data.setMes(Integer.parseInt(JOptionPane.showInputDialog("Informe o mês de seu nascimento: ")));
		data.setAno(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de seu nascimento: ")));

		// Recebendo dados do usuário
		usuario.setNome(JOptionPane.showInputDialog("Informe seu nome: "));
		usuario.setEmail(JOptionPane.showInputDialog("Informe seu e-mail: "));
		usuario.setTelefone(JOptionPane.showInputDialog("Informe seu telefone: "));
		usuario.setCodigo(contadorUsuarios);
		contadorUsuarios++;
		usuario.setDataNascimento(data);

		// Retornando usuário
		return usuario;
	}

	// 3 - Efetuar locação
	public void efetuarLocacao() {
		// Declarando opção
		int opcao;
		// Checando se usuário está cadastrado
		// caso contrário o levará para cadastro
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Usuário cadastrado?\n1 - Sim\n2 - Não"));
		if (opcao == 1) {
			locar();
		} else if (opcao == 2) {
			cadastrarUsuario();
		}

	}
	
	// Validar locação por lotação
	
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
			JOptionPane.showMessageDialog(null, "Sem livros ou usuários cadastrados !\nAguarde pelo cadastramento de novos livros no acervo.", "Locação", 0);
		} else {
			if (contador == locacoes.length) {
				JOptionPane.showMessageDialog(null, "Locação indisponível!\nAguarde uma devolução", "Locação", 0);
			} else {
				efetuarLocacao();
			}
			
		}
		
		
		
		
		
	}

	// 3.1 Método - locar
	public void locar() {
		// String para concatenar mensagem com nomes de usuários e seus respectivos
		// códigos
		String mensagem = "===== Lista de usuários cadastrados =====\n\n";
		// Percorrendo vetor de usuários
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				// Concatenando mensagem para apresentação
				mensagem += "cód " + usuarios[i].getCodigo() + " - " + usuarios[i].getNome() + "\n";
			}
		}
		mensagem += "Informe o usuário";

		int codigoUsuario;
		// Recebendo código do usuário
		codigoUsuario = Integer.parseInt(JOptionPane.showInputDialog(mensagem));

		// Condicional para verificar se usuário existe, caso sim, segue a execução caso
		// não, informa usuário inexistente
		if (usuarioExistente(codigoUsuario)) {
			// Chamando método para cadastrar locação
			cadastroLocacao(codigoUsuario);
		} else {
			JOptionPane.showInternalMessageDialog(null, "Usuário inexistente", "Locação de livros", 2);
		}
	}

	// 3.2 Método - cadastro locaçao
	public Locacao cadastroLocacao(int codigoUsuario) {
		// Instanciando nova locação
		Locacao locacao = new Locacao();

		// Varrendo vetor usuários buscando usuário correto pelo código do usuário e
		// dando o set de seu usuário na classe locação

		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null && usuarios[i].getCodigo() == codigoUsuario) {
				locacao.setUsuario(usuarios[i]);
			}
		}

		// Recebendo quantidade de livros para atribuir ao vetor livros da classe
		// Locação
		int quantidadeLivros;
		quantidadeLivros = Integer
				.parseInt(JOptionPane.showInputDialog("Informe a quantidade de livros que deseja locar"));

		// Percorrendo vetor de livros e incrementndo em 1 cada livro que estiver
		// disponível para saber quantos livros estão disponíveis
		int quantidadeLivrosDisponiveis = 0;
		for (int j = 0; j < livros.length; j++) {
			if (livros[j] != null && livros[j].isDisponivel()) {
				quantidadeLivrosDisponiveis++;
			}
		}

		// Verificar se quantidade de livros para locação fornecida pelo usuário é menor
		// que a de livros disponíveis para locação
		if (quantidadeLivros > quantidadeLivrosDisponiveis) {
			JOptionPane.showMessageDialog(null, "Você informou uma quantidade de livros superior ao nosso estoque!!!",
					"Locação de livros", 0);
		} else {
			// Criando novo vetor de livros
			Livro livrosLocacao[] = new Livro[quantidadeLivros];

			// Varrendo livros para usuário escolher e fazer a locação
			for (int i = 0; i < quantidadeLivros; i++) {
				String livrosDisponiveis = "===== Lista de livros disponíveis =====\n\n";
				for (int j = 0; j < livros.length; j++) {
					if (livros[j] != null && livros[j].isDisponivel()) {
						// Concatenando livros disponíveis para a string
						livrosDisponiveis += "cód " + livros[j].getCodigo() + " - " + livros[j].getTitulo() + "\n";
					}
				}
				livrosDisponiveis += "Informe o código";

				int codigoLivro;
//				boolean livroEncontrado = false;

				// Recebendo o código do livro do usuário
				codigoLivro = Integer.parseInt(JOptionPane.showInputDialog(livrosDisponiveis));

				// Efetuando locação de livro
				for (int j = 0; j < livros.length; j++) {
					// Condicional para comparar código fornecido pelo usuário com o código dos
					// livros disponíveis no vetor
					if (livros[j] != null && livros[j].getCodigo() == codigoLivro && livros[j].isDisponivel()) {
						// Set disponibilidade do livro para false + inserir livro no vetor de
						// livrosLocação
						livros[j].setDisponivel(false);
						livrosLocacao[i] = livros[j];

					}
				}

			}

			// Inserindo vetor de livros locados na classe
			locacao.setLivros(livrosLocacao);

			// Chamando método para criar a data de locação e devolução e inserir no
			// registro
			criarData(locacao);

			// inserindo código de locação na classe
			locacao.setCodigo(contadorLocacoes);
			contadorLocacoes++;

			// Varrendo vetor de locações e caso haja espaço cadastra a nova locação
			for (int i = 0; i < locacoes.length; i++) {
				if (locacoes[i] == null) {
					locacoes[i] = locacao;
					JOptionPane.showMessageDialog(null, "Locação efetuada com sucesso", "Locação", 1);
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

		// Instanciando nova data para armazenar a data de devolução
		Data dataDevolucao = new Data();
		dataDevolucao.setAno(anoDevolucao);
		dataDevolucao.setMes(mesDevolucao + 1);
		dataDevolucao.setDia(diaDevolucao);

		// Atribuindo data de devolução ao nosso objeto locação
		locacao.setDataDevolucao(dataDevolucao);
	}

	public boolean usuarioExistente(int codigoUsuario) {
		boolean usuarioExiste = false;
		// Checando se usuário é existente
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null && codigoUsuario == usuarios[i].getCodigo()) {
				usuarioExiste = true;
			}
		}

		return usuarioExiste;
	}

	// 4 - Efetuar devolucao
	public void efetuarDevolucao() {
		// Receber o código do usuário através de input
		int codigoLocacao;
		boolean devolvido = false;
		codigoLocacao = Integer.parseInt(JOptionPane.showInputDialog(" Informe - Código de locação: "));

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
			JOptionPane.showMessageDialog(null, "Devolução efetuada com sucesso!!!", "Devolução de livros", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Devolução inexistente, por favor, checar seu código de locação!",
					"Devolução de livros", 0);
		}

	}

	// 5 - Listar livros cadastrados
	public void listarLivros() {

		// Variável auxiliar para contatenar os livros
		String mensagem = "\n";

		// Laço para percorrer o vetor de livros
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null) {
				mensagem += "Titulo : " + livros[i].getTitulo() + "\n";
				mensagem += "Código do livro : " + livros[i].getCodigo() + "\n\n";
			}
		}
		// Exibindo livros
		if (livros[0] != null) {
			JOptionPane.showMessageDialog(null, mensagem, "Listagem de livros", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Estoque vazio!", "Listagem de livros", 1);
		}

	}

	// 6 - listar usuários
	public void listarUsuarios() {
		// Variável auxiliar para contatenar os usuários
		String mensagem = "\n";

		// Laço para percorrer o vetor de livros
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				mensagem += "Código do Usuario: " + usuarios[i].getCodigo() + "\n";
				mensagem += "Nome: " + usuarios[i].getNome() + "\n\n";
			}
		}
		// Exibindo usuários

		if (usuarios[0] != null) {
			JOptionPane.showMessageDialog(null, mensagem, "Listagem de usuários", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado!", "Listagem de usuários", 1);
		}
	}

	// 7 - pesquisar livros por editora
	public void pesquisarLivroPorEditora() {
		// Recebendo nome do editora a ser pesquisado
		String editora = JOptionPane.showInputDialog("Informe a editora que deseja pesquisar");

		// Criando variável auxiliar para concatenar livros referentes à editora da
		// pesquisa
		String mensagem = "";

		// Criando boolean para atribuir valor de true, caso hajam livros para
		// apresentar mensagem no final
		boolean existe = false;

		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null && livros[i].getEditora().getNome().equals(editora)) {
				mensagem += "Código da editora: " + livros[i].getEditora().getCodigo() + "     |   ";
				mensagem += "Editora: " + livros[i].getEditora().getNome() + "\n";
				mensagem += "Código do livro: " + livros[i].getCodigo() + "     |   ";
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

		// Criando variável auxiliar para concatenar livros referentes à editora da
		// pesquisa
		String mensagem = "";

		// Criando boolean para atribuir valor de true, caso hajam livros para
		// apresentar mensagem no final

		boolean existe = false;
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null && livros[i].getAutor().getNome().equals(autor)) {
				mensagem += " Código do livro : " + livros[i].getCodigo() + "  |   ";
				mensagem += "Titulo : " + livros[i].getTitulo() + "\n";
				mensagem += "Autor  : " + livros[i].getAutor().getNome() + "  |   ";
				mensagem += "Código do Autor  : " + livros[i].getAutor().getCodigo() + "\n" + "\n";
				existe = true;
			}
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Listagem de " + autor, 1);
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum livro encontrado :(", "Listagem de " + autor, 2);
		}
	}

	// 9 - pesquisar locações por data
	public void pesquisarLocacoesPorData() {
		Locacao locacao = new Locacao();

		String dataLocacao = JOptionPane.showInputDialog("Informe a data de locação para pesquisa.");

		String dataProcura[] = dataLocacao.split("/");

		int diaProcura = Integer.parseInt(dataProcura[0]);
		int mesProcura = Integer.parseInt(dataProcura[1]);
		int anoProcura = Integer.parseInt(dataProcura[2]);

		String mensagem = " Pesquisa por Data de Locação: " + dataLocacao + "\n \n";
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
							mensagem += "Cód locação: " + locacao.getCodigo() + "\nLocação efetucada por "
									+ locacao.getUsuario().getNome() + "\n";
							for (int j = 0; j < locacoes[i].getLivros().length; j++) {
								mensagem += "Cód." + locacoes[i].getLivros()[j].getCodigo() + " - ";
								mensagem += locacoes[i].getLivros()[j].getTitulo() + "\n";
							}
							mensagem += "\n";
						}
					}
				}
			}
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Pesquisa por data de locação", 1);
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