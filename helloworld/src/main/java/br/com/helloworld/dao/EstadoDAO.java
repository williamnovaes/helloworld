package br.com.helloworld.dao;

import javax.persistence.NoResultException;

import br.com.helloworld.entity.Estado;

public class EstadoDAO extends BaseDAO<Estado> {

	private static final long serialVersionUID = 1L;

	public EstadoDAO() {
		super(Estado.class);
	}

	public Estado consultarPorUf(String uf) throws Exception {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT e FROM Estado e ");
			sql.append(" WHERE e.uf =:_uf ");
			
			return getEm().createQuery(sql.toString(), Estado.class)
						  .setParameter("_uf", uf)
						  .getSingleResult();
		} catch (NoResultException ex) {
			return null;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
