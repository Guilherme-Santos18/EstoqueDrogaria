package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Estoque;
import model.entities.Medicamento;
import model.entities.enums.Categoria;
import model.entities.enums.Marca;
import model.services.Funcionario;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Funcionario> funcionarios = new ArrayList<>();
		boolean acesso = false;
		
		try {
		Estoque estoque = new Estoque();
		
		
		// Funcionarios já cadastrados e registrados em uma lista//
		Funcionario Elisa = new Funcionario("Elisa Tavares", "100.750.123-00", "Rua Ana medina numero 70", "41 9988448900", "Elisa13");
		Funcionario BrunoSilva = new Funcionario("Bruno Silva", "150.990.123-05", "Rua Jose Mengato numero 30", "41 9988337900", "Bruno13");
		Funcionario tijanaBoskovic = new Funcionario("CotiBosko", "118.750.118-03", "Rua Maja Ognovic numero 10", "41 9988448900", "Coti13");
		funcionarios.add(Elisa);
		funcionarios.add(BrunoSilva);
		funcionarios.add(tijanaBoskovic);
		
		
		System.out.print("Digite o codigo para acesso: ");
		String codigoAcesso = sc.nextLine();
		
		for(Funcionario func: funcionarios) {
			if(func.getCodigoAcesso().equals(codigoAcesso)) {
				acesso = true;
				break;
			}
		}
		
		if(acesso == true) {
			System.out.println("ACESSO PERMITIDO!");
			
				System.out.print("Quantidade de medicamentos a adiconar: ");
				int n = sc.nextInt();
				
				for(int i =0; i<n; i++) {
					sc.nextLine();
					System.out.print("Nome: ");
					String nome = sc.nextLine();
					System.out.print("Preco: ");
					double preco = sc.nextDouble();
					System.out.print("Data de validade: ");
					Date dataValidade = sdf.parse(sc.next());
					System.out.print("Categoria");
					Categoria categoria = Categoria.valueOf(sc.next());
					System.out.print("Quantidade: ");
					int quantidade = sc.nextInt();
					System.out.print("Marca: ");
					Marca marca = Marca.valueOf(sc.next());
					estoque.adicionar(new Medicamento(nome, preco, dataValidade, categoria, quantidade, marca));
					
				}
				System.out.println("-----------------------------------------------------------------------");
				System.out.println("Digite 1 para adicionar ou remover algum medicamentos do estoque");
				System.out.println("Digite 2 para alterar a quantidade de  algum  medicamentos do estoque");
				System.out.println("Digite 3 para pesquisar o status de algum  medicamentos do estoque");
				System.out.println("Digite 4 para terminar" );
				System.out.println("-----------------------------------------------------------------------");
				int aux = sc.nextInt();
				
				switch(aux) {
				
				case 1: 
					System.out.print("Voce deseja remover ou adicionar um medicamento no estoque (R/A)?");
					char ch1 = sc.next().charAt(0);
					if(Character.toUpperCase(ch1) == 'R') {
						sc.nextLine();
						System.out.println("Digite o nome do medicamento que voce deseja remover: ");
						String nomeMedicamento = sc.nextLine();
						estoque.remover(nomeMedicamento);
					}
					else if(Character.toUpperCase(ch1) == 'A') {
						System.out.println("Digite os dados do medicamento que voce deseja adicionar: ");
						sc.nextLine();
						System.out.print("Nome: ");
						String nome = sc.nextLine();
						System.out.print("Preco: ");
						double preco = sc.nextDouble();
						System.out.print("Data de validade: ");
						Date dataValidade = sdf.parse(sc.next());
						System.out.print("Categoria: ");
						Categoria categoria = Categoria.valueOf(sc.next());
						System.out.print("Quantidade: ");
						int quantidade = sc.nextInt();
						System.out.print("Marca: ");
						Marca marca = Marca.valueOf(sc.next());
						estoque.adicionar(new Medicamento(nome, preco, dataValidade, categoria, quantidade, marca));
					}
					else {
						System.out.println("Erro!");
					}
				break;
				case 2: 
					System.out.print("Voce deseja adicionar ou reduzir a quantidade do medicamento do estoque (A/R)? ");
					char ch2 = sc.next().charAt(0);
					
					if(Character.toUpperCase(ch2) == 'A') {
						System.out.println("Digite o nome e a quantidade do medicamento que voce deseja adionar: ");
						sc.nextLine();
						String nome = sc.nextLine();
						int quantidade = sc.nextInt();
						estoque.addQuantidade(nome, quantidade);
					}
					else if(Character.toUpperCase(ch2) == 'R') {
						System.out.println("Digite o nome e a quantidade do medicamento que voce deseja reduzir: ");
						sc.nextLine();
						String nome = sc.nextLine();
						int quantidade = sc.nextInt();
						estoque.removerQuantidade(nome, quantidade);
					}
					else {
						System.out.println("Erro!");
					}
					break;
				case 3: 
					sc.nextLine();
					System.out.print("Digite o nome do medicamento: ");
					String nome = sc.nextLine();
					estoque.pesquisarRemedio(nome);
					break;					
				case 4:
					break;
				default: 
					System.out.println("Codigo invalido!");
				}
				
				estoque.relatorioEstoque();

			}
		
		
		else {
			System.out.println("ACESSO NEGADO#!");
		}
		
		}
		
		catch(ParseException e) {
			System.out.println("\n----- Formato de data digitado incompativel! -----");
		}
		
		catch(IllegalArgumentException e) {
			System.out.println("\n----- Dado digitado incompativel! Verique se a Marca ou Categoria existem no estoque ! -----");
		}
		
		catch (InputMismatchException e) {
			System.out.println("\n----- Dado digitado incompativel! -----");
		}
		
		
		
		
		sc.close();

	}

}
