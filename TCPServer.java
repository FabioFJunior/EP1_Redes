import java.io.*;
import java.net.*;

public class TCPServer {
    // Inicia a conexão com o socket
    public static ServerSocket getSocket() throws IOException {
        return new ServerSocket(6789);
    }

    public static void handleClientConnection(ServerSocket socket) throws IOException {
        // Aceita a conexão do cliente
        Socket connectionSocket = socket.accept();

        // Declara leitores e escritores do cliente
        BufferedReader clientReader = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        OutputStream clientWriter = connectionSocket.getOutputStream();

        // Lê a entrada do cliente
        int clientInput = clientReader.read();

        // Executa opção escolhida pelo cliente
        switch (clientInput) {
            case 49:
                // Devolve saldo
                String accountBalance = DataHandler.getAccountBalance();
                clientWriter.write(accountBalance.getBytes());
                clientWriter.flush();
                break;
            case 50:
                // Devolve todas as informações pessoais
                String accountInformation = DataHandler.getAccountInformation();
                clientWriter.write(accountInformation.getBytes());
                clientWriter.flush();
                break;
        }
    }
}