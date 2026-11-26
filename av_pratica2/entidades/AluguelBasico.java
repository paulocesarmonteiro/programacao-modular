package entidades;

import enums.StatusAluguel;

public class AluguelBasico extends Aluguel {
    public static final int kmMaximoPorDia = 100;

    public AluguelBasico(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
    }

    public int getKmMaximoPorDia() {
        return kmMaximoPorDia;
    }

    @Override 
    public void exibirDetalhes(){
        System.out.println("Cliente: "+ super.getNomeCliente());
        System.out.println("Quantidade de dias: "+ super.getQuantidadeDias());
        System.out.println("Valor total: "+ super.getValorTotal());
        System.out.println("Status: "+ super.getStatus());
        System.out.println("Quilometragem máxima diária: "+ this.getKmMaximoPorDia());
    }

    @Override 
    public boolean possuiSeguroIncluso(){
        return false;
    }
}
