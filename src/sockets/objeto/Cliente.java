package sockets.objeto;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {
        //1 - Abrir conexão
        Socket socket = new Socket("127.0.0.1", 54323);
        
        //2 - Definir stream de saída de dados do cliente
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        Pessoa p = new Pessoa("Rafael Vargas", 38);
        saida.writeObject(p);

        //4 - Fechar streams de saída de dados
        saida.close();

        //5 - Fechar o socket
        socket.close();
    }
}
