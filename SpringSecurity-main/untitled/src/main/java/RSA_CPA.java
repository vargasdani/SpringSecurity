import java.math.BigInteger;
import java.nio.charset.StandardCharsets;


class RSA_CPA{
    public static void main (String args[]){
        //inicializando as variaveis
        String msg="You are the champtions!";
        String msgcifrada=null;
        String msgdecifrada=null;//="";

        //Decifrando valores
        BigInteger p=new BigInteger("17");
        BigInteger q=new BigInteger("23");
        BigInteger n=p.multiply(q);
        BigInteger e=new BigInteger("3");
        //Computando a função totiente:phi(n) = (p-1)*(q-1)
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        //verificando //essa parte está faltando
    }
    System.out.println("p: "+p);
    System.out.println("q: "+q);
    System.out.println("n: "+n);
    System.out.println("e: "+e);
    System.out.println("d: "+d);

    //mensagem decifrada-rsa decrypt()
    byte[]msgBytes=msg.getBytes(StandardCharsets.US_ASCII);

    StringBuilder cifradaStringBuilder=new StringBuilder();
    for (byte b :msgBytes){
        BigInteger msgBigInt=new BigInteger(new byte[]{b});
        BigInteger cifrada=msgBigInt.modPow(e,n);
        cifradasStringBuilder.append(cifrada).append(" ");
    }
    msgcifrada=cifradaStringBuilder.toString().trim();
    System.out.println("msg cifrada: "+msgcifrada);


    String[] cifradaParts=msgcifrada.split(" ");
    StringBuilder decifradaStringBuilder =new StringBuilder();
    for (String part : cifradaParts){
        BigInteger cifradaBigInt =new BigInteger(part);
        BigInteger decifrada = cifradaBigInt.modPow(d,n);
        decifradaStringBuilder.append((char)decifrada.byteValueExact());
    }
    msgdecifrada = decifradaStringBuilder.toString();
    System.out.println("msg decifrada: "+ msgdecifrada);
}

