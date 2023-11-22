package ColisaoDeTrens;
import java.time.LocalTime;
import java.util.Scanner;


public class Main {
    public static int verificacao(int limiteInferior, int limiteSuperior,String mensagem){
        Scanner entrada = new Scanner(System.in);
        while (true){
            try {
                System.out.print(mensagem);
                return Validacao.validarLimite(entrada.nextLine(), limiteInferior, limiteSuperior);
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        double posicaoA, posicaoB, velocidadeA, velocidadeB;
        double tempo, colisao;
        posicaoA=verificacao(0,10000,
                "Digite o valor da posição A: ");
        posicaoB=verificacao(0,10000
                ,"Digite o valor da posição B: ");
        velocidadeA=verificacao(0,300,
                "Digite o valor da velocida A: ");
        velocidadeB=verificacao(-300,0,
                "Digite o valor da velocidade B: ");
        tempo=(posicaoA-posicaoB)/(velocidadeB-velocidadeA);
        colisao=posicaoA+(velocidadeA*tempo);
        LocalTime horario = LocalTime.of(17,0).plusHours((long) tempo);

        System.out.printf("A colisão de trens acontecerá no KM %.0f após %.0f segundos às %s",colisao,tempo*3600,horario.toString());
    }
}