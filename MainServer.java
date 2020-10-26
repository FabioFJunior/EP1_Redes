import java.io.IOException;
import java.net.BindException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Scanner;

public class MainServer {

    public static void main (String[] args) throws IOException {
        System.out.println("Para usar um servidor TCP, digite 1. Para um servidor UDP, digite 2");
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();

        if (line.equals("1")) {
            executeTCPServer();
        } else if (line.equals("2")) {
            executeUDPServer();
        } else {
            System.out.println("Por favor, escolha entre os valores apresentados");
        }
    }

    private static void executeTCPServer() throws IOException {
        // Tenta sempre reabrir o servidor TCP para novas conexões caso ele feche
        boolean firstTime = true;
        while (true) {
            try {
                ServerSocket tcpServer = TCPServer.getSocket();
                TCPServer.handleClientConnection(tcpServer);
                firstTime = false;
            } catch (BindException e) {
                if (firstTime) {
                    System.out.println("Libere a porta 6789");
                }
            }
        }
    }

    private static void executeUDPServer() throws IOException {
        // Tenta sempre reabrir o servidor UDP para novas conexões caso ele feche
        boolean firstTime = true;
        while (true) {
            try {
                DatagramSocket udpServer = UDPServer.getSocket();
                UDPServer.handleClientConnection(udpServer);
                firstTime = false;
            } catch (BindException e) {
                if (firstTime) {
                    System.out.println("Libere a porta 6789");
                }
            }
        }
    }
}
