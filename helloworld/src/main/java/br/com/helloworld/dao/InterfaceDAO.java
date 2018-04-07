package br.com.helloworld.dao;

import java.io.Serializable;

public interface InterfaceDAO<T> extends Serializable {
	
	T salvar(final T t) throws Exception;
	
	T alterar(final T t) throws Exception;
}
