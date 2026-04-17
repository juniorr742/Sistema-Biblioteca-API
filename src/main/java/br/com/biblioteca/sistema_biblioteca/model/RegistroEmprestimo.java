package br.com.biblioteca.sistema_biblioteca.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "registros")
public class RegistroEmprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransacao;
    private long idUsuario;
    private long idLivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean finalizado;

    public RegistroEmprestimo(){}
    public RegistroEmprestimo(long idUsuario, long idLivro){
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
        this.dataEmprestimo = LocalDate.now();
        this.finalizado = false;
    }

    public long getIdTransacao() {
        return idTransacao;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public long getIdLivro() {
        return idLivro;
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
                idTransacao, idUsuario, idLivro, dataEmprestimo, (finalizado ? "Devolvido":"Ativo"));
    }
}
