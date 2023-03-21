public class BilheteUnicoEstudante extends BilheteUnico {

    public double cota;

    public BilheteUnicoEstudante(Usuario usuario) {
        super(usuario);
        double cota = this.cota;
    }
    public double getCota() {
        return cota;
    }

    public boolean pagarPassagem() {
        if (cota >= 1) {
            cota -= 1;
            System.out.println("Passagem paga,Saldo restante: " + cota);
        } else {
            System.out.println("Saldo insuficiente. Por favor,Recarregue seu bilhete. ");
        }
        return false;
    }

    @Override
    public void recarregarBilhete() {
        cota += 48;
        System.out.println("Bilhete recarregado. Saldo atual: " + cota);

    }

    public String toString() {
        String dados = "";

        dados += "Nome do usuário: " + usuario.getNome() + "\n";
        dados += "Cpf do usuário " + usuario.getCpf() + "\n";
        dados += "Email do usuário: " + usuario.getEmail() + "\n";
        dados += "Número de telefone do usuário: " + usuario.getTelefone() + "\n";
        dados += "Código do bilhete " + this.getCodigo() + "\n";
        dados += "Valor da cota:  " + this.cota + "\n";

        return dados;
    }


}

