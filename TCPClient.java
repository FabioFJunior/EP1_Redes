import java.io.*;
import java.net.*;

public class TCPClient{

	public static void main(String[] args) throws Exception{
		String sentence;
		String modifiedSentence;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		Socket clientSocket = new Socket("192.168.0.15", 6789);

		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		sentence = inFromUser.readLine();

	


		// envia para o server
		outToServer.writeBytes(sentence + '\n');
		// recebe do server a resposta n ta passando dessa linha
		modifiedSentence = inFromServer.readLine();


		System.out.print(modifiedSentence + '\n');
		clientSocket.close();


	}




}