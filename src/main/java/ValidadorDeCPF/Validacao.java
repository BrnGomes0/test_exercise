package ValidadorDeCPF;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacao {
    private static String imprimirCPF(String cpf)
    {
        String cpfFormatado="";
        for (int i = 0; i < 9; i++) {
            cpfFormatado=cpfFormatado.concat(String.valueOf(cpf.charAt(i)));
            if (i==2 || i==5)
            {
                cpfFormatado=cpfFormatado.concat(".");
            }
        }
        return cpfFormatado+"-".concat(cpf.substring(9,11));
    }

    public static String gerarValidarCPF(String cpf){
        String cpfDigitado=cpf;
        cpf=cpf.substring(0,9);
        int acumulador=0;
        for (int i = 10; i >1 ; i--) {
            acumulador=acumulador+(i*Integer.parseInt(String.valueOf(cpf.charAt(cpf.length()+1-i))));
        }
        int digito1= 11 -(acumulador%11)>9 ? 0:11-(acumulador%11);
        cpf=cpf+digito1;

        acumulador=0;
        for (int i = 11; i >1 ; i--) {
            acumulador=acumulador+(i*Integer.parseInt(String.valueOf(cpf.charAt(cpf.length()+1-i))));
        }
        int digito2= 11 -(acumulador%11)>9 ? 0:11-(acumulador%11);
        cpf=cpf+digito2;



        if (cpfDigitado.length()==9){
            return "O CPF completo para o que você digitou é " + imprimirCPF(cpf);
        }

        if (cpf.equals(cpfDigitado)){
            return "O CPF que você digitou é valido";
        }
        else {
            return "O CPF que você digitou é invalido" ;
        }
    }
    public static String validarEntrada(String cpf){
        cpf=cpf.replace(".","");
        cpf=cpf.replace("-","");
        String regex ="^[0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cpf);
        if (!matcher.matches())
        {
            throw new IllegalArgumentException("Contém caracteres especiais ou letras");
        }

        if(cpf.length()==11 || cpf.length()==9){
            cpf=gerarValidarCPF(cpf);
        }

        else {
            throw new IllegalArgumentException("Número de caracteres invalido");
        }

        return cpf;
    }
}
