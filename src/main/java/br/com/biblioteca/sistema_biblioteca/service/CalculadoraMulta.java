package br.com.biblioteca.sistema_biblioteca.service;

import br.com.biblioteca.sistema_biblioteca.config.BibliotecaConfig;
import org.springframework.stereotype.Component;


@Component
public class CalculadoraMulta {
    int prazo = BibliotecaConfig.PRAZO_DEVOLUCAO_PADRAO_DIAS;
    double multaDiaria = BibliotecaConfig.VALOR_MULTA_DIARIA;

    public double valorCalculado(int diasCorridos){
        if (diasCorridos < prazo){
            return 0.0;
        }
        double valor = (diasCorridos - prazo) * multaDiaria;
        return valor;
    }
}