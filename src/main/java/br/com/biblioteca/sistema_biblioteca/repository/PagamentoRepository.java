package br.com.biblioteca.sistema_biblioteca.repository;

import br.com.biblioteca.sistema_biblioteca.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {


}
