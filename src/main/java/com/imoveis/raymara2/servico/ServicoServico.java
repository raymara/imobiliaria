package com.imoveis.raymara2.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imoveis.raymara2.modelo.Servico;
import com.imoveis.raymara2.repositorio.Servicos;

@Service
public class ServicoServico {
	
	@Autowired
	private Servicos servicos;
	
	@Transactional
	public void salva(Servico servico) {
		servicos.save(servico);		
	}

	public List<Servico> todosServicos() {
		return servicos.findAll();
	}

	public Servico buscaPor(Integer id) {
		return this.servicos.findOne(id);
	}
}
