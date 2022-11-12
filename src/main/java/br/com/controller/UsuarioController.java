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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.modelo.Usuario;
import br.com.repositorio.UsuarioRepository;

@Controller
@RequestMapping(path="/api/usuario") 
@CrossOrigin("*")
public class UsuarioController {

	  
	@Autowired	         
	private UsuarioRepository usuariorRepository;

	@PostMapping(path="/")
	  public @ResponseBody String savlvar (@RequestBody Usuario usuario) {  
		
		 usuariorRepository.save(usuario);
	    return "Usuário Salvo "+usuario.getNome();
	  }

	  
	  @GetMapping(path="/")
	  public @ResponseBody Iterable<Usuario> listarUsuarios() {
	    return usuariorRepository.findAll();
	  }
	  
	  
	  @GetMapping(path="/{id}")
	  public @ResponseBody Optional<Usuario> buscarUsuario(@PathVariable Integer id) {
	    return usuariorRepository.findById(id);
	  }
	  
	   @PutMapping("/")
	    public @ResponseBody Usuario atualizar(@RequestBody Usuario usuario){
		   usuariorRepository.save(usuario);
	        return usuario;
	    }
	   
	   @DeleteMapping("/{id}")
	    public @ResponseBody String deletar(@PathVariable Integer id){
		   usuariorRepository.deleteById(id);
	        return "Usuário "+id+" Deletado";
	    }

	}