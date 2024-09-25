package org.example;

import java.net.Socket;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Scanner;
import org.example.Conexao;

public class Client {

    //Socket socket;

    public Client() throws Exception {


        public void comunicarComServidor () throws Exception String textoCifrado;
        {
            String textoRequisicao = "Conexao estabelecida";
            String textoRecebido = "";
            String textoDecifrado = "";
            String textoCifrado = "";


        Socket socket = new Socket("localhost", 9600);


        System.out.println("Gerando");
        KeyPair chaves = CriptografiaClienteServidor.gerarChavePublicoPrivada();

        Scanner input = new Scanner(System.in);
        System.out.println("Recebendo chave publica do servidor...");
        PublicKey chavePublica = Conexao.receberChave(socket);

        System.out.println("Recebendo a chave pública do servidor...");
        Conexao.enviarChave(socket, chaves.getPublic());

        System.out.print("\nDigite sua mensagem");
        textoRequisicao = input.nextLine();

        textoCifrado = CriptografiaClienteServidor.cifrar(textoRequisicao, chavePublica);

        System.out.println("Mensagem criptografada enviada:" + textoCifrado);

        textoRecebido = Conexao.receber(socket);

        textoDecifrado = CriptografiaClienteServidor.decifrar(textoRecebido, chaves.getPrivate());

        System.out.println("\nMensagem criptografada recebida:" + textoRecebido);
        System.out.println("Servidor enviou" + textoDecifrado);

        public static void main(String[] args){
            try {
                Client cliente = new Client();
                cliente.comunicarComServidor();
            } catch  (Exception e){
                e.printStackTrace();
            }
        }

    }
}

}