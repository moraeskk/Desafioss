import java.util.ArrayList;

public class BilheteUnicoComum extends BilheteUnico {
    private double saldo;

    public BilheteUnicoComum( Usuario usuario) {
        super(usuario);
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public boolean pagarPassagem() {
        if (saldo >= 5) {
            saldo -= 5;
            System.out.println("Passagem paga com sucesso!Saldo restante: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para pagar a passagem!");
        }
        return false;
    }

    @Override
    public void recarregarBilhete(double valor) {
        saldo += valor;
        System.out.println("Recarga efetuada com sucesso!");
    }
    public String toString() {
        String dados = "";

        dados += "Nome do usuário: " + usuario.getNome() + "\n";
        dados += "Cpf do usuário " + usuario.getCpf() + "\n";
        dados += "Email do usuário: " + usuario.getEmail() + "\n";
        dados += "Número de telefone do usuário: " + usuario.getTelefone() + "\n";
        dados += "Código do bilhete " + this.getCodigo() + "\n";
        dados += "Saldo do usuário: " + this.saldo + "\n";

        return dados;
    }

}
