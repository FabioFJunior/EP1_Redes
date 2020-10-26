import java.util.Scanner;
import java.net.InetAddress;
import java.io.*;
import java.net.*;

public class MainClient {

	public static void limpaTela() throws Exception {
		for(int i = 0; i < 50; i++)
			System.out.println();
	}

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);

		System.out.println("Olá! Bem-vindo\nPor favor selecione uma número para continuar:\n");
		System.out.println("\t1: TCP\n\t2: UDP\n");
		



		int entrada = scan.nextInt();
		limpaTela();

		switch(entrada){
			case 1: System.out.println("============================ TCP ============================");
				int sentence;
				String modifiedSentence;

				BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

				Socket clientSocket = new Socket(InetAddress.getByName("localhost"), 6789);

				DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			
				System.out.println("Para continuar...\nPor favor selecione uma número para continuar:\n");
				System.out.println("\t1: Consultar saldo\n\t2: Consultar suas informações\n");

				BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

				while(true){
					sentence = inFromUser.read();
					
					 if(sentence == 49 || sentence == 50){
					 	outToServer.write(sentence);
					 	break;
					 }

					 else{
					 	System.out.println("Número inválido !!");
					 	System.out.println("Por favor insira um número valido!");
					 	System.out.println("\t1: Consultar saldo\n\t2: Consultar suas informações\n");
					 }

				}
				
				limpaTela();
				modifiedSentence = inFromServer.readLine();
				System.out.println("Resultado da sua chamada: \n\t" + modifiedSentence + "\n\n");
				clientSocket.close();
				break;

			case 2: System.out.println("============================ UDP ============================");
				DatagramSocket socket = new DatagramSocket();
		        Scanner scanner = new Scanner(System.in);

		        System.out.println("Digite seu nome: ");
		        String name = scanner.nextLine();

		        System.out.println("Digite seu CPF: ");
		        String cpf = scanner.nextLine();

		        // Cria pacote para enviar via socket
		        byte[] message = (name + "\n" + cpf + "\n").getBytes();
		        DatagramPacket packet = new DatagramPacket(message, message.length,
		                InetAddress.getByName("localhost"), 6789);

		      

		        socket.send(packet);
				break;


		}





	}				


}
