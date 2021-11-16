package solucoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.EstoqueDao;
import modelo.Estoque;

public class TesteConexao {

	public static void main(String[] args) {
		testar();

		System.out.println("***************************************");

		menu();
	}

	public static void menu() {
		int op;
		String opp;
		Scanner leia = new Scanner(System.in);
		do {

		System.out.println("----MENU ESTOQUE DE SMARTPHONES - ESCOLHA A OPÇÃO QUE DESEJA ABAIXO----");
		System.out.println("|1- para cadastrar produtos|" + "\n" + "|2- para consultar todo estoque|" + "\n"
				+ "|3- para pesquisar por marca|" + "\n" + "|4- para editar algum produto|" + "\n"
				+ "|5- para excuir algum item pelo ID|" + "\n" + "|6- para sair do menu|");
		op = leia.nextInt();
		leia.nextLine();
		if (op != 1 && op != 2 && op != 3 && op != 4 && op != 5 && op != 6) {
			System.out.println("Opção inválida tente novamente!!!");
			System.out.println("|1- para cadastrar produtos|" + "\n" + "|2- para consultar todo estoque|" + "\n"
					+ "|3- para pesquisar por marca|" + "\n" + "|4- para editar algum produto|" + "\n"
					+ "|5- para excuir algum item pelo ID|" + "\n" + "|6- para sair do menu|");
			op = leia.nextInt();
		}

		

			switch (op) {

			case 1:
				cadastrar();
				break;

			case 2:
				mostrarTodos();
				break;

			case 3:
				pesquisarMarca();
			break;
			
			case 4:
				editar();
			break;
			
			case 5:
				excluir();
			break;
			
			case 6:
				System.out.println("fechando.......");
			break;
			}

			System.out.println("Deseja continuar usando o menu [s] ou [n]?");
			opp = leia.next();
			if (opp.equalsIgnoreCase("n")) {
				System.out.println("Saindo do menu...........");
			}

		} while (opp.equalsIgnoreCase("s"));
		
	}

	public static void testar() {
		try {
			Conexao c = new Conexao();

			c.getConexao();
			System.out.println("Banco Conectado");

		} catch (Exception e) {
			System.out.println("Erro!!!!!" + e.getMessage());

		}
	}

	public static void cadastrar() {
		Scanner leia = new Scanner(System.in);
		Estoque e = new Estoque();
		System.out.println("Digite a quantidade de itens que deseja cadastrar: ");
		int qtd = leia.nextInt();
		leia.nextLine();

		for (int i = 0; i < qtd; i++) {
			System.out.println("Digite a marca: ");
			e.setMarca(leia.next());
			System.out.println("Digite o modelo: ");
			e.setModelo(leia.next());
			System.out.println("Digite a cor: ");
			e.setCor(leia.next());
			System.out.println("Digite a memória interna: ");
			e.setMemoriaInterna(leia.next());
			System.out.println("Digite a memória ram: ");
			e.setMemoriaRam(leia.next());
			System.out.println("Digite a qualidade da camêra traseira: ");
			e.setCameraTraseira(leia.next());
			System.out.println("Digite a qualidade da camêra frontal");
			e.setCameraFrontal(leia.next());
			System.out.println("Digite o tamanho da tela: ");
			e.setTela(leia.nextDouble());
			System.out.println("Digite o processador: ");
			e.setProcessador(leia.next());
			System.out.println("Digite a quantidade de itens: ");
			e.setQuantidade(leia.nextInt());
			leia.nextLine();
			System.out.println("Digite o preço: ");
			e.setPreco(leia.nextDouble());

			EstoqueDao dao = new EstoqueDao();

			dao.cadastrar(e);
		}

	}

	public static void mostrarTodos() {
		List<Estoque> est = new ArrayList<>();

		EstoqueDao dao = new EstoqueDao();

		est = dao.listarDB();
		int cont = 0;

		for (int i = 0; i < est.size(); i++) {
			System.out.println("************************************");
			System.out.println("ID do item: " + est.get(i).getId());
			System.out.println("Marca: " + est.get(i).getMarca());
			System.out.println("Modelo: " + est.get(i).getModelo());
			System.out.println("Cor: " + est.get(i).getCor());
			System.out.println("Memória Interna: " + est.get(i).getMemoriaInterna());
			System.out.println("Memória Ram: " + est.get(i).getMemoriaRam());
			System.out.println("Camêra Traseira: " + est.get(i).getCameraTraseira());
			System.out.println("Camêra Frontal: " + est.get(i).getCameraFrontal());
			System.out.println("Tela: " + est.get(i).getTela());
			System.out.println("Processador: " + est.get(i).getProcessador());
			System.out.println("Quantidade de Itens: " + est.get(i).getQuantidade());
			System.out.println("Preço: " + est.get(i).getPreco());
			cont++;

		}
		System.out.println("Totatl de Produtos encontrados é: " + cont);

	}

	public static void pesquisarMarca() {
		List<Estoque> est = new ArrayList<>();

		EstoqueDao dao = new EstoqueDao();

		est = dao.pesquisaMarca();
		int cont = 0;

		for (int i = 0; i < est.size(); i++) {
			System.out.println("************************************");
			System.out.println("ID do item: " + est.get(i).getId());
			System.out.println("Marca: " + est.get(i).getMarca());
			System.out.println("Modelo: " + est.get(i).getModelo());
			System.out.println("Cor: " + est.get(i).getCor());
			System.out.println("Memória Interna: " + est.get(i).getMemoriaInterna());
			System.out.println("Memória Ram: " + est.get(i).getMemoriaRam());
			System.out.println("Camêra Traseira: " + est.get(i).getCameraTraseira());
			System.out.println("Camêra Frontal: " + est.get(i).getCameraFrontal());
			System.out.println("Tela: " + est.get(i).getTela());
			System.out.println("Processador: " + est.get(i).getProcessador());
			System.out.println("Quantidade de Itens: " + est.get(i).getQuantidade());
			System.out.println("Preço: " + est.get(i).getPreco());
			cont++;

		}
		System.out.println("Totatl de Produtos encontrados é: " + cont);

	}

