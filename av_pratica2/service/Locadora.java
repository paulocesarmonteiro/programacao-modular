package service;

import entidades.Aluguel;
import entidades.Veiculo;
import enums.StatusVeiculo;
import interfaces.Avaliavel;
import interfaces.Inspecionavel;
import java.util.ArrayList;
import java.util.List;

public class Locadora {

    private final List<Aluguel> alugueis;
    private final List<Veiculo> veiculos;
    private final List<Veiculo> inspecionaveis;

    public Locadora() {
        this.alugueis = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.inspecionaveis = null;
    }

    // Cadastro de veiculos
    public void cadastrarVeiculo(Veiculo v) {
        if (v == null) {
            throw new IllegalArgumentException("Veiculo invalido. Cadastre um veículo válido!");
        }
        veiculos.add(v);
    }

    // Cadastro de alugueis
    public void cadastrarAluguel(Aluguel a) {
        if (a == null) {
            throw new IllegalArgumentException("Aluguel invalido. Cadastre um aluguel válido!");
        }
        alugueis.add(a);
    }

    // Associa veículos a um aluguel
    public void associarVeiculoAluguel(Veiculo veiculo, Aluguel aluguel){
        aluguel.adicionarVeiculo(veiculo);
        veiculo.setStatus(StatusVeiculo.ALUGADO);
    }

    // Exibe veículos cadastrados
    public void exibirVeiculosCadastrados(){
        for (Veiculo v : veiculos){
            System.out.println("Placa: "+ v.getPlaca()+" | Modelo: "+ v.getModelo());
        }
    }

    // Exibe alugueis cadastrados
    public void exibirAlugueisCadastrados(){
        for (Aluguel a : alugueis){
            System.out.println("Nome do cliente: "+ a.getNomeCliente()+" | Quantidade de dias: "+ a.getQuantidadeDias()+ " | Valor total: "+ a.getValorTotal()+ " | Status: "+ a.getStatus());
        }
    }

    // Exibe veículos disponíveis
    public void exibirVeiculosDisponiveis(){
        for (Veiculo v : veiculos){
            if (v.getStatus() == StatusVeiculo.DISPONIVEL){
                System.out.println("Placa: "+ v.getPlaca()+" | Modelo: "+ v.getModelo());
            }
        }
    }

    // Exibe veículos que implementam a interface avaliável
    public void exibirVeiculosAvaliaveis(){
        for (Veiculo v : veiculos){
            if (v instanceof Avaliavel){
                System.out.println("Placa: " + v.getPlaca()+ " | Modelo: " + v.getModelo());
            }
        }
    }

    // Retorna um objeto para avaliar
    public Veiculo escolherVeiculoParaAvaliar(String placa){
        for (Veiculo v : veiculos){
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }

        return null;
    }


    // Seleciona veículos que implementam a interface inspecionável
    public void selecionarVeiculosInspecionaveis(){
        for (Veiculo v : veiculos){
            if (v instanceof Inspecionavel) {
                ((Inspecionavel)v).realizarInspecao();
            }
        }
    }

    // Remove veículos em manutenção
    public void removerVeiculosEmManutencao(){
        for (Veiculo v : veiculos){
            if (v.getStatus() == StatusVeiculo.MANUTENCAO) {
                veiculos.remove(v);
            }
        }
    }
}
