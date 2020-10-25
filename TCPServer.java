import java.io.*;
import java.net.*;

public class TCPServer{

	public static void main(String[] args) throws Exception{
		String clientSentence;
		String capitalizedSentece;

		ServerSocket welcomeSocket = new ServerSocket(6789);


			Socket connectionSocket = welcomeSocket.accept();

			BufferedReader inFromClient = new BufferedReader (new InputStreamReader(connectionSocket.getInputStream()));

			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			clientSentence = inFromClient.readLine();
			capitalizedSentece = clientSentence.toUpperCase();

			outToClient.writeBytes(capitalizedSentece);

		


	}



}