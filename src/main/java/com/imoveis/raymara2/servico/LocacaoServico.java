package com.imoveis.raymara2.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.imoveis.raymara2.modelo.Locacao;
import com.imoveis.raymara2.repositorio.Locacoes;

@Service
public class LocacaoServico {

	@Autowired
	private Locacoes locacoes;
	
	@Transactional
	public void salva(Locacao locacao) {
		locacoes.save(locacao);		
	}

	public List<Locacao> todosLocacoes() {
		return locacoes.findAll();
	}

	public Locacao buscaPor(Integer id) {
		return this.locacoes.findOne(id);
	}
}
