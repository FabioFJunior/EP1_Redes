import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataHandler {

    public static String getAccountBalance() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Cliente.txt"));

        // Descarta as primeiras linhas
        scan.nextLine();
        scan.nextLine();

        // Retorna a última linha
        return scan.nextLine();
    }

    public static String getAccountInformation() throws FileNotFoundException {
        // Lê a informação contida no Cliente.txt
        Scanner scan = new Scanner(new File("Cliente.txt"));
        String[] dataUser = new String[3];
        for (int i = 0; i < 3; i++) {
            dataUser[i] = scan.nextLine();
        }

        return "Nome: " + dataUser[0]
                + " | " + "CPF: " + dataUser[2];
    }

    public static void replaceInformation(String[] information) throws IOException {
        File file = new File("Cliente.txt");

        // Lê a informação contida no Cliente.txt
        Scanner scan = new Scanner(file);
        String[] dataUser = new String[3];
        for (int i = 0; i < 3; i++) {
            dataUser[i] = scan.nextLine();
        }

        // Atualiza informações
        dataUser[0] = information[0];
        dataUser[2] = information[1];

        // Escreve no arquivo
        FileWriter writer = new FileWriter(file, false);
        writer.write(String.join("\n", dataUser));

        writer.close();
    }
}
