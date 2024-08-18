package devandroid.marcell.appgaseta1.apoio;

public class UtilGasEta {

    public void metodoNaoEstatico(){

    }

    public static void metodoStatico() {



    }

    public static String mensagem() {
        return "Qualquer mensagem...";
    }

    public static double preco() {
        return 9.99;
    }

    public static String calcularMelhorPreco(double gasolina, double etanol) {

        double precoIdeal = gasolina * .70;
        String mensagemDeRetorno;

        if (etanol <= precoIdeal) {
            mensagemDeRetorno = "Abastecer com Etanol";

        } else {
            mensagemDeRetorno = "Abastecer com gasolina";
        }

        return mensagemDeRetorno;
    }

}
