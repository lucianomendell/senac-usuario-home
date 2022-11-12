package br.com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.modelo.Usuario;
import br.com.repositorio.UsuarioRepository;

@Controller
@RequestMapping(path="/usuario") 
@CrossOrigin("*")
public class UsuarioController {

	  
	@Autowired	         
	private UsuarioRepository usuariorRepository;

	@PostMapping(path="/adicionar")
	  public @ResponseBody String addNewUser (@RequestParam String nome, @RequestParam String email) {
	  
		 Usuario usuario = new Usuario();
		 usuario.setNome(nome);
		 usuario.setEmail(email);
		 usuariorRepository.save(usuario);
	    return "Salvou usuário "+nome;
	  }

	  
	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<Usuario> getAllUsers() {
	    return usuariorRepository.findAll();
	  }
	}