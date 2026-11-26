package entidades;

import enums.StatusAluguel;

public class AluguelExecutivo extends Aluguel {

    public AluguelExecutivo(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
    }

    @Override 
    public void exibirDetalhes(){
        System.out.println("Cliente: "+ super.getNomeCliente());
        System.out.println("Quantidade de dias: "+ super.getQuantidadeDias());
        System.out.println("Valor total: "+ super.getValorTotal());
        System.out.println("Status: "+ super.getStatus());
        System.out.println("Quilometragem ilimitada!");
        System.out.println("Possui motorista particular.");
    }

    @Override 
    public boolean possuiSeguroIncluso(){
        return true;
    }
}