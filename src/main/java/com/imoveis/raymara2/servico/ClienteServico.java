package com.imoveis.raymara2.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.imoveis.raymara2.modelo.Cliente;
import com.imoveis.raymara2.repositorio.Clientes;
import com.imoveis.raymara2.repositorio.filtro.ClienteFiltro;

@Service
public class ClienteServico {
	
	@Autowired
	private Clientes clientes;
	
	@Transactional
	public void salva(Cliente cliente) {
		clientes.save(cliente);		
	}

	public List<Cliente> todosClientes() {
		return clientes.findAll();
	}

	public Cliente buscaPor(Integer id) {
		return this.clientes.findOne(id);
	}
	@Transactional(readOnly=true)
	public List<Cliente> filtrar(ClienteFiltro filtro) {
	    return clientes.filtrar(filtro);
	}
}
