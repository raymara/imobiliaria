package com.imoveis.raymara2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imoveis.raymara2.modelo.Locacao;

@Repository
public interface Locacoes extends JpaRepository<Locacao, Integer>  {

}
