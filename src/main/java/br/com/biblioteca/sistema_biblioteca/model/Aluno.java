package br.com.biblioteca.sistema_biblioteca.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("Aluno")
public class Aluno extends Usuario {
    public Aluno(){}
    public Aluno(String nome){
        super(nome);
    }

    @Override
    public double getLimiteSaldo() {
        return 15;
    }

    @Override
    public int getLimiteLivros(){
        return 3;
    }

    @Override
    public String obterTipo(){
        return "Aluno";
    }
}
