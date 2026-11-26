package entidades;

import enums.StatusVeiculo;
import interfaces.Avaliavel;

public class Carro extends Veiculo implements Avaliavel{

    private int quantidadePortas;
    private int avaliacao;

    public Carro(String placa, String modelo, int anoFabricacao, double valorDiaria, double quilometragem,
            StatusVeiculo status, int quantidadePortas) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.quantidadePortas = quantidadePortas;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public int getAvaliacao() {
        return avaliacao;
    }
    
    @Override 
    public void exibirDetalhes(){
        System.out.println("Placa: "+ super.getPlaca());
        System.out.println("Modelo: "+ super.getModelo());
        System.out.println("Ano de fabricação: "+ super.getAnoFabricacao());
        System.out.println("Quilometragem: "+ super.getQuilometragem());
        System.out.println("Valor da diária: "+ super.getValorDiaria());
        System.out.println("Quantidade de portas: "+ this.quantidadePortas);
    }

    @Override
    public boolean possuiSeguroEspecial(){
        return false;
    }

    @Override 
    public void avaliar(int nota){
        if (nota >= 0 && nota <= 10){
            this.avaliacao = nota;
        }
    }
}
