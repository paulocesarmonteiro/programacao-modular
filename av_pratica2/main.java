import entidades.Aluguel;
import entidades.AluguelBasico;
import entidades.AluguelPremium;
import entidades.Carro;
import entidades.Moto;
import entidades.Van;
import entidades.Veiculo;
import enums.StatusAluguel;
import enums.StatusVeiculo;
import interfaces.Avaliavel;
import java.util.Scanner;
import service.Locadora;

public class main {

    private static final Locadora locadora = new Locadora();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        carregarDadosIniciais();
        exibirMenu();

        System.out.println("Escolha uma opção: ");
        opcao = entrada.nextInt();

        while (opcao != 0){

            switch (opcao){
                case 1:
                    break;
                
                case 2:
                    locadora.exibirVeiculosCadastrados();
                    break;
                
                case 3:
                    locadora.exibirAlugueisCadastrados();
                    break;

                case 4:
                    locadora.exibirVeiculosDisponiveis();
                    break;
                
                case 5:
                    System.out.println("Veiculos disponíveis para avaliação: ");
                    locadora.exibirVeiculosAvaliaveis();

                    System.out.println("Digite a placa do veiculo que deseja avaliar: ");
                    String placa = entrada.nextLine();

                    Veiculo veiculoParaAvaliar = locadora.escolherVeiculoParaAvaliar(placa);

                
                    System.out.println("\nDigite sua nota (0 a 10): ");
                    int nota = entrada.nextInt();

                    ((Avaliavel) veiculoParaAvaliar).avaliar(nota);

                    break;

                case 6:
                    locadora.selecionarVeiculosInspecionaveis();

                    break;
                
                case 7:
                    locadora.removerVeiculosEmManutencao();
                    System.out.println("Veiculos em manutenção removidos com sucesso!");

                    break;
                
            }

            exibirMenu();
            System.out.println("Escolha uma opção: ");
            opcao = entrada.nextInt();

        }
    }

    private static void exibirMenu(){
        System.out.println("BEM-VINDO A LOCADORA DE VEÍCULOS");
        System.out.println("===================================");
        System.out.println("1 - Associar veículo a um aluguel");
        System.out.println("2 - Exibir veículos cadastrados");
        System.out.println("3 - Exibir alugueis cadastrados");
        System.out.println("4 - Exibir veículos disponíveis");
        System.out.println("5 - Avaliar veículos");
        System.out.println("6 - Realizar a inspeção dos veículos");
        System.out.println("7 - Remover veículos em manutenção");
        System.out.println("0 - Encerrar o sistema");
    }

    private static void carregarDadosIniciais(){
        Carro carro = new Carro("OPG-3456", "Fiat Uno Way", 2015, 50, 100000, StatusVeiculo.DISPONIVEL, 4);
        Van van = new Van("RFD-3344", "van", 2023, 20, 70000, StatusVeiculo.DISPONIVEL, 8);
        Moto moto = new Moto("RFP-4455", "Moto XS-203", 2020, 120, 60000, StatusVeiculo.MANUTENCAO, 10);

        locadora.cadastrarVeiculo(carro);
        locadora.cadastrarVeiculo(van);
        locadora.cadastrarVeiculo(moto);

        Aluguel basico = new AluguelBasico("Bernardo", 12, 115, StatusAluguel.ATIVO);
        Aluguel premium = new AluguelPremium("Jonas", 30, 121.20, StatusAluguel.ATIVO);
        locadora.cadastrarAluguel(basico);
        locadora.cadastrarAluguel(premium);

    }


}