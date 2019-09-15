package com.imoveis.raymara2.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.imoveis.raymara2.modelo.Imovel;
import com.imoveis.raymara2.repositorio.Imoveis;
import com.imoveis.raymara2.repositorio.filtro.ImovelFiltro;

@Service
public class ImovelServico {
	
	@Autowired
	private Imoveis imoveis;
	
	@Transactional
	public void salva(Imovel imovel) {
		imoveis.save(imovel);		
	}

	public List<Imovel> todosImoveis() {
		return imoveis.findAll();
	}

	public Imovel buscaPor(Integer id) {
		return this.imoveis.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public List<Imovel> filtrar(ImovelFiltro filtro) {
	    return imoveis.filtrar(filtro);
	}
}
