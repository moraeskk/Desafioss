import java.util.Scanner;

public class Main {

    static String[] nomes = new String[20];
    static String[] telefones = new String[20];
    static String nomeExclusao = "";
    static int posicao = 0;

    public static void main(String[] args) {


        exibirmenu();

    }

    public static void exibirmenu() {
        Scanner input = new Scanner(System.in);



        int opcao;
        String continuar = "";

        for (int i = 0; i < 20; i++) {
            nomes[i] = "";
            telefones[i] = "";

        }
        do {
            System.out.println("       |Menu Principal|  ");
            System.out.println("1 - Cadastrar contato na agenda");
            System.out.println("2 - Excluir contato da agenda");
            System.out.println("3 - Listar os contatos da agenda");
            System.out.println("4 - Limpar todos os contatos");
            System.out.println("99 - Sair");

            System.out.println("Escolha a opção desejada: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    do {
                        if (posicao >= 20) {
                            System.out.println("A lista de contatos esta cheia");
                        }
                        input.nextLine();
                        System.out.println("Digite o seu nome: ");
                        nomes[posicao] = input.nextLine();

                        System.out.println("Digite o seu numero de telefone: ");
                        telefones[posicao] = input.nextLine();

                        System.out.println("Contato cadastrado com sucesso!");

                        System.out.print("Deseja adicionar outro contato? ");
                        continuar = input.nextLine();

                        posicao++;

                    } while (continuar.equals("Sim"));
                    break;
                case 2:
                    if (posicao == 0) {
                        System.out.println("Não há contatos cadastrados!");
                    } else {
                        System.out.print("Digite o nome do contato a ser excluído: ");
                        input.nextLine();
                        String nomeExclusao = input.nextLine();
                        for (int i = 0; i < posicao; i++) {
                            if (nomes[i].equals(nomeExclusao)) {
                                for (int j = i; j < posicao - 1; j++) {
                                    nomes[j] = nomes[j + 1];
                                    telefones[j] = telefones[j + 1];
                                }
                                nomes[posicao - 1] = null;
                                telefones[posicao - 1] = null;
                                posicao--;
                            }
                        }
                    }
                    break;

                case 3:
                    for (int i = 0; i < 20; i++) {
                        if (nomes[i] != null){
                            if (!nomes[i].equals("")) {

                                System.out.println("Nome: " + nomes[i] + " " + "telefone: " + telefones[i]);
                            }
                        }
                    }

                    break;
                case 4:
                    nomes = new String[20];
                    telefones = new String[20];
                    posicao = 0;
                    System.out.println("Lista de contatos limpa com sucesso!");
                    break;
                case 99:
                    System.out.println("Finalizado.");
                    return;

                default:
                    System.out.println("Opção invalida! tente novamente.");
                    break;
            }

        } while (opcao != 99);
        input.close();
    }


}