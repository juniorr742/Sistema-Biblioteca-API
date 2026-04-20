package br.com.biblioteca.sistema_biblioteca.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario")
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Transient
    private List<Livro> livroEmprestado;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pagamento_id")
    private Pagamento saldo;


    public Usuario(){}
    public Usuario (String nome){
        this.nome = nome;
        this.livroEmprestado = new ArrayList<>();
        this.saldo = new Pagamento();
    }

    public void adicionarLivro(Livro livro){
        this.livroEmprestado.add(livro);
    }

    public void removerLivro(Livro livro){
        this.livroEmprestado.removeIf(l -> l.getId() == livro.getId());
    }

    public String getNome(){return nome;}
    public Long getId(){return id;}
    public  List<Livro> getlivroEmprestado(){return Collections.unmodifiableList(livroEmprestado);}
    public Pagamento getSaldo() {
        return saldo;
    }

    public abstract double getLimiteSaldo();
    public abstract int getLimiteLivros();

    public abstract String obterTipo();

    @Override
    public String toString() {
        return "Nome: " + this.nome + " | ID: " + this.id + " | Saldo: R$ " + this.saldo;
    }

}
