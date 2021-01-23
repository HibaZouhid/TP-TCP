import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Stream;

public class ServeurEx1 {
    final static int PORT=7878;
    public static void main(String args[]) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println ("j'attends la connexion d'un client");
        Socket socket = serverSocket.accept();
        System.out.println("Un client est connecté, son IP est :"+socket.getInetAddress());
        try { InputStream IS = socket.getInputStream();
            InputStreamReader ISR = new InputStreamReader(IS);
            BufferedReader reader = new BufferedReader(ISR);
            String requete = reader.readLine();
            System.out.println("le client a envoyé le message :"+requete);
            String requetes = reader.readLine();
            System.out.println( requetes);
do {
    String buffMaj = reader.readLine();

    if (buffMaj.equals("bye")) break;
    System.out.println(buffMaj.toUpperCase());
}while (true);
            System.out.println("END !!");
            OutputStream OS = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(OS);
            writer.println("server : vous avez quitté");
            writer.flush();
            reader.close();
            writer.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
