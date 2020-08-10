package sockets.objeto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1 - Definir o serverSocket (abrir porta de conexão)
        ServerSocket serverSocket = new ServerSocket(54323);
        System.out.println("A porta 54323 foi aberta!");
        System.out.println("Servidor esperando receber objeto de cliente...");
        //2 - Aguardar solicitação de conexão de cliente
        Socket socket = serverSocket.accept();
        //Mostrar endereço IP do cliente conectado
        System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado");
            
        //3 - Definir stream de entrada de dados no servidor
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        Pessoa p = (Pessoa) entrada.readObject();
        System.out.println("Nome: " + p.getNome() + "\nIdade: " + p.getIdade());
            
        //5 - Fechar streams de entrada de dados
        entrada.close();
            
        //6 - Fechar sockets de comunicação e conexão
        socket.close();
        serverSocket.close();
    }
}
