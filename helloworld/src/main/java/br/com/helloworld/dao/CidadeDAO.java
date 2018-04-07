package br.com.helloworld.dao;

import java.util.List;

import br.com.helloworld.entity.Cidade;
import br.com.helloworld.entity.Estado;

public class CidadeDAO extends BaseDAO<Cidade> {

	private static final long serialVersionUID = 1L;

	public CidadeDAO() {
		super(Cidade.class);
	}
	
	public List<Cidade> consutarPorEstado(Estado estado) throws Exception {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT c FROM Cidade c ");
			sql.append(" JOIN FETCH c.estado e ");
			sql.append(" WHERE e =:_estado ");
			sql.append(" ORDER BY c.nome ");
			
			return getEm().createQuery(sql.toString(), Cidade.class)
						  .setParameter("_estado", estado)
						  .getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}