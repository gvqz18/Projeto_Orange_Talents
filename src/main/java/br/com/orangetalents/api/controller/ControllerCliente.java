package br.com.orangetalents.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.orangetalents.api.clientemodelo.ContaCliente;
import br.com.orangetalents.api.dto.ClienteDto;
import br.com.orangetalents.api.dto.DetalhesDto;
import br.com.orangetalents.api.form.AttCLienteForm;
import br.com.orangetalents.api.form.ClienteForm;
import br.com.orangetalents.api.repository.ClienteRepository;


@RestController
@RequestMapping( "/api")

public class ControllerCliente {
	
	@GetMapping(value="/", produces = "application/json")
	public ResponseEntity<String> heatlh_check(){
		
		return new ResponseEntity<>("health check!", HttpStatus.OK);
	
	}

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public List<ClienteDto> lista(String nomeCliente) {
		if (nomeCliente == null) {
			List<ContaCliente> clientes = clienteRepository.findAll();
			return ClienteDto.converter(clientes);
		} else {
			List<ContaCliente> clientes = (List<ContaCliente>) ClienteRepository.findByNome(nomeCliente);
			return ClienteDto.converter(clientes);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto> cadastrar (@RequestBody ClienteForm form, UriComponentsBuilder uriBuilder) {
		ContaCliente cliente = form.converter(clienteRepository);
		clienteRepository.save(cliente);
		
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDto> detalhar(@PathVariable Long id) {
		Optional<ContaCliente> cliente = clienteRepository.findById(id);
		
		if(cliente.isPresent()) {
			return ResponseEntity.ok(new DetalhesDto(cliente.get()));
	}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizar(@PathVariable Long id, @RequestBody AttCLienteForm form){
		Optional<ContaCliente> optional = clienteRepository.findById(id);
		
		if(optional.isPresent()) {
			ContaCliente cliente = form.atualizar(id, clienteRepository);
			return ResponseEntity.ok(new ClienteDto(cliente));
	}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<ContaCliente> optional = clienteRepository.findById(id);
		if(optional.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
}

    
    
        



