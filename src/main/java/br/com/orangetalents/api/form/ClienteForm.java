package br.com.orangetalents.api.form;


import br.com.orangetalents.api.clientemodelo.ContaCliente;
import br.com.orangetalents.api.repository.ClienteRepository;

public class ClienteForm {

	
	private String nome;
	
	
	private String email;
	
	
	private String cpf;
	
	
	private String dataNascimento;
	
	
	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public String getCpf() {
		return cpf;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public ContaCliente converter(ClienteRepository clienteRepository) {
		ContaCliente cliente = ClienteRepository.findByNome(nome);
		return new ContaCliente(nome, email, cpf, dataNascimento);
	}
}
