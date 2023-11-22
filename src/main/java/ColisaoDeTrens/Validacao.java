package ColisaoDeTrens;

public class Validacao {
    public static int validarLimite(String valorInserido, int limiteInferior, int limiteSuperior) {
        try {
            int valor = Integer.parseInt(valorInserido);
            if (valor < limiteInferior || valor > limiteSuperior) {
                throw new IllegalArgumentException(String.format("Valor inserido está fora do range entre %d e %d", limiteInferior, limiteSuperior));
            }
            return valor;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Argumentos Invalidos ->"+e.getMessage());
        }
    }
}
