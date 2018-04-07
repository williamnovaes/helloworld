package br.com.helloworld.dao;

import br.com.helloworld.entity.Pessoa;

public class PessoaDAO extends BaseDAO<Pessoa> {

	private static final long serialVersionUID = 1L;

	public PessoaDAO() {
		super(Pessoa.class);
	}
}
