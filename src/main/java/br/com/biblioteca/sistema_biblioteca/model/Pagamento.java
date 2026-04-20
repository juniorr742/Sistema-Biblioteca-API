package br.com.biblioteca.sistema_biblioteca.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "pagamentos")
public class Pagamento {
    private double saldoDevedor;
    private LocalDateTime dataUltimaOperacao;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    public Pagamento(){
        this.saldoDevedor = 0;
        this.dataUltimaOperacao = LocalDateTime.now();
    }

    public double getSaldoDevedor() {
        return saldoDevedor;
    }

    public LocalDateTime getDataUltimaOperacao() {
        return dataUltimaOperacao;
    }

    public void aumentarDebito(double valor){
        if (valor > 0){
            this.saldoDevedor += valor;
        }else {
            System.out.println("ERRO: valor negativo!");
        }
        atualizarData();
    }

    public void reduzirValor(double valor){
        if (valor > 0 && valor <= this.saldoDevedor){
            this.saldoDevedor -= valor;
            atualizarData();
        }else if (valor > this.saldoDevedor){
            throw new IllegalArgumentException("ERRO: Pagamento maior que o saldo devedor.");
        }else {
            throw new IllegalArgumentException("ERRO: Valor negativo.");
        }
    }

    public void quitarTotalmente(){
        this.saldoDevedor = 0;
        atualizarData();
    }

    public void atualizarData(){
        this.dataUltimaOperacao = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "R$ " + this.saldoDevedor;
    }
}
