package com.jean.produto.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jean.produto.Entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	
}
