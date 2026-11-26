package entidades;

import enums.StatusAluguel;
import java.util.ArrayList;
import java.util.List;


public abstract class Aluguel {

    private String nomeCliente;
    private int quantidadeDias;
    private double valorTotal;
    private StatusAluguel status;

    private final List<Veiculo> veiculos;

    public Aluguel(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {

        this.veiculos = new ArrayList<>();
        this.nomeCliente = nomeCliente;
        this.quantidadeDias = quantidadeDias;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusAluguel getStatus() {
        return status;
    }

    public void setStatus(StatusAluguel status) {
        this.status = status;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("veiculo invalida.");
        }
        if (veiculos.contains(veiculo)) {
            throw new IllegalStateException("veiculo ja associada a este plano.");
        }
        veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("veiculo invalida.");
        }
        
        veiculos.remove(veiculo);
    }

     public abstract void exibirDetalhes();

    public abstract boolean possuiSeguroIncluso();
    
}

