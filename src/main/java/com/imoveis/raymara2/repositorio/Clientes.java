package com.imoveis.raymara2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imoveis.raymara2.modelo.Cliente;
import com.imoveis.raymara2.repositorio.helper.cliente.ClientesQueries;


@Repository
public interface Clientes extends JpaRepository<Cliente, Integer>, ClientesQueries {

}
