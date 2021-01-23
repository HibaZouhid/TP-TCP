package ex3;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ClientEx3 {
    final static int PORT=7878;
    final static String HOST="localhost";
    public static void main(String[] args) {
        try { Socket socket = new Socket(HOST,PORT);
            OutputStream OS = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(OS);
            String requete = "request";
            writer.println(requete);
            writer.flush();
            ObjectOutputStream OOS = new ObjectOutputStream(OS);
            Personne personne = new Personne("test", "test", new Date());
            OOS.writeObject(personne);
            OOS.flush();
            OOS.close();
            writer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();}
    }
}
