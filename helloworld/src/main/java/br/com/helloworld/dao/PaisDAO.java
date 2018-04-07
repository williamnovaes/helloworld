package br.com.helloworld.dao;

import br.com.helloworld.entity.Pais;

public class PaisDAO extends BaseDAO<Pais> {

	private static final long serialVersionUID = 1L;

	public PaisDAO() {
		super(Pais.class);
	}
}
