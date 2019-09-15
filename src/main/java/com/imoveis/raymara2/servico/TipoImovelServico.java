package com.imoveis.raymara2.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imoveis.raymara2.modelo.TipoImovel;
import com.imoveis.raymara2.repositorio.TipoImoveis;

@Service
public class TipoImovelServico {
	
	@Autowired
	private TipoImoveis tipoimoveis;
	
	@Transactional
	public void salva(TipoImovel tipoimovel) {
		tipoimoveis.save(tipoimovel);		
	}

	public List<TipoImovel> todosTipoImoveis() {
		return tipoimoveis.findAll();
	}

	public TipoImovel buscaPor(Integer id) {
		return this.tipoimoveis.findOne(id);
	}
}
