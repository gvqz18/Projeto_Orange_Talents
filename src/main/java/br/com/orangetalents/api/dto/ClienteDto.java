package br.com.orangetalents.api.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.orangetalents.api.clientemodelo.ContaCliente;


public class ClienteDto {

	private String Nome;
	private String Email;
	private String Cpf;
	private String DataNascimento;
	
	public ClienteDto(ContaCliente cliente) {
		
		this.Nome = cliente.getNome();
		this.Email = cliente.getEmail();
		this.Cpf = cliente.getCpf();
		DataNascimento = cliente.getDataNascimento();
	}
	
	public static List<ClienteDto> converter(List<ContaCliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}

}

