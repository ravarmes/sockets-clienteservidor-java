package sockets.thread;

import java.io.*;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {
        //1 - Abrir conexão
        Socket socket = new Socket("127.0.0.1", 54322);
        
        //2 - Definir stream de saída de dados do cliente
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        saida.writeUTF("rafael"); //Enviar  mensagem em minúsculo para o servidor

        //3 - Definir stream de entrada de dados no cliente
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String novaMensagem = entrada.readUTF();//Receber mensagem em maiúsculo do servidor
        System.out.println(novaMensagem); //Mostrar mensagem em maiúsculo no cliente

        //4 - Fechar streams de entrada e saída
        entrada.close();
        saida.close();

        //5 - Fechar o socket
        socket.close();
    }
}
