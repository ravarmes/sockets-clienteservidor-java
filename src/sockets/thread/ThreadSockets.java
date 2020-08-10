package sockets.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadSockets extends Thread {
    private Socket socket;
    public ThreadSockets(Socket s) {
        this.socket = s;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());//Imprimir o nome da Thread
        try {
            //1 - Definir stream de entrada de dados no servidor
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            String mensagem = entrada.readUTF();//Recebendo mensagem em Minúsculo do Cliente
            String novaMensagem = mensagem.toUpperCase(); //Convertendo em Maiúsculo

            //2 - Definir stream de saída de dados do servidor
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            saida.writeUTF(novaMensagem); //Enviando mensagem em Maiúsculo para Cliente

            //3 - Fechar streams de entrada e saída de dados
            entrada.close();
            saida.close();
            
            //4 - Fechar socket de comunicação
            socket.close();
        } catch (IOException ioe) {
            System.out.println("Erro: " + ioe.toString());
        }
    }
}
