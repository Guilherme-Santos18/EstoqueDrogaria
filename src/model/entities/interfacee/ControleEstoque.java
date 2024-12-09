package model.entities.interfacee;

import java.util.List;

import model.entities.Medicamento;

public interface ControleEstoque {

	void adicionar(Medicamento medicamento);
	void remover(String nome);
    void pesquisarRemedio(String nome);
    void addQuantidade(String nome, int quantidade );
    void removerQuantidade(String nome, int quantidade );
    void relatorioEstoque();

}
