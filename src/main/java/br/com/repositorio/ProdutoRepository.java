package br.com.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.modelo.Produto;


public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
	
	

}
