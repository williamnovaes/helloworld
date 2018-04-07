package br.com.helloworld.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.helloworld.dao.PaisDAO;
import br.com.helloworld.entity.Pais;

@Stateless
public class PaisServico extends BaseServico<Pais> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PaisDAO paisDao;
	
	@Override
	@PostConstruct
	protected void inicializar() {
		setDao(paisDao);
	}
	
	public List<Pais> obterTodos() throws Exception {
		try {
			return paisDao.consultarTodos();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
