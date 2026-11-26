package entidades;

import enums.StatusVeiculo;
import interfaces.Avaliavel;
import interfaces.Inspecionavel;

public class Van extends Veiculo implements Avaliavel, Inspecionavel {
    
    private int qntdMaximaPassageiros;
    private int avaliacao;

    public Van(String placa, String modelo, int anoFabricacao, double valorDiaria, double quilometragem,
            StatusVeiculo status, int qntdMaximaPassageiros) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.qntdMaximaPassageiros = qntdMaximaPassageiros;
    }

    public int getQntdMaximaPassageiros() {
        return qntdMaximaPassageiros;
    }

    public void setQntdMaximaPassageiros(int qntdMaximaPassageiros) {
        this.qntdMaximaPassageiros = qntdMaximaPassageiros;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override 
    public void exibirDetalhes(){
        System.out.println("Placa: "+ super.getPlaca());
        System.out.println("Modelo: "+ super.getModelo());
        System.out.println("Ano de fabricação: "+ super.getAnoFabricacao());
        System.out.println("Quilometragem: "+ super.getQuilometragem());
        System.out.println("Valor da diária: "+ super.getValorDiaria());
        System.out.println("Quantidade máxima de passageiros: "+ this.qntdMaximaPassageiros);
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

    @Override 
    public void realizarInspecao(){
        System.out.println(super.getModelo()+": Inspeção Realizada!");
    }
    
}
