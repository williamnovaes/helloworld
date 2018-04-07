package br.com.helloworld.dao;

import java.util.List;

import javax.ejb.Local;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Local(InterfaceDAO.class)
public abstract class BaseDAO<T> implements InterfaceDAO<T> {
	
	private static final long serialVersionUID = 1L;
	
	@Produces
	@PersistenceContext(name = "helloWorldPU")
	private EntityManager entityManager;
	
	private Class<T> classe;
	
	public BaseDAO(Class<T> classe) {
		this.classe = classe;
	}
	
	@Override
	public T salvar(T t) throws Exception {
		try {
			entityManager.persist(t);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public T alterar(T t) throws Exception {
		try {
			entityManager.merge(t);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public List<T> consultarTodos() throws Exception {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT obj FROM ").append(getClasse().getSimpleName()).append(" obj ");
			
			return entityManager.createQuery(sql.toString(), getClasse()).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public T consultarPorId(Integer id) throws Exception {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT obj FROM ").append(getClasse().getSimpleName()).append(" obj ");
			sql.append(" WHERE obj.id =:_id ");
			
			return entityManager.createQuery(sql.toString(), getClasse())
					 .setParameter("_id", id)
					 .getSingleResult();
			
		} catch (NoResultException ex) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public EntityManager getEm() {
		return entityManager;
	}
	
	public Class<T> getClasse() {
		return classe;
	}
}
