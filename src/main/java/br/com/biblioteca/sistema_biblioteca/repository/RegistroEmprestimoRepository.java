package br.com.biblioteca.sistema_biblioteca.repository;

import br.com.biblioteca.sistema_biblioteca.model.RegistroEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroEmprestimoRepository extends JpaRepository<RegistroEmprestimo, Long> {

}
