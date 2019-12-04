package com.jean.produto.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jean.produto.Entity.Produto;
import com.jean.produto.service.ProdutoService;

@Controller
public class ProdutoController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProdutoService proServ;
    
	@RequestMapping("/")
	public String viewHome(Model model) {
		List<Produto> listaProduto = proServ.listAll();
		model.addAttribute("listaProduto", listaProduto);
		
		return "index";
	}
	
	@RequestMapping("/novo")
	public String TelaNovoProduto(Model model) {
		Produto produto = new Produto();
		model.addAttribute("produto",produto);
		
		return "novoProduto";
		
	}
	
	@RequestMapping(value ="/salvar", method = RequestMethod.POST)
	public String salvarProduto(@ModelAttribute("produto") Produto produto) {
		
		proServ.salvar(produto);
		
		return "redirect:/";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView EditarProdutoPagina(@PathVariable(name = "id")int id) {
		
		ModelAndView modViw = new ModelAndView("editarProduto");
		Optional<Produto> produto = proServ.get(id);
		modViw.addObject("produto", produto);
		
		return modViw;
	}

	@RequestMapping("/delete/{id}")
	public String deletePagina(@PathVariable(name = "id")int id) {
		
		 proServ.delete(id);	
		
		return "redirect:/";
	}
	
}
