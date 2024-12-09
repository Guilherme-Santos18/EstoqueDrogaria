package model.services;

public class Cliente extends Pessoa {
	
	private String rg;
	private Double valor;
	private Integer diasAtraso;
	private Double taxaJuros;

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpf, String endereco, String telefone, String rg) {
		super(nome, cpf, endereco, telefone);
		this.rg = rg;
	}
	
	public Cliente(Double valor, Integer diasAtraso) {
		super();
		this.valor = valor;
		this.diasAtraso = diasAtraso;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public double totalPagar() {
		
		double taxaJuros;
		
		if(diasAtraso == 0 ) {
			taxaJuros = 0;
		}
		else if(diasAtraso <= 15) {
			taxaJuros = 10;
		}
		else {
			taxaJuros = 20;
		}
		
		return valor * 100 + taxaJuros / 100;
		
	}
	
	
	
	@Override
    public String exibirDados() {
        return "Cliente: " + getNome() + "\nCPF: " + getCpf() + "\nTelefone: " + getTelefone()
        + "\nTotal a pagar: " + String.format("%.2f", totalPagar());
	
}
	

}
