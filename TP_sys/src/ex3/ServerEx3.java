package ex3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



public class ServerEx3 {
    final static int PORT=7878;
    public static void main(String[] args) throws Exception {

                ServerSocket serverSocket = new ServerSocket(PORT);
                System.out.println ("j'attends la connexion d'un client");
                Socket socket = serverSocket.accept();
                System.out.println("Un client est connecté, son IP est :"+socket.getInetAddress());
                try { InputStream IS = socket.getInputStream();
                    InputStreamReader ISR = new InputStreamReader(IS);
                    BufferedReader reader = new BufferedReader(ISR);
                    String requete = reader.readLine();
                    System.out.println("le client a envoyé le message :"+requete);

                    ObjectInputStream OIS = new ObjectInputStream(IS) ;
                    Personne personne = (Personne) OIS.readObject();
                    System.out.println("Nom :" + personne.getNom());
                    System.out.println("Prenom :" + personne.getPrénom());
                    System.out.println("Date de naissance :" + personne.getDate_naissance());

                    OIS.close();
                    reader.close();
                    socket.close();
                    serverSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }

