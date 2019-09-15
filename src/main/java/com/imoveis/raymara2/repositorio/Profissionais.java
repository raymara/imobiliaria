package com.imoveis.raymara2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imoveis.raymara2.modelo.Profissional;

@Repository
public interface Profissionais extends JpaRepository<Profissional, Integer> {

}
