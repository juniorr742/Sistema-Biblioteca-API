package br.com.biblioteca.sistema_biblioteca.service;
import br.com.biblioteca.sistema_biblioteca.model.Livro;
import br.com.biblioteca.sistema_biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class ValidadorEmprestimo {

    public boolean podeEmprestar(Usuario usuario, Livro livro){
        boolean jaPossuiEsseExemplar = usuario.getlivroEmprestado().stream()
                .anyMatch(l -> l.getId() == livro.getId());

        if (jaPossuiEsseExemplar){
            System.out.println("ERRO: O usuário já está em posse desse exemplar.");
            return false;
        }

        if (usuario.getSaldo().getSaldoDevedor() >= usuario.getLimiteSaldo()) {
            System.out.println("ERRO: Limite de saldo atingido, por favor realize o pagamento.");
            return false;
        }

        if (usuario.getlivroEmprestado().size() >= usuario.getLimiteLivros()){
            System.out.println("ERRO: Limite de livros atingido, por favor realize a devolução.");
            return false;
        }

        return true;
    }
}
