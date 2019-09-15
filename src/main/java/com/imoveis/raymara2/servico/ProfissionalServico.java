package com.imoveis.raymara2.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imoveis.raymara2.modelo.Profissional;
import com.imoveis.raymara2.repositorio.Profissionais;

@Service
public class ProfissionalServico {
	
	@Autowired
	private Profissionais profissionais;
	
	@Transactional
	public void salva(Profissional profissional) {
		profissionais.save(profissional);		
	}

	public List<Profissional> todosProfissionais() {
		return profissionais.findAll();
	}

	public Profissional buscaPor(Integer id) {
		return this.profissionais.findOne(id);
	}
}