	public static void editar() {
		Scanner s = new Scanner(System.in);

		List<Estoque> est = new ArrayList<>();

		EstoqueDao dao = new EstoqueDao();

		est = dao.listarDB();

		Estoque es = new Estoque();
		System.out.println("Digite o ID do item a ser alterado: ");
		int id = s.nextInt();
		s.nextLine();

		String opc;

		System.out.println("Deseja alterar a marca: " + est.get(id - 1).getMarca() + " [s] ou [n]?");
		opc = s.next();

		if (opc.equalsIgnoreCase("s")) {
			System.out.println("Qual a nova marca: ");
			es.setMarca(s.next());
		} else {
			es.setMarca(est.get(id - 1).getMarca());
		}

		System.out.println("Deseja alterar o modelo: " + est.get(id - 1).getModelo() + " [s] ou [n]?");
		opc = s.next();

		if (opc.equalsIgnoreCase("s")) {
			System.out.println("Qual a novo modelo: ");
			es.setModelo(s.next());
		} else {
			es.setModelo(est.get(id - 1).getModelo());
		}

		System.out.println("Deseja alterar a cor: " + est.get(id - 1).getCor() + " [s] ou [n]?");
		opc = s.next();

		if (opc.equalsIgnoreCase("s")) {
			System.out.println("Qual a nova cor: ");
			es.setCor(s.next());
		} else {
			es.setCor(est.get(id - 1).getCor());
		}

		System.out.println("Deseja alterar a memória interna: " + est.get(id - 1).getMemoriaInterna() + " [s] ou [n]?");
		opc = s.next();

		if (opc.equalsIgnoreCase("s")) {
			System.out.println("Qual a nova memória interna: ");
			es.setMemoriaInterna(s.next());
		} else {
			es.setMemoriaInterna(est.get(id - 1).getMemoriaInterna());
		}

		System.out.println("Deseja alterar a memória ram: " + est.get(id - 1).getMemoriaRam() + " [s] ou [n]?");
		opc = s.next();

		if (opc.equalsIgnoreCase("s")) {
			System.out.println("Qual a nova memória ram: ");
			es.setMemoriaRam(s.next());
		} else {
			es.setMemoriaRam(est.get(id - 1).getMemoriaRam());
		}

		System.out.println("Deseja alterar a camêra traseira: " + est.get(id - 1).getCameraTraseira() + " [s] ou [n]?");
		opc = s.next();

		if (opc.equalsIgnoreCase("s")) {
			System.out.println("Qual a nova camêra traseira: ");
			es.setCameraTraseira(s.next());
		} else {
			es.setCameraTraseira(est.get(id - 1).getCameraTraseira());
		}

		System.out.println("Deseja alterar a camêra frontal: " + est.get(id - 1).getCameraFrontal() + " [s] ou [n]?");
		opc = s.next();

		if (opc.equalsIgnoreCase("s")) {
			System.out.println("Qual a nova camêra frontal: ");
			es.setCameraFrontal(s.next());
		} else {
			es.setCameraFrontal(est.get(id - 1).getCameraFrontal());
		}

		System.out.println("Deseja alterar a tela: " + est.get(id - 1).getTela() + " [s] ou [n]?");
		opc = s.next();

		if (opc.equalsIgnoreCase("s")) {
			System.out.println("Qual a nova tela: ");
			es.setTela(s.nextDouble());
		} else {
			es.setTela(est.get(id - 1).getTela());
		}

		System.out.println("Deseja alterar o processador: " + est.get(id - 1).getProcessador() + " [s] ou [n]?");
		opc = s.next();

		if (opc.equalsIgnoreCase("s")) {
			System.out.println("Qual a novo processador: ");
			es.setProcessador(s.next());
		} else {
			es.setProcessador(est.get(id - 1).getProcessador());
		}

		System.out.println("Deseja alterar a quantidade: " + est.get(id - 1).getQuantidade() + " [s] ou [n]?");
		opc = s.next();

		if (opc.equalsIgnoreCase("s")) {
			System.out.println("Qual a nova quantidade: ");
			es.setQuantidade(s.nextInt());
			s.nextLine();
		} else {
			es.setQuantidade(est.get(id - 1).getQuantidade());
		}

		System.out.println("Deseja alterar o preço: " + est.get(id - 1).getPreco() + " [s] ou [n]?");
		opc = s.next();

		if (opc.equalsIgnoreCase("s")) {
			System.out.println("Qual a novo preço: ");
			es.setPreco(s.nextDouble());
		} else {
			es.setPreco(est.get(id - 1).getPreco());
		}

		EstoqueDao edit = new EstoqueDao();
		edit.editar(es, id);

	}

	public static void excluir() {
		Scanner s = new Scanner(System.in);
		Estoque es = new Estoque();

		System.out.println("Digite o ID a ser excluido");
		int id = s.nextInt();
		s.nextLine();

		EstoqueDao dao = new EstoqueDao();

		dao.excluir(es, id);

	}
}