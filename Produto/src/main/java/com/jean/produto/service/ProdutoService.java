package com.jean.produto.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jean.produto.Entity.Produto;
import com.jean.produto.Repositories.ProdutoRepository;


@Transactional
@Service
public class ProdutoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ProdutoRepository prorepo;

	
	public List<Produto> listAll(){
		return prorepo.findAll();
	}
	
	public void salvar(Produto produto) {
		prorepo.save(produto);
	}
	
	public Optional<Produto> get(long id) {
		return prorepo.findById(id);
	}
	
	public void delete(long id) {
		prorepo.deleteById(id);
	}
	
	
}
