package br.com.biblioteca.sistema_biblioteca.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "livros")
public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Livro(){}
    public Livro(String titulo, String autor) {
        if (titulo == null || titulo.isBlank()){
            this.titulo = "Título indefinido";
        }else {
            this.titulo = titulo;
        }
        this.autor = autor;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo; }

    public String getAutor() {
        return autor;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;}
    public boolean isDisponivel() {
        return disponivel;}
    public Long getId(){
        return id;
    }

    @Override
    public String toString() {
        return  "Id: " + getId() + "Título: " + this.titulo + " (Autor: " + this.autor + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(titulo, livro.titulo);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(titulo);
    }
}
