package model.services;

import java.util.Date;

public class Fornecedor extends Pessoa{
	
	private String cnpj;
	private Date dataEntrega;
	
	public Fornecedor() {
		super();
	}


	public Fornecedor(String nome, String telefone, String cnpj, Date dataEntrega) {
		super(nome, telefone);
		this.cnpj = cnpj;
		this.dataEntrega = dataEntrega;
	}


	@Override
    public String exibirDados() {
        return "Fornecedor: " + getNome() + "\nCNPJ: " + cnpj + "\nTelefone: " + getTelefone();
	
}

}
