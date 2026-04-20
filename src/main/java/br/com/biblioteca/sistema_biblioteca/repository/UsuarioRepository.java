package br.com.biblioteca.sistema_biblioteca.repository;

import br.com.biblioteca.sistema_biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
