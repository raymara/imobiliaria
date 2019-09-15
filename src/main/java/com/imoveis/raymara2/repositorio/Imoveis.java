package com.imoveis.raymara2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.imoveis.raymara2.modelo.Imovel;
import com.imoveis.raymara2.repositorio.helper.cliente.ImoveisQueries;


@Repository
public interface Imoveis extends JpaRepository<Imovel, Integer>, ImoveisQueries{

}
