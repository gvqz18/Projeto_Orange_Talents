package br.com.orangetalents.api.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orangetalents.api.clientemodelo.ContaCliente;

	@Transactional
	public interface ClienteRepository extends JpaRepository<ContaCliente, Long> {

		
		
		static ContaCliente findByNome(ClienteRepository clienteRepository) {
			// TODO Auto-generated method stub
			return null;
		}
		
		static ContaCliente findByNome(String id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	 
	}


