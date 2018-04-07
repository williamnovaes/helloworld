package br.com.helloworld.service;

import br.com.helloworld.dao.InterfaceDAO;

public abstract class BaseServico<T> implements InterfaceServico<T> {

	private static final long serialVersionUID = 1L;

	private InterfaceDAO<T> dao;
	
	protected abstract void inicializar();
	
	@Override
	public T salvar(T t) throws Exception {
		try {
			 T f = dao.salvar(t);
			 return f;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Erro ao salvar: " + t + ex.getMessage());
		}
	}

	@Override
	public T alterar(T t) throws Exception {
		try {
			return dao.alterar(t);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public InterfaceDAO<T> getDao() {
		return dao;
	}
	
	public void setDao(InterfaceDAO<T> dao) {
		this.dao = dao;
	}
}
