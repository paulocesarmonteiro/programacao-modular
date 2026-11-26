package entidades;

import enums.StatusVeiculo;
import interfaces.Inspecionavel;

public class Moto extends Veiculo implements Inspecionavel {
    private int cilindrada;

    public Moto(String placa, String modelo, int anoFabricacao, double valorDiaria, double quilometragem,
            StatusVeiculo status, int cilindrada) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override 
    public void exibirDetalhes(){
        System.out.println("Placa: "+ super.getPlaca());
        System.out.println("Modelo: "+ super.getModelo());
        System.out.println("Ano de fabricação: "+ super.getAnoFabricacao());
        System.out.println("Quilometragem: "+ super.getQuilometragem());
        System.out.println("Valor da diária: "+ super.getValorDiaria());
        System.out.println("Cilindrada: "+ this.cilindrada);
    }

    @Override
    public boolean possuiSeguroEspecial(){
        return false;
    }

    @Override 
    public void realizarInspecao(){
        System.out.println(super.getModelo()+": Inspeção Realizada!");
    }
}
