// Bug numero 1 - quando o usuario entra com um numero errado o while roda 2x

import java.io.*;
import java.net.*;

public class TCPClient{

	public static void main(String[] args) throws Exception{
		int sentence;
		String modifiedSentence;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		Socket clientSocket = new Socket(InetAddress.getByName("localhost"), 6789);

		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	
		System.out.println("Olá! Bem-vindo\nPor favor selecione uma número para continuar:\n");
		System.out.println("\t1: Consular saldo\n\t2: Consultar suas informações\n\t3: Alterar informações\n");

		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		while(true){
			sentence = inFromUser.read();
			// seila pq mas 1 = 49, 2 = 50 e 3 = 51
			 if(sentence == 49 || sentence == 50 || sentence == 51){
			 	outToServer.write(sentence);
			 	break;
			 }

			 else{
			 	System.out.println("Número inválido !!");
			 	System.out.println("Por favor insira um número valido!");
			 	System.out.println("\t1: Consular saldo\n\t2: Consultar suas informações\n\t3: Alterar informações\n");	
			 }
		}

		modifiedSentence = inFromServer.readLine();
		System.out.println(modifiedSentence);
		clientSocket.close();
	}
}