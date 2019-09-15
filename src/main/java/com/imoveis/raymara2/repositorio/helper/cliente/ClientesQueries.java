package com.imoveis.raymara2.repositorio.helper.cliente;

import java.util.List;

import com.imoveis.raymara2.modelo.Cliente;
import com.imoveis.raymara2.repositorio.filtro.ClienteFiltro;

public interface ClientesQueries {
	
	List<Cliente> filtrar(ClienteFiltro filtro);

}
