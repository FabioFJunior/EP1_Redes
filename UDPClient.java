import java.net.InetAddress;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String name = scanner.nextLine();

        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        // Cria pacote para enviar via socket
        byte[] message = (name + "\n" + cpf + "\n").getBytes();
        DatagramPacket packet = new DatagramPacket(message, message.length,
                InetAddress.getByName("127.0.0.1"), 6789);

        socket.send(packet);
    }
}
