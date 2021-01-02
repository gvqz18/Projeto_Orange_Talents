package br.com.orangetalents.api.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.orangetalents.api.clientemodelo.ContaCliente;


public class DetalhesDto {

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String dataNascimento;
	
	public DetalhesDto(Long id, String nome, String email, String cpf, String dataNascimento) {
		
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public DetalhesDto(ContaCliente contaCliente) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

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
	
	
	
	
	
	
	
	
}
