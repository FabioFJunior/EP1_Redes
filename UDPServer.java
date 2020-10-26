import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

    // Inicia a conexão com o socket
    public static DatagramSocket getSocket() throws IOException {
        return new DatagramSocket(6789);
    }

    public static void handleClientConnection(DatagramSocket socket) throws IOException {
        // Recebe pacote de dados
        byte[] receivedData = new byte[1024];
        DatagramPacket packet = new DatagramPacket(receivedData, 1024);
        socket.receive(packet);

        String input = new String(packet.getData());

        DataHandler.replaceInformation(input.split("\n"));
    }
}
