package br.com.orangetalents.api.form;

import com.sun.istack.NotNull;

import br.com.orangetalents.api.clientemodelo.ContaCliente;
import br.com.orangetalents.api.repository.ClienteRepository;

public class AttCLienteForm {

	@NotNull 
	private String nome;
	
	@NotNull 
	private String email;
	
	@NotNull 
	private String cpf;
	
	@NotNull 
	private String dataNascimento;
	
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public ContaCliente atualizar(Long id, ClienteRepository clienteRepository) {
		ContaCliente cliente = ClienteRepository.findByNome(clienteRepository);
		cliente.setNome(this.nome);
		cliente.setEmail(this.email);
		return cliente;
	}
	
}
