import java.util.ArrayList;
import java.util.Scanner;

public class Menu {


    static Scanner input = new Scanner(System.in);
    static ArrayList<BilheteUnico> bilhetes = new ArrayList<>();
    static ArrayList<Usuario> usuario = new ArrayList<>();

    public static void main(String[] args) {
        int opcao = 0;


        do {
            System.out.println("|Menu Principal| ");

            System.out.println("1 — Cadastrar Usuario ");
            System.out.println("2 — Cadastrar Bilhete ");
            System.out.println("3 — Recarregar Bilhete ");
            System.out.println("4 — Pagar Passagem ");
            System.out.println("5 — Listar Bilhetes");
            System.out.println("6 Pesquisar bilhete por cpf");
            System.out.println("99 — Sair");
            try {
                System.out.println("Digite a opção desejada: ");
                opcao = Integer.parseInt(input.nextLine());

                switch (opcao) {
                    case 1:
                        cadastrarUsuario();

                        break;
                    case 2:
                        cadastrarBilhete();

                        System.out.println("Bilhete cadastrado");
                        break;
                    case 3:

                        BilheteUnico bilhete = null;

                        boolean achou = false;

                        System.out.println("Insira seu código: ");
                        String codigo = input.nextLine();

                        for (BilheteUnico value : bilhetes) {
                            if (codigo.equals(value.getCodigo())) {

                                bilhete = value;

                                achou = true;

                            }
                            if (!achou) {

                                System.out.println("Código inválido! Tente novamente.");

                            } else {
                                if (bilhete instanceof BilheteUnicoEstudante) {

                                    bilhete.recarregarBilhete();

                                } else {

                                    System.out.println("Valor da recarga: ");
                                    double valor = input.nextDouble();

                                    bilhete.recarregarBilhete(valor);
                                }

                            }
                        }

                        break;
                    case 4:

                        bilhete = null;

                        achou = false;

                        System.out.println("Insira seu código: ");
                        codigo = input.nextLine();

                        for (BilheteUnico value : bilhetes) {
                            if (codigo.equals(value.getCodigo())) {

                                bilhete = value;

                                achou = true;

                            }
                            if (!achou) {

                                System.out.println("Código inválido! Tente novamente.");

                            } else {
                                if (bilhete instanceof BilheteUnicoEstudante) {

                                    bilhete.pagarPassagem();

                                } else {

                                    System.out.println("Passagem paga!");


                                    bilhete.pagarPassagem();
                                }

                            }
                        }

                        break;
                    case 5:

                        System.out.println("Lista de bilhetes: ");
                        for (int i = 0; i < bilhetes.size(); i++) {
                            if (bilhetes != null) {
                                String dados = "Bilhetes" + "\n" + bilhetes.get(i);
                                System.out.println(dados);
                            }
                        }

                        break;
                    case 6:

                        System.out.println("Digite seu cpf: ");
                        input.nextLine();

                        for (BilheteUnico b1 : bilhetes) {
                            if (b1.equals(b1.usuario.getCpf()));{
                                bilhete = b1;

                                achou = true;
                            }if(!achou){

                                System.out.println("Cpf inválido! Tente Novamente.");
                            }else {
                                if (bilhete instanceof BilheteUnicoEstudante){
                                    ((BilheteUnicoEstudante)bilhete).pesquisaCpf();
                                    System.out.println(bilhete);
                                }else{
                                    bilhete.pesquisaCpf();
                                    System.out.println(bilhete);
                                }
                            }


                        }

                        break;
                    case 99:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }


            } catch (NumberFormatException e) {
                System.out.println("Opção inválida ");
            }
        } while (opcao != 99);

        input.close();
    }

    public static void cadastrarUsuario() {
        System.out.println("Digite o nome do usuário: ");
        String nome = input.nextLine();

        System.out.println("Digite o cpf do usuário: ");
        String cpf = input.nextLine();

        System.out.println("Digite o email do usuário: ");
        String email = input.nextLine();

        System.out.println("Digite o numero de telefone do usuário: ");
        String telefone = input.nextLine();

        Usuario usuarios = new Usuario(nome, cpf, email, telefone);
        usuario.add(usuarios);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public static void cadastrarBilhete() {
        Scanner input = new Scanner(System.in);
        System.out.println("CADASTRO DE BILHETE");

        boolean achou = false;
        System.out.print("Digite o CPF do usuário: ");
        String cpf = input.nextLine();

        BilheteUnico bilhete;

        Usuario dado = null;

        for (Usuario value : usuario) {

            if (cpf.equals(value.getCpf())) {
                dado = value;

                achou = true;
            }
        }

        if (!achou) {
            System.out.println("Cpf invalido! tente novamente.");


        } else {

            System.out.println("Escolha o tipo do bilhete que voce deseja obter");
            System.out.println("1 — Bilhete do tipo comum");
            System.out.println("2 — Bilhete de estudante");
            int tipo = input.nextInt();
            input.nextLine();


            if (tipo == 1) {

                bilhete = new BilheteUnicoComum(dado);

                bilhetes.add(bilhete);
            } else {
                bilhete = new BilheteUnicoEstudante(dado);


                bilhetes.add(bilhete);
            }


        }

    }
}





