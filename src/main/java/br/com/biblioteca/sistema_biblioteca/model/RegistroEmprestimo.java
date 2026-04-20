package br.com.biblioteca.sistema_biblioteca.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "registros")
public class RegistroEmprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransacao;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean finalizado;

    public RegistroEmprestimo(){}
    public RegistroEmprestimo(Usuario usuario, Livro livro){
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.finalizado = false;
    }

    public long getIdTransacao() {
        return idTransacao;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void finalizarEmprestimo(){
        this.dataDevolucao = LocalDate.now();
        this.finalizado = true;
    }

    @Override
    public String toString(){
        return String.format("Transação: %d | Usuário ID: %d | Livro ID: %d | Data: %s | Status: %s",
                idTransacao, usuario.getId(), livro.getId(), dataEmprestimo, (finalizado ? "Devolvido":"Ativo"));
    }
}
