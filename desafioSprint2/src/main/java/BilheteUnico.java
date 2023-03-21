import java.util.Random;

public abstract class BilheteUnico {
    public Usuario usuario;

    String codigo;

    public BilheteUnico(Usuario usuario) {
        this.usuario = usuario;
        this.codigo = geraCodigo();
    }

    public String geraCodigo() {

        int bilhete;

        Random random = new Random();
        bilhete = (int) (random.nextDouble() * 1000);

        return String.valueOf(bilhete);
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public abstract boolean pagarPassagem();

    public void recarregarBilhete(double v) {

    }

    public String getCodigo() {
        return codigo;
    }

    public void recarregarBilhete() {
    }

    public String pesquisaCpf() {
        String dados = "";

        dados += "Nome do usuário: " + usuario.getNome() + "\n";
        dados += "Cpf do usuário " + usuario.getCpf() + "\n";
        dados += "Email do usuário: " + usuario.getEmail() + "\n";
        dados += "Número de telefone do usuário: " + usuario.getTelefone() + "\n";
        dados += "Código do bilhete " + this.getCodigo() + "\n";

        if(this instanceof BilheteUnicoEstudante){


            dados += "Saldo do usuário: " + ((BilheteUnicoEstudante) this).cota + "\n";

        }if (this instanceof BilheteUnicoComum){

            dados += "Saldo do usuário: " + ((BilheteUnicoComum) this).getSaldo() + "\n";

        }


            return dados;

    }
}




