package br.com.biblioteca.sistema_biblioteca.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("Professor")
public class  Professor extends Usuario {
    public Professor(){}
    public Professor(String nome){
        super(nome);
    }

    @Override
    public double getLimiteSaldo(){
        return 100;
    }
    @Override
    public int getLimiteLivros(){
        return 10;
    }
    @Override
    public String obterTipo(){
        return "Professor";
    }

}
