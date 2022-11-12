package br.com.repositorio;
import org.springframework.data.repository.CrudRepository;

import br.com.modelo.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
		

	}
