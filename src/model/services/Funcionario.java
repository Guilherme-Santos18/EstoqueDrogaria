package model.services;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {
	
	private String codigoAcesso;
	

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String cpf, String endereco, String telefone, String codigoAcesso) {
		super(nome, cpf, endereco, telefone);
		this.codigoAcesso = codigoAcesso;
	}

	public String getCodigoAcesso() {
		return codigoAcesso;
	}

	public void setCodigoAcesso(String codigoAcesso) {
		this.codigoAcesso = codigoAcesso;
	}
	

	@Override
    public String exibirDados() {
        return "Funcionário: " + getNome() + "\nCPF: " + getCpf() + "\nTelefone: " + getTelefone();
}
	
}
