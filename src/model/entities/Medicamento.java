package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.entities.enums.Categoria;
import model.entities.enums.Marca;

public class Medicamento {
	
	private String nome;
	private Double preco;
	private Date dataValidade;
	private Categoria categoria;
	private Integer quantidade;
	private Marca marcaRemedio;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Medicamento() {
		super();
	}

	public Medicamento(String nome, Double preco, Date dataValidade, Categoria categoria, Integer quantidade,
			Marca marcaRemedio) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.dataValidade = dataValidade;
		this.categoria = categoria;
		this.quantidade = quantidade;
		this.marcaRemedio = marcaRemedio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Marca getMarcaRemedio() {
		return marcaRemedio;
	}

	public void setMarcaRemedio(Marca marcaRemedio) {
		this.marcaRemedio = marcaRemedio;
	}
	
	@Override
	public String toString() {
		return "Dados do " + nome + "\n"
				+ "Preco: " + String.format("%.2f", preco) + "\n"
				+ "Data de validade: " + sdf.format(dataValidade) + "\n"
				+ "Categoria: " + categoria + "\n"
				+ "Quantidade: " + quantidade + "\n"
				+ "Marca: " + marcaRemedio;
				
	}

}
