import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TCPServer{

	public static void main(String[] args) throws Exception{
		int clientSentence;
		String capitalizedSentece;

		ServerSocket welcomeSocket = new ServerSocket(6789);

		Socket connectionSocket = welcomeSocket.accept();

		BufferedReader inFromClient = new BufferedReader (new InputStreamReader(connectionSocket.getInputStream()));

		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

		clientSentence = inFromClient.read();


		// le info do cliente.txt
	    Scanner scan = new Scanner(new File("Cliente.txt"));
		String[] dataUser = new String[3];
		int cont = 0;
		while(scan.hasNextLine()){
			dataUser[cont] = scan.nextLine();
			cont++;
		}

		switch (clientSentence){
            case 49:
				capitalizedSentece = dataUser[1];
				outToClient.writeBytes(capitalizedSentece);
                break;

            case 50:
                capitalizedSentece = "Nome: " + dataUser[0] +  " | " + "Saldo: " + dataUser[1] + " | " + "CPF: " + dataUser[2];
                outToClient.writeBytes(capitalizedSentece);
                break;


             // mudar informaçoes
            case 51:
                
                break;   

            case 52:
				
				break;
        }
	}
}