package br.com.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.modelo.Produto;
import br.com.repositorio.ProdutoRepository;

@Controller
@RequestMapping(path="/api/produto") 
@CrossOrigin("*")
public class ProdutoController {

	  
	@Autowired	         
	private ProdutoRepository produtoRepository;

	@PostMapping(path="/")
	  public @ResponseBody String savlvar (@RequestBody Produto produto) {  
		
		produtoRepository.save(produto);
	    return "Produto Salvo "+produto.getNome();
	  }

	  
	  @GetMapping(path="/")
	  public @ResponseBody Iterable<Produto> listarProdutos() {
	    return produtoRepository.findAll();
	  }
	  
	  
	  @GetMapping(path="/{id}")
	  public @ResponseBody Optional<Produto> buscarProduto(@PathVariable Integer id) {
	    return produtoRepository.findById(id);
	  }
	  
	   @PutMapping("/")
	    public @ResponseBody Produto atualizar(@RequestBody Produto produto){
		   
		   produtoRepository.save(produto);
	        return produto;
	    }
	   
	   @DeleteMapping("/{id}")
	    public @ResponseBody String deletar(@PathVariable Integer id){
		   produtoRepository.deleteById(id);
	        return "Produto "+id+" Deletado";
	    }

	}