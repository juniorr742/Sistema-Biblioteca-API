package br.com.biblioteca.sistema_biblioteca.repository;

import br.com.biblioteca.sistema_biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

  public interface LivroRepository extends JpaRepository<Livro, Long> {

    }

