package com.imoveis.raymara2.repositorio.helper.cliente;

import java.util.List;

import com.imoveis.raymara2.modelo.Imovel;
import com.imoveis.raymara2.repositorio.filtro.ImovelFiltro;

public interface ImoveisQueries {
	
	List<Imovel> filtrar(ImovelFiltro filtro);

}
