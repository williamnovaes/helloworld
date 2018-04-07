package br.com.helloworld.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.helloworld.dao.EstadoDAO;
import br.com.helloworld.entity.Estado;

@Stateless
public class EstadoServico extends BaseServico<Estado> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EstadoDAO estadoDao;
	
	@Override
	@PostConstruct
	protected void inicializar() {
		setDao(estadoDao);
	}
	
	public List<Estado> obterTodos() throws Exception {
		try {
			return estadoDao.consultarTodos();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Estado obterPorId(Integer id) throws Exception {
		try {
			return estadoDao.consultarPorId(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Estado obterPorUf(String uf) throws Exception {
		try {
			return estadoDao.consultarPorUf(uf);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}