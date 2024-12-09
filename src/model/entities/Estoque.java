package model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.entities.enums.Categoria;
import model.entities.enums.Marca;
import model.entities.interfacee.ControleEstoque;

public class Estoque implements ControleEstoque{
	
	List<Medicamento> medicamentos;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Estoque() throws ParseException {
        medicamentos = new ArrayList<>();
     // Estoque pré-definido//
     		medicamentos.add(new Medicamento("Amoxicilina", 35.29, sdf.parse("20/10/2028"), Categoria.tarjaVermelha, 15, Marca.EMS));
     		medicamentos.add(new Medicamento("Alprazolan", 25.29, sdf.parse("28/05/2030"), Categoria.tarjaPreta, 35, Marca.medley));
     		medicamentos.add(new Medicamento("Dipirona", 15.29, sdf.parse("31/12/2027"), Categoria.nenhumaTarja, 150, Marca.neoQuimica));
	}

	@Override
	public void adicionar(Medicamento medicamento) {
		medicamentos.add(medicamento);
	}

	@Override
	public void remover(String nomeMedicamento) {
        // Lista auxiliar para armazenar os medicamentos a serem removidos
        List<Medicamento> medicamentosARemover = new ArrayList<>();
        
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.getNome().equalsIgnoreCase(nomeMedicamento)) {
                medicamentosARemover.add(medicamento);
            }
        }

        // Remover os medicamentos da lista principal após a iteração
        if (!medicamentosARemover.isEmpty()) {
            medicamentos.removeAll(medicamentosARemover);
            System.out.println("Medicamento(s) removido(s) com sucesso!");
        } else {
            System.out.println("Medicamento não encontrado!");
        }
    }

	@Override
	public void pesquisarRemedio(String nome) {
		
		boolean encontrado = false ;
		for(Medicamento m: medicamentos) {
			if(m.getNome().equals(nome)) {
				System.out.println(m);
				encontrado = true;
				break;
			}
		}
		if(!encontrado) {
			System.out.println("Medicamento nao existe no estoque");

		}
	}
	
	@Override
	public void addQuantidade(String nome, int quantidade) {
		
		for(Medicamento m: medicamentos) {
			if(m.getNome().equals(nome)) {
				m.setQuantidade(m.getQuantidade() + quantidade);
			}
		}
	}
	
	@Override
	public void removerQuantidade(String nome,  int quantidade) {
			
			for(Medicamento m: medicamentos) {
				if(m.getNome().equals(nome)) {
					m.setQuantidade(m.getQuantidade() - quantidade);
				}
			}
		}

	@Override
	public void relatorioEstoque() {
		System.out.println("\n--------- RELATORIO DO ESTOQUE --------- ");
		for(Medicamento remedio: medicamentos) {
			System.out.println(remedio + "\n");
		}
		System.out.println("-----------------------------------------");
	}
	
	}
