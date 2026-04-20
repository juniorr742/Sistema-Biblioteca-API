package br.com.biblioteca.sistema_biblioteca.factory;

import br.com.biblioteca.sistema_biblioteca.model.Usuario;
import br.com.biblioteca.sistema_biblioteca.model.Aluno;
import br.com.biblioteca.sistema_biblioteca.model.Professor;

public class UsuarioFactory {
    public static Usuario criarUsuario(int tipo, String nome){
        switch (tipo){
            case 1:
                return new Aluno(nome);
            case 2:
                return new Professor(nome);
            default:
                System.out.println("Tipo de utilizador desconhecido.");
                return null;
        }
    }
}

