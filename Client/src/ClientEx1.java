import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class ClientEx1 {
    final static int PORT=7878;
    final static String HOST="localhost";
    public static void main(String args[]) throws Exception {
        Scanner myObj = new Scanner(System.in);
        try { Socket socket = new Socket(HOST,PORT);
            OutputStream OS = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(OS);
            String requete = "client request";
            writer.println(requete);
            writer.flush();
            String date = new Date().toString();
            writer.println(date);
            writer.flush();
            do {
                System.out.println("send to server :");
                String userName = myObj.nextLine();
                writer.println(userName);
                writer.flush();
                if (userName.equals("bye")) break;

            }while (true);
            System.out.println("test");
            InputStream IS = socket.getInputStream();
            InputStreamReader ISR = new InputStreamReader(IS);
            BufferedReader reader = new BufferedReader(ISR);
            String response = reader.readLine();
            System.out.println(response);
            writer.close();
            reader.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();}
    }}
